package ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepos extends JpaRepository<Patient,Long> {
}
