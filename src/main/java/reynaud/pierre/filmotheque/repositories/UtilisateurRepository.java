package reynaud.pierre.filmotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reynaud.pierre.filmotheque.entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
