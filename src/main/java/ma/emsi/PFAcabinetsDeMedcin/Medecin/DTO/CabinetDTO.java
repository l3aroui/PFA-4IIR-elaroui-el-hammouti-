package ma.emsi.PFAcabinetsDeMedcin.Medecin.DTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabinetDTO {
    private Long CabinetId;
}
