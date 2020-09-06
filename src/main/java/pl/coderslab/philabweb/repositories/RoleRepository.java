package pl.coderslab.philabweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.philabweb.entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role,Long> {
    Optional<Role> findByName(String roleName);
}
