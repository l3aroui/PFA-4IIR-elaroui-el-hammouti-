package ma.emsi.PFAcabinetsDeMedcin.Medecin.Services;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Cabinet;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.CabinetRepos;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.MedcinRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {
    @Autowired
    private MedcinRepos med;
    @Autowired
    private CabinetRepos cab;

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

}
