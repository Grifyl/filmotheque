package reynaud.pierre.filmotheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reynaud.pierre.filmotheque.entites.Role;
import reynaud.pierre.filmotheque.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
  private final RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public List<Role> findAll() {
    return roleRepository.findAll();
  }

  public Optional<Role> findById(Long id) {
    return roleRepository.findById(id);
  }

  public Role save(Role role) {
    return roleRepository.save(role);
  }

  public void deleteById(Long id) {
    roleRepository.deleteById(id);
  }
}
