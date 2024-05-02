package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor@NoArgsConstructor
@Entity
public class Cabinet {
    @Id
    private Long id;
    @OneToOne
    private Medcin med;
    @OneToMany
    private List<Disponibilite> disponibilites;
    private String localisation;
}
