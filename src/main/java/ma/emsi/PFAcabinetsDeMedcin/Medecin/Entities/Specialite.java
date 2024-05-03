package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class Specialite{
    @Id
    private Long id;
    @OneToOne
    private Medcin medcin;
    private String libelle;
}
