package ma.emsi.PFAcabinetsDeMedcin.Patient.Services;


import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Specialite;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.MedcinRepos;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.Addresse;
import ma.emsi.PFAcabinetsDeMedcin.User.repositories.AddresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    public final MedcinRepos medcinRepos;
    public final AddresseRepo addresseRepo;
    @Autowired
    public PatientService(MedcinRepos medcinRepos,AddresseRepo addresseRepo) {
        this.medcinRepos = medcinRepos;
        this.addresseRepo=addresseRepo;
    }

    public List<Medcin> afficherLesMedcin(){
        return medcinRepos.findAll();
    }
    public List<Medcin> afficherParAddresse(String city,String contry,int codepostal){
        Addresse addresse=addresseRepo.findByCityAndCodePostalAndCountry(city,codepostal,contry);
        if (addresse.getId()!=null) return medcinRepos.findByAddresse_CityAndAddresse_CountryAndAddresseCodePostal(city,contry,codepostal);
        else throw new RuntimeException("addresse n'existe pas");
    }

    public Medcin afficherParNomEtPrenom(String nomPrenom){
        Medcin medcin=medcinRepos.findByNomPrenom(nomPrenom);
        if (medcin.getId()!=null) return medcinRepos.findByNomPrenom(nomPrenom);
        else throw new RuntimeException("medcin n'existe pas");
    }
    public List<Medcin> afficherParSpecialite(Specialite specialite)
    {
        return medcinRepos.findBySpecialite(specialite);
    }
}
