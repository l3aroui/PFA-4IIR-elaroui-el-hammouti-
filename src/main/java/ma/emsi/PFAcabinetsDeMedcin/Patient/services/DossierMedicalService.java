package ma.emsi.PFAcabinetsDeMedcin.Patient.services;

import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Document;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.DossierMedical;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Facture;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.RendezVous;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories.DossierMedicalRepo;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories.RendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierMedicalService {
    @Autowired
    private DossierMedicalRepo Dossier;
    @Autowired
    private RendezVousRepo rendezVousRepo;


}
