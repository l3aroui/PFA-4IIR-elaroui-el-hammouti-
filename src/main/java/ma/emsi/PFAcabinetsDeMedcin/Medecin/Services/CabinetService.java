package ma.emsi.PFAcabinetsDeMedcin.Medecin.Services;

import jakarta.annotation.Nullable;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Cabinet;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Disponibilite;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.CabinetRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinetService {
    @Autowired
    private CabinetRepos cabinet ;

    public void addCabinet(Cabinet cab)
    {
        cabinet.save(cab);
    }

    public List<Cabinet> getAllCabinet()
    {
        return cabinet.findAll();
    }

    public Optional<Cabinet> getCabinetById(Long id)
    {
        return cabinet.findById(id);
    }
    public void SetDisponibilite(Cabinet cab , Disponibilite disponibilite)
    {
        if(!cab.getDisponibilites().contains(disponibilite))
        {
            cab.getDisponibilites().add(disponibilite);
            cabinet.save(cab);
        }
    }
}
