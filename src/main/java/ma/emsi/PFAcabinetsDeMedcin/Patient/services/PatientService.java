package ma.emsi.PFAcabinetsDeMedcin.Patient.services;


import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Specialite;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.MedcinRepos;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.Addresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    public final MedcinRepos medcinRepos;
    @Autowired
    public PatientService(MedcinRepos medcinRepos) {
        this.medcinRepos = medcinRepos;
    }

    public List<Medcin> afficherLesMedcin(){
        return medcinRepos.findAll();
    }
    public List<Medcin> afficherParAddresse(Addresse addresse){
        return medcinRepos.findByAddresse(addresse);
    }

    public List<Medcin> afficherParNomEtPrenom(String nom,String prnom){
        return medcinRepos.findByNomAndPrenom(nom,prnom);
    }
    public List<Medcin> afficherParSpecialite(Specialite specialite)
    {
        return medcinRepos.findBySpecialite(specialite);
    }
}
