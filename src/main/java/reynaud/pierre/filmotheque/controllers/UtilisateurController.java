package reynaud.pierre.filmotheque.controllers;

import reynaud.pierre.filmotheque.entites.Utilisateur;
import reynaud.pierre.filmotheque.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

  private final UtilisateurService utilisateurService;

  @Autowired
  public UtilisateurController(UtilisateurService utilisateurService) {
    this.utilisateurService = utilisateurService;
  }

  @GetMapping
  public String listUtilisateurs(Model model) {
    model.addAttribute("utilisateurs", utilisateurService.findAll());
    return "utilisateurs/list";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("utilisateur", new Utilisateur());
    return "utilisateurs/create";
  }

  @PostMapping("/create")
  public String createUtilisateur(@ModelAttribute Utilisateur utilisateur) {
    utilisateurService.save(utilisateur);
    return "redirect:/utilisateurs";
  }

  @GetMapping("/delete/{id}")
  public String deleteUtilisateur(@PathVariable Long id) {
    utilisateurService.deleteById(id);
    return "redirect:/utilisateurs";
  }
}
