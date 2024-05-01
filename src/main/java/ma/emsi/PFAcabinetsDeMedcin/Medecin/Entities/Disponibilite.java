package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
public class Disponibilite {
    @Id
    private Long id;
    @OneToMany
    private List<Cabinet> cabs;
    private String ExtremeHeure;//Exemple 8AM-16PM
}
