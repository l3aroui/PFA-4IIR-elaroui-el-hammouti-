package ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Disponibilite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibiliteRepos extends JpaRepository<Disponibilite,Long> {
}
