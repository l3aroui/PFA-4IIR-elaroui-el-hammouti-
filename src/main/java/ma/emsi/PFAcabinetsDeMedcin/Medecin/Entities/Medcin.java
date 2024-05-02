package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Medcin extends UserApp {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @OneToOne
        private Cabinet cabinet;
        @OneToOne
        private Specialite specialite;

}
