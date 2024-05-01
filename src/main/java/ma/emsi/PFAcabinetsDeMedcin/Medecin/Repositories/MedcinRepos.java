package ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepos extends JpaRepository<Medcin,Long> {

}
