package ma.emsi.PFAcabinetsDeMedcin.Patient.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;

import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private Patient patient;
    @OneToOne
    private Medcin medcin;
    @ManyToOne
    private Service service;
    @OneToOne
    private DossierMedical dossierMedical;
    private boolean valide = false;
}
