package ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepos extends JpaRepository<Patient,Long> {
}
