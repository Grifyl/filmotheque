package reynaud.pierre.filmotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reynaud.pierre.filmotheque.entites.Film;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
  List<Film> findByTitreContaining(String keyword);
  List<Film> findByRealisateurId(Long realisateurId);
  List<Film> findByCategoriesId(Long categorieId);
}
