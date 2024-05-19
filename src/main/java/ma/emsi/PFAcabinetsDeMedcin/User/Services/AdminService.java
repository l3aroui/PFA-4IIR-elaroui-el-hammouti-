package ma.emsi.PFAcabinetsDeMedcin.User.Services;


import ma.emsi.PFAcabinetsDeMedcin.Medecin.Repositories.CabinetRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private CabinetRepos cabinet;


}
