package ma.gfi.leap.api.LEAPAPI.core.services;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Role;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Collection<Role> getAllRoles() {
        Collection<Role> list = new ArrayList<>();
        roleRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Role getRoleById(Long RoleId) {
        Role obj = roleRepository.findById(RoleId).get();
        return obj;
    }

    @Override
    public Role addRole(Role Role) {
        return roleRepository.save(Role);
    }

    @Override
    public void updateRole(Role Role) {
        roleRepository.save(Role);
    }

    @Override
    public void deleteRole(Long RoleId) {
        roleRepository.delete(getRoleById(RoleId));
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }


}
