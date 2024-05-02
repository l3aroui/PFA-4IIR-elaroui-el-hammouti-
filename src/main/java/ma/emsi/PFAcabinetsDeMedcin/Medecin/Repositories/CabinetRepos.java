package ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Cabinet;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Disponibilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CabinetRepos extends JpaRepository <Cabinet,Long> {


}
