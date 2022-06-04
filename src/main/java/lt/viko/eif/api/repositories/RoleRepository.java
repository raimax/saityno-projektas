package lt.viko.eif.api.repositories;

import lt.viko.eif.api.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional <Role> findByName(String name);
}
