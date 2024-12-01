package reynaud.pierre.filmotheque.controllers;

import reynaud.pierre.filmotheque.entites.Categorie;
import reynaud.pierre.filmotheque.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reynaud.pierre.filmotheque.services.FilmService;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategorieController {

  private final CategorieService categorieService;
  private final FilmService filmService;

  @Autowired
  public CategorieController(CategorieService categorieService, FilmService filmService) {
    this.categorieService = categorieService;
    this.filmService = filmService;
  }

  @GetMapping("/{id}")
  public String viewCategorie(@PathVariable Long id, Model model) {
    Categorie categorie = categorieService.findById(id).orElse(null);
    model.addAttribute("categorie", categorie);
    model.addAttribute("films", filmService.findAllByCategorieId(id));
    return "categories/view";
  }

  @GetMapping
  public String listCategories(Model model) {
    List<Categorie> categories = categorieService.findAll();
    model.addAttribute("categories", categories);
    return "categories/list";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("categorie", new Categorie());
    return "categories/create";
  }

  @PostMapping("/create")
  public String createCategorie(@ModelAttribute Categorie categorie) {
    categorieService.save(categorie);
    return "redirect:/categories";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    model.addAttribute("categorie", categorieService.findById(id).orElse(null));
    return "categories/edit";
  }

  @PostMapping("/edit")
  public String updateCategorie(@ModelAttribute Categorie categorie) {
    categorieService.save(categorie);
    return "redirect:/categories";
  }

  @GetMapping("/delete/{id}")
  public String deleteCategorie(@PathVariable Long id) {
    categorieService.deleteById(id);
    return "redirect:/categories";
  }
}
