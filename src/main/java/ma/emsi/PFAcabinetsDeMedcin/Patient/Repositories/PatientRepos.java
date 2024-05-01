package ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.User.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepos extends JpaRepository<Patient,Long> {
}
