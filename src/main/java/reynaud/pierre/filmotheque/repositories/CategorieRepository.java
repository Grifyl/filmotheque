package reynaud.pierre.filmotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reynaud.pierre.filmotheque.entites.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
