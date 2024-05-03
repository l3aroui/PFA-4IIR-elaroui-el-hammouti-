package ma.emsi.PFAcabinetsDeMedcin.Patient.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nom;
    private String type;
    private String path;
    private String Description;
    @ManyToOne
    private DossierMedical dossierMedical;
}
