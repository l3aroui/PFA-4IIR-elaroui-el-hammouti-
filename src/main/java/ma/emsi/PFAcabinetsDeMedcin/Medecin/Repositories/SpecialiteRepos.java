package ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteRepos extends JpaRepository<Specialite,Long> {
}
