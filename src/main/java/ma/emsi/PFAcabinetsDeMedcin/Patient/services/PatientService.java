package ma.emsi.PFAcabinetsDeMedcin.Patient.services;


import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {


    public List<Medcin> afficherLesMedcin();
    public List<Medcin> afficherParAddresse(String city,String contry,int codePostal);
    public Medcin afficherParNomEtPrenom(String nomPrenom);
    public List<Medcin> afficherParSpecialite(String libelle);

}
