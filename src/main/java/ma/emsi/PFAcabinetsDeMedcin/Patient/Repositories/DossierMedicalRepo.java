package ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.DossierMedical;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicalRepo extends JpaRepository<DossierMedical,Long> {

    DossierMedical findByRendezVous(RendezVous rendezVous);
}
