package reynaud.pierre.filmotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reynaud.pierre.filmotheque.entites.Categorie;
import reynaud.pierre.filmotheque.entites.Utilisateur;
import reynaud.pierre.filmotheque.entites.UtilisateurConnecte;
import reynaud.pierre.filmotheque.services.UtilisateurService;

@Controller
public class AuthController {
  @Autowired
  private UtilisateurService utilisateurService;
  @Autowired
  private UtilisateurConnecte utilisateurConnecte;

  @GetMapping("/login")
  public String showLoginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String login(@RequestParam String email, @RequestParam String motDePasse, Model model) {
    Utilisateur utilisateur = utilisateurService.findByEmailAndMotDePasse(email, motDePasse);
    if (utilisateur != null) {
      utilisateurConnecte.setUtilisateur(utilisateur);
      return "redirect:/";
    } else {
      model.addAttribute("error", "Erreur de connexion");
      return "login";
    }
  }


  @GetMapping("/logout")
  public String logout() {
    utilisateurConnecte.logout();
    return "redirect:/login";
  }
}
