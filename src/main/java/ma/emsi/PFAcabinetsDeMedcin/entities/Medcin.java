package ma.emsi.PFAcabinetsDeMedcin.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor

public class Medcin extends UserApp{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
