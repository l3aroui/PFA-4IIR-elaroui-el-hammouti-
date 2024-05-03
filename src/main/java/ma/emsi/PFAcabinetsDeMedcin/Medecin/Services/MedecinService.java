package ma.emsi.PFAcabinetsDeMedcin.Medecin.Services;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Cabinet;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.CabinetRepos;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.MedcinRepos;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Patient;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.RendezVous;
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


    public void addMedecin(Medcin medcin)
    {
        med.save(medcin);
    }

    public List<Medcin> getAllCabinet()
    {
        return med.findAll();
    }

    public Optional<Medcin> getCabinetById(Long id)
    {
        return med.findById(id);
    }

    public Patient GetPatientByrdv(RendezVous rendezVous)
    {
        return patientRepos.findPatientByRendezVous(rendezVous);
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
    public List<Patient> getAllPatientsValideParMedcin(Medcin medcin)
    {
        List<RendezVous> rdvs = rendezVousRepo.findAllByMedcin(medcin);
        List<Patient> pts = new ArrayList<>();
        for(RendezVous rdv : rdvs )
        {
            if(dossierMedicalRepo.findByRendezVous(rdv) != null)
            {
                pts.add(patientRepos.findPatientByRendezVous(rdv));
            }

        }
        return pts;
    }

}
