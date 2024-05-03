package ma.emsi.PFAcabinetsDeMedcin.User.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class UserApp{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomPrenom;
    @Column(unique = true)
    private String telephone;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateNaiss;
    @OneToOne
    private Addresse addresse;
    private String password;
    @Column(unique = true)
    private String email;
}
