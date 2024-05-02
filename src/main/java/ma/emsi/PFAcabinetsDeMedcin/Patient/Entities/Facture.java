package ma.emsi.PFAcabinetsDeMedcin.Patient.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float montantTT;
    private Date dateFact;
    private Boolean payee;
    @OneToOne
    private DossierMedical dossierMedical;
}
