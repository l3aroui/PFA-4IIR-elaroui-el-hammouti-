package ma.emsi.PFAcabinetsDeMedcin.repositories;

import ma.emsi.PFAcabinetsDeMedcin.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepos extends JpaRepository<Patient,Long> {
}
