package ma.emsi.PFAcabinetsDeMedcin.User.repositories;


import ma.emsi.PFAcabinetsDeMedcin.User.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token,Long> {
    Optional<Token> findByToken(String token);

}
