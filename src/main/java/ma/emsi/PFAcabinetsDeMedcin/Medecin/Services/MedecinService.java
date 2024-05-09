package ma.emsi.PFAcabinetsDeMedcin.Medecin.Services;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.DTO.DashboardDTO;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.print.attribute.standard.MediaName;
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

    public Medcin getMedecinById(Long id) throws Exception {
        return med.findById(id)
                .orElseThrow(() -> new Exception("Medecin with id " + id + " not found"));
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

    public List<RendezVous> getAllRdvs(Medcin medcin)
    {
        return rendezVousRepo.findAllByMedcin(medcin);
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

    public Float getRevenueByMedecin(Medcin medcin)
    {
        List<RendezVous> rdvs = rendezVousRepo.findAllByMedcin(medcin);
        Float tt = (float) 0;

        for(RendezVous rdv : rdvs )
        {
            if(rdv.getDossierMedical() != null)
            {
                tt += rdv.getDossierMedical().getFacture().getMontant();
            }

        }
        return tt;
    }
    public List<Disponibilite> getAllDisponibiliteByMedecin(Medcin medecin)
    {
        Cabinet cabinet = medecin.getCabinet();
        return cabinet.getDisponibilites();

    }

    public DashboardDTO getDashboard(Medcin medcin) throws Exception
    {
        int NmbrPatient = this.getAllPatientsValides(medcin).size();
        int NmbrRdv = this.getAllRdvs(medcin).size();
        float revenue = this.getRevenueByMedecin(medcin);
        DashboardDTO dashboardDTO = new DashboardDTO(revenue,NmbrRdv,NmbrPatient);
        return dashboardDTO;

    }

}
