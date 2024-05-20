package ma.emsi.PFAcabinetsDeMedcin.auth;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.Token;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;
import ma.emsi.PFAcabinetsDeMedcin.User.repositories.RoleRepo;
import ma.emsi.PFAcabinetsDeMedcin.User.repositories.TokenRepo;
import ma.emsi.PFAcabinetsDeMedcin.User.repositories.UserRepo;
import ma.emsi.PFAcabinetsDeMedcin.User.security.JwtService;
import ma.emsi.PFAcabinetsDeMedcin.email.EmailService;
import ma.emsi.PFAcabinetsDeMedcin.email.EmailTemplateName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final TokenRepo tokenRepo;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Value("${application.mailing.frontend.activation-url}")
    private String activationUrl;

    public void register(RegistrationRequest request) throws MessagingException {
        var userRole = roleRepo.findByName("USER").orElseThrow(() -> new IllegalStateException("Role USER was not initialized"));
        var user = UserApp.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();
        userRepo.save(user);
        sendValidationEmail(user);
    }
    private void sendValidationEmail(UserApp user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);
        emailService.sendEmail(user.getEmail(), user.getFullName(), EmailTemplateName.ACTIVATE_ACCOUNT, activationUrl, newToken, "Account activation");
    }

    private String generateAndSaveActivationToken(UserApp user) {
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .userApp(user)
                .build();
        tokenRepo.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var claims = new HashMap<String, Object>();
        var user = ((UserApp) auth.getPrincipal());
        claims.put("fullName", user.getFullName());
        var jwtToken = jwtService.generateToken(claims, (UserApp) auth.getPrincipal());
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Transactional
    public void activateAccount(String token) throws MessagingException {
        Token savedToken = tokenRepo.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUserApp());
            throw new RuntimeException("Activation token has expired. A new token has been sent");
        }
        var user = userRepo.findById(savedToken.getUserApp().getId())
                .orElseThrow(() -> new RuntimeException("User Not found"));
        user.setEnabled(true);
        userRepo.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepo.save(savedToken);
    }
}

