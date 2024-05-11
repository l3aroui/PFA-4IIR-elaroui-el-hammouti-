package ma.emsi.PFAcabinetsDeMedcin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableJpaAuditing
public class PfaCabinetsDeMedcinApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfaCabinetsDeMedcinApplication.class, args);
	}

}
