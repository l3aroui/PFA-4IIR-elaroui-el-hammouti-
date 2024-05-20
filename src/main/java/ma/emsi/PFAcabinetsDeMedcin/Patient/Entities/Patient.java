package ma.emsi.PFAcabinetsDeMedcin.Patient.Entities;

import jakarta.persistence.*;
import lombok.*;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;

import java.util.List;


@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "patient")
    private List<Avis> avis;
    @OneToMany(mappedBy = "patient")
    private List<Facture> factures;
    @OneToOne(mappedBy = "patient")
    private DossierMedical dossierMedical;
    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVous;

}
