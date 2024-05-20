package ma.emsi.PFAcabinetsDeMedcin;

import ma.emsi.PFAcabinetsDeMedcin.User.entities.Role;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;
import ma.emsi.PFAcabinetsDeMedcin.User.repositories.RoleRepo;
import ma.emsi.PFAcabinetsDeMedcin.User.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class PfaCabinetsDeMedcinApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PfaCabinetsDeMedcinApplication.class, args);
	}
	private final RoleRepo roleRepo;
	private final UserRepo userRepo;
	@Autowired
	public PfaCabinetsDeMedcinApplication(RoleRepo roleRepo, UserRepo userRepo) {
		this.roleRepo = roleRepo;
		this.userRepo = userRepo;
	}



	@Override
	public void run(String... args) throws Exception {
		if (roleRepo.findByName("USER").isEmpty()){
			roleRepo.save(Role.builder().name("USER").build());
			roleRepo.save(Role.builder().name("ADMIN").build());
		}
	}


}
