package ma.emsi.PFAcabinetsDeMedcin.User.repositories;


import ma.emsi.PFAcabinetsDeMedcin.User.entities.Addresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresseRepo extends JpaRepository<Addresse,Long> {
    Addresse findByCityAndCodePostalAndCountry(String city,int codePostal,String country);

}
