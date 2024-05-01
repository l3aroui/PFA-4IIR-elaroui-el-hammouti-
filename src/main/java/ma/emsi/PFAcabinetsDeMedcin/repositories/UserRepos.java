package ma.emsi.PFAcabinetsDeMedcin.repositories;

import ma.emsi.PFAcabinetsDeMedcin.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<UserApp,Long> {
}
