package reynaud.pierre.filmotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reynaud.pierre.filmotheque.entites.Categorie;
import reynaud.pierre.filmotheque.entites.Film;
import reynaud.pierre.filmotheque.services.CategorieService;
import reynaud.pierre.filmotheque.services.FilmService;
import reynaud.pierre.filmotheque.services.RealisateurService;

import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {

  private final FilmService filmService;
  private final RealisateurService realisateurService;
  private final CategorieService categorieService;

  @Autowired
  public FilmController(FilmService filmService, RealisateurService realisateurService, CategorieService categorieService) {
    this.filmService = filmService;
    this.realisateurService = realisateurService;
    this.categorieService = categorieService;
  }

  @GetMapping
  public String listFilms(Model model) {
    List<Film> films = filmService.findAll();
    model.addAttribute("films", films);
    return "films/list";
  }

  @GetMapping("/{id}")
  public String viewFilm(@PathVariable Long id, Model model) {
    Film film = filmService.findById(id).orElse(null);
    model.addAttribute("film", film);
    return "films/view";
  }


  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("film", new Film());
    model.addAttribute("realisateurs", realisateurService.findAll());
    model.addAttribute("categories", categorieService.findAll());
    return "films/create";
  }

  @PostMapping("/create")
  public String createFilm(@ModelAttribute Film film, @RequestParam List<Long> categorieIds) {
    List<Categorie> categories = categorieService.findAllById(categorieIds);
    film.setCategories(categories);
    filmService.save(film);
    return "redirect:/films";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    Film film = filmService.findById(id).orElse(null);
    model.addAttribute("film", film);
    model.addAttribute("realisateurs", realisateurService.findAll());
    model.addAttribute("categories", categorieService.findAll());
    return "films/edit";
  }

  @PostMapping("/edit")
  public String updateFilm(@ModelAttribute Film film, @RequestParam List<Long> categorieIds) {
    List<Categorie> categories = categorieService.findAllById(categorieIds);
    film.setCategories(categories);
    filmService.save(film);
    return "redirect:/films";
  }

  @GetMapping("/delete/{id}")
  public String deleteFilm(@PathVariable Long id) {
    filmService.deleteById(id);
    return "redirect:/films";
  }
}
