package reynaud.pierre.filmotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reynaud.pierre.filmotheque.entites.Realisateur;

public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {
}
