package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="dd", timezone="GMT+1")
    private Date Jour;
    @JsonFormat(pattern="HH:mm", timezone="GMT+1")
    private Date DateOuverture;//Exemple 8AM
    @JsonFormat(pattern="HH:mm", timezone="GMT+1")
    private Date DateFermeture;//Exemple 16PM
}
