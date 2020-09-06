package pl.coderslab.philabweb.service;

import pl.coderslab.philabweb.entities.Role;

import java.util.Optional;

public interface RoleService {
    public Optional<Role> findByName(String roleUser);
}
