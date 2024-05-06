package ma.emsi.PFAcabinetsDeMedcin.Medecin.Services;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Cabinet;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Disponibilite;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.CabinetRepos;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.MedcinRepos;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.*;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories.DossierMedicalRepo;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories.PatientRepos;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories.RendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {
    @Autowired
    private MedcinRepos med;
    @Autowired
    private CabinetRepos cab;
    @Autowired
    private PatientRepos patientRepos;
    @Autowired
    private RendezVousRepo rendezVousRepo;
    @Autowired
    private DossierMedicalRepo dossierMedicalRepo;
    @Autowired
    private CabinetRepos cabinetRepos;



    public void addMedecin(Medcin medcin)
    {
        med.save(medcin);
    }

    public Cabinet getCabinetByMedcin(Medcin medcin)
    {
        return medcin.getCabinet();
    }



    public List<RendezVous> GetRdvsByPatient(Patient patient)
    {
        return rendezVousRepo.findAllByPatient(patient);
    }
//    public List<Patient> getAllPatientsByMedcin(Medcin medcin){
//         List<RendezVous> rdvs = rendezVousRepo.findAllByMedcin(medcin);
//         List<Patient> pts = new ArrayList<>();
//         for(RendezVous rdv : rdvs )
//         {
//             pts.add(patientRepos.findPatientByRendezVous(rdv));
//         }
//         return pts;
//    }
    public List<Patient> getAllPatientsValides(Medcin medcin)
    {
        List<RendezVous> rdvs = rendezVousRepo.findAllByMedcin(medcin);
        List<Patient> pts = new ArrayList<>();
        for(RendezVous rdv : rdvs )
        {
            if(rdv.getDossierMedical() != null)
            {
                pts.add(patientRepos.findPatientByRendezVous(rdv));
            }

        }
        return pts;
    }

    public void SetDisponibilite(Medcin med, Disponibilite disponibilite)
    {
        Cabinet cab = med.getCabinet();

        if(!cab.getDisponibilites().contains(disponibilite))
        {
            cab.getDisponibilites().add(disponibilite);
            cabinetRepos.save(cab);
        }
    }

    public void ValiderRdv(RendezVous rdv, Facture facture, List<Document> document)
    {
        DossierMedical dos = new DossierMedical();
        dos.setFacture(facture);
        dos.setDocument(document);
        dos.setRendezVous(rdv);
        rdv.setValide(true);
        dossierMedicalRepo.save(dos);
    }

}
