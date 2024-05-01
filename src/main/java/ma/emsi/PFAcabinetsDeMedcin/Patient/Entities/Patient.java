package ma.emsi.PFAcabinetsDeMedcin.Patient.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.PFAcabinetsDeMedcin.User.entities.UserApp;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
