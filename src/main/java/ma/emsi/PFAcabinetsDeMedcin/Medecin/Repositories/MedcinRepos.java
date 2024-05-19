package ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Specialite;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.Addresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedcinRepos extends JpaRepository<Medcin,Long> {
     Medcin findByFirstnameAndLastname(String firstname,String lastname);
     List<Medcin> findByAddresse_CityAndAddresse_CountryAndAddresseCodePostal(String city,String contry,int codepostal);
     List<Medcin> findBySpecialite(Specialite specialite);



}
