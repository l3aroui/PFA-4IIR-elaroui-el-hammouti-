package ma.emsi.PFAcabinetsDeMedcin.Patient.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;

@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Medcin medcin;
    @ManyToOne
    private Service service;
    @OneToOne
    private DossierMedical dossierMedical;

}
