package ma.emsi.PFAcabinetsDeMedcin.User.repositories;

import ma.emsi.PFAcabinetsDeMedcin.User.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
}
