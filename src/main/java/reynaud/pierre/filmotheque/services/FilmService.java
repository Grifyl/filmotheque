package reynaud.pierre.filmotheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reynaud.pierre.filmotheque.entites.Film;
import reynaud.pierre.filmotheque.repositories.FilmRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
  private final FilmRepository filmRepository;

  public FilmService(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  public List<Film> findAll() {
    return filmRepository.findAll();
  }

  public List<Film> findAllByRealisateurId(Long realisateurId) {
    return filmRepository.findByRealisateurId(realisateurId);
  }

  public List<Film> findAllByCategorieId(Long categorieId) {
    return filmRepository.findByCategoriesId(categorieId);
  }

  public Optional<Film> findById(Long id) {
    return filmRepository.findById(id);
  }

  public Film save(Film film) {
    return filmRepository.save(film);
  }

  public void deleteById(Long id) {
    filmRepository.deleteById(id);
  }
}
