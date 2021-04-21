package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Role;

import java.util.Collection;
import java.util.Optional;

public interface IRoleService {

    Collection<Role> getAllRoles();
    Role getRoleById(Long RoleId);
    Role addRole(Role Role);
    void updateRole(Role Role);
    void deleteRole(Long RoleId);
    Optional<Role> getRoleByName(String name);

}
