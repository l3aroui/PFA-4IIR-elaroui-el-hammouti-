package ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Patient;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {
    List<RendezVous> findAllByMedcin(Medcin med);



}
