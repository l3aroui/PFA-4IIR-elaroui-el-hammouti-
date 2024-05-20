package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    private List<Cabinet> cabinets;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateOuverture;
    @JsonFormat(pattern="HH:mm", timezone="GMT+1")
    private Date HeureOuverture;//Exemple 8AM
    @JsonFormat(pattern="HH:mm", timezone="GMT+1")
    private Date HeureFermeture;//Exemple 16PM
}
