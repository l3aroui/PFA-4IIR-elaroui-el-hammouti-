package ma.emsi.PFAcabinetsDeMedcin.Patient.services.implemetation;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Specialite;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.MedcinRepos;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.SpecialiteRepos;

import ma.emsi.PFAcabinetsDeMedcin.Patient.services.PatientService;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.Addresse;
import ma.emsi.PFAcabinetsDeMedcin.User.repositories.AddresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final MedcinRepos medcinRepos;
    private final AddresseRepo addresseRepo;
    private final SpecialiteRepos specialiteRepos;

    @Autowired
    public PatientServiceImpl(MedcinRepos medcinRepos, AddresseRepo addresseRepo, SpecialiteRepos specialiteRepos) {
        this.medcinRepos = medcinRepos;
        this.addresseRepo=addresseRepo;
        this.specialiteRepos=specialiteRepos;
    }
    @Override
    public List<Medcin> afficherLesMedcin(){
        return medcinRepos.findAll();
    }

    @Override
    public List<Medcin> afficherParAddresse(String city,String country,int codePostal) {
        Addresse addresse=addresseRepo.findByCityAndCodePostalAndCountry(city,codePostal,country);
        if (addresse.getId()!=null) return medcinRepos.findByAddresse_CityAndAddresse_CountryAndAddresseCodePostal(city,country,codePostal);
        else throw new RuntimeException("addresse n'existe pas");
    }

    @Override
    public Medcin afficherParNomEtPrenom(String nomPrenom) {
        Medcin medcin=medcinRepos.findByNomPrenom(nomPrenom);
        if (medcin.getId()!=null) return medcin;
        else throw new RuntimeException("medcin n'existe pas");
    }

    @Override
    public List<Medcin> afficherParSpecialite(String libelle) {
        Specialite specialite=specialiteRepos.findByLibelle(libelle);
        if (specialite!=null && specialiteRepos.findByLibelle(libelle)!=null) return medcinRepos.findBySpecialite(specialite);
        else throw new RuntimeException("le specialite n'existe pas ou aucin mdcin a cette specialite pour le moment");
    }

}
