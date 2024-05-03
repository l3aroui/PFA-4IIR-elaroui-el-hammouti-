package ma.emsi.PFAcabinetsDeMedcin.Patient.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Patient patient;
    @OneToMany(mappedBy = "dossierMedical")
    private List<Document> document;
    @OneToOne
    private Facture facture;
    @OneToOne
    private RendezVous rendezVous;
}
