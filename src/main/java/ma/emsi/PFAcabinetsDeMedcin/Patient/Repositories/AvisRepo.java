package ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepo extends JpaRepository<Avis,Long> {

}
