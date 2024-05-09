package ma.emsi.PFAcabinetsDeMedcin.Medecin.controllers;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.DTO.CabinetDTO;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.DTO.DashboardDTO;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Cabinet;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Disponibilite;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecin")
public class MedecinController {
    @Autowired
    private MedecinService medecinService;
    private Medcin medcin ;
    @GetMapping("/{id}")
    public ResponseEntity<DashboardDTO> getDashboard(@PathVariable Long id) throws Exception {
        try{
            medcin = medecinService.getMedecinById(id);
            DashboardDTO dashboardDTO = medecinService.getDashboard(medcin);
            return ResponseEntity.ok(dashboardDTO);
        }catch(Exception e)
        {
            System.out.println("An error occurred while getting medecin by ID: " + id);
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null);
    }
    @GetMapping("/cabinet")
    public ResponseEntity<?> getCabinet() throws Exception
    {
        try {
            Cabinet cabinet = medecinService.getCabinetByMedcin(medcin);
            return ResponseEntity.ok(cabinet);
        } catch (Exception e) {
            System.out.println("An error occurred while getting cabinet by medecin "+ e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching cabinet data.");
        }
    }
    @PostMapping("/cabinet/disponibilite/set")
    public ResponseEntity<?> setDisponibilte(Disponibilite disponibilte)
    {
        try {
            medecinService.SetDisponibilite(medcin,disponibilte);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            System.out.println("An error occurred while setting dispo by medecin "+ e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @PostMapping("/cabinet/disponibilite")
    public ResponseEntity<?> getAllDisponibilites()
    {
        try {
            List<Disponibilite> disponibiliteList =medecinService.getAllDisponibiliteByMedecin(medcin);
            return ResponseEntity.ok(disponibiliteList);
        }catch (Exception e) {
            System.out.println("An error occurred while getting dispo by medecin "+ e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
