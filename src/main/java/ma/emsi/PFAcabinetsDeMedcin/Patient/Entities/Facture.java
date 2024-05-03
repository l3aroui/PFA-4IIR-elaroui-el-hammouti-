package ma.emsi.PFAcabinetsDeMedcin.Patient.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities.Medcin;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float montant;
    private Date dateFact;
    private Boolean payee;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medcin medcin;
}
