package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
@Entity
public class Cabinet {
    @Id
    private Long id;
    @OneToOne
    private Medcin med;
    private String localisation;
}
