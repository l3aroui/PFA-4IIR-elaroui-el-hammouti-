package ma.emsi.PFAcabinetsDeMedcin.Patient.controllers;

import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;
import ma.emsi.PFAcabinetsDeMedcin.Patient.services.implemetation.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {
    private final PatientServiceImpl patientService;
    @Autowired
    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/allMedcin")
    public List<Medcin> afficherLesMedcin(){
        return patientService.afficherLesMedcin();
    }
    @GetMapping("/byAddress")
    public List<Medcin> afficherParAddresse(@RequestParam("city") String city,@RequestParam("country") String country,@RequestParam("codePostal") int codePostal){
        return patientService.afficherParAddresse(city,country,codePostal);
    }
    @GetMapping("/findMedcinByFullName")
    public Medcin afficherParNomEtPrenom(@RequestParam("nom") String nom,@RequestParam("prenom") @RequestBody String prenom){
        return patientService.afficherParNomEtPrenom(nom,prenom);
    }
    @GetMapping("/findMedcinBy{libelle}")
    public List<Medcin> afficherParSpecialite(@PathVariable("libelle") String libelle){
        return patientService.afficherParSpecialite(libelle);
    }
}