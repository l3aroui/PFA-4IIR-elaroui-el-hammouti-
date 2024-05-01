package ma.emsi.PFAcabinetsDeMedcin.repositories;

import ma.emsi.PFAcabinetsDeMedcin.entities.Medcin;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepos extends JpaRepository<Medcin,Long> {

}
