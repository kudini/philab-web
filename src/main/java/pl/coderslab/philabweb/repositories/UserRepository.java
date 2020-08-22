package pl.coderslab.philabweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.philabweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
