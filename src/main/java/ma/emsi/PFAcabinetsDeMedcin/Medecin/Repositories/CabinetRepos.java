package ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinetRepos extends JpaRepository <Cabinet,Long> {
}
