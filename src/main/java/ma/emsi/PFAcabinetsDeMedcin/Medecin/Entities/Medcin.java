package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;


import jakarta.persistence.*;
import lombok.*;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Medcin extends UserApp {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @OneToOne
        private Cabinet cabinet;
        @OneToOne
        private Specialite specialite;
}
