package ma.emsi.PFAcabinetsDeMedcin.User.repositories;

import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<UserApp,Long> {

}
