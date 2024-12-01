package reynaud.pierre.filmotheque.controllers;

import reynaud.pierre.filmotheque.entites.Realisateur;
import reynaud.pierre.filmotheque.services.FilmService;
import reynaud.pierre.filmotheque.services.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/realisateurs")
public class RealisateurController {

  private final RealisateurService realisateurService;
  private final FilmService filmService;

  @Autowired
  public RealisateurController(RealisateurService realisateurService, FilmService filmService) {
    this.realisateurService = realisateurService;
    this.filmService = filmService;
  }

  @GetMapping
  public String listRealisateurs(Model model) {
    model.addAttribute("realisateurs", realisateurService.findAll());
    return "realisateurs/list";
  }

  @GetMapping("/{id}")
  public String viewRealisateur(@PathVariable Long id, Model model) {
    Realisateur realisateur = realisateurService.findById(id).orElse(null);
    model.addAttribute("realisateur", realisateur);
    model.addAttribute("films", filmService.findAllByRealisateurId(id));
    return "realisateurs/view";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("realisateur", new Realisateur());
    return "realisateurs/create";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    model.addAttribute("realisateur", realisateurService.findById(id).orElse(null));
    return "realisateurs/edit";
  }

  @PostMapping("/edit")
  public String updateRealisateur(@ModelAttribute Realisateur realisateur) {
    realisateurService.save(realisateur);
    return "redirect:/realisateurs";
  }

  @PostMapping("/create")
  public String createRealisateur(@ModelAttribute Realisateur realisateur) {
    realisateurService.save(realisateur);
    return "redirect:/realisateurs";
  }

  @GetMapping("/delete/{id}")
  public String deleteRealisateur(@PathVariable Long id) {
    realisateurService.deleteById(id);
    return "redirect:/realisateurs";
  }
}
