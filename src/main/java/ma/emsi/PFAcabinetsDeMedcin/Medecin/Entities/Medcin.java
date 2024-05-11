package ma.emsi.PFAcabinetsDeMedcin.Medecin.Entities;


import jakarta.persistence.*;
import lombok.*;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;

@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter
public class Medcin extends UserApp {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @OneToOne
        private Cabinet cabinet;
        @OneToOne
        private Specialite specialite;
}
