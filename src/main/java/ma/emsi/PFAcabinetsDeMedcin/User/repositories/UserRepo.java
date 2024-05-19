package ma.emsi.PFAcabinetsDeMedcin.User.repositories;

import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserApp,Long> {
    Optional<UserApp> findByEmail(String email);
}
