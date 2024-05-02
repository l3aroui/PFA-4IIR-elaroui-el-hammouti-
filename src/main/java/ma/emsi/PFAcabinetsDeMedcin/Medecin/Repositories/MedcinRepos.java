package ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedcinRepos extends JpaRepository<Medcin,Long> {
     List<Medcin> findByNomAndPrenom(String nom,String prenom);
     List<Medcin> findByAddresse(String addresse);
     List<Medcin> findBySpecialite(Specialite specialite);

}
