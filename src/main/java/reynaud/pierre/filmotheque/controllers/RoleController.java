package reynaud.pierre.filmotheque.controllers;

import reynaud.pierre.filmotheque.entites.Role;
import reynaud.pierre.filmotheque.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {

  private final RoleService roleService;

  @Autowired
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping
  public String listRoles(Model model) {
    model.addAttribute("roles", roleService.findAll());
    return "roles/list"; // Correspond à src/main/resources/templates/roles/list.html
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("role", new Role());
    return "roles/create"; // Correspond à src/main/resources/templates/roles/create.html
  }

  @PostMapping("/create")
  public String createRole(@ModelAttribute Role role) {
    roleService.save(role);
    return "redirect:/roles";
  }

  @GetMapping("/delete/{id}")
  public String deleteRole(@PathVariable Long id) {
    roleService.deleteById(id);
    return "redirect:/roles";
  }
}
