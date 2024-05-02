package ma.emsi.PFAcabinetsDeMedcin.Patient.Services;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Entities.RendezVous;
import ma.emsi.PFAcabinetsDeMedcin.Patient.Repositories.RendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {
    @Autowired
    private RendezVousRepo rendezVousRepo;

    public void addRdv(RendezVous red)
    {
        rendezVousRepo.save(red);
    }

    public List<RendezVous> getAllRdv()
    {
        return rendezVousRepo.findAll();
    }

    public Optional<RendezVous> getRdvById(Long id)
    {
        return rendezVousRepo.findById(id);
    }
    public List<RendezVous> getAllRdvByMedcin(Medcin med)
    {
        return rendezVousRepo.findAllByMedcin(med);
    }
}
