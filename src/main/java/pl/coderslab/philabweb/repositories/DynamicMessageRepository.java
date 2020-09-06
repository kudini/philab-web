package pl.coderslab.philabweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.philabweb.entities.DynamicMessage;

public interface DynamicMessageRepository extends JpaRepository<DynamicMessage, Long> {
    DynamicMessage findOneByName(String name);
}
