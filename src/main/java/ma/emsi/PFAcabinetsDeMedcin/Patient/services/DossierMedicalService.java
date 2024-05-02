package ma.emsi.PFAcabinetsDeMedcin.Patient.Services;

import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Document;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.DossierMedical;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.Facture;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.RendezVous;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories.DossierMedicalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierMedicalService {
    @Autowired
    private DossierMedicalRepo Dossier;

    public void ValiderRdv(RendezVous rdv, Facture facture, List<Document> document)
    {
        DossierMedical dos = new DossierMedical();
        dos.setFacture(facture);
        dos.setDocument(document);
        dos.setRendezVous(rdv);
        Dossier.save(dos);
    }
}
