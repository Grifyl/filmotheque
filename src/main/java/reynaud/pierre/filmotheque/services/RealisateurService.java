package reynaud.pierre.filmotheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reynaud.pierre.filmotheque.entites.Realisateur;
import reynaud.pierre.filmotheque.repositories.RealisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RealisateurService {
  private final RealisateurRepository realisateurRepository;

  public RealisateurService(RealisateurRepository realisateurRepository) {
    this.realisateurRepository = realisateurRepository;
  }

  public List<Realisateur> findAll() {
    return realisateurRepository.findAll();
  }

  public Optional<Realisateur> findById(Long id) {
    return realisateurRepository.findById(id);
  }

  public Realisateur save(Realisateur realisateur) {
    return realisateurRepository.save(realisateur);
  }

  public void deleteById(Long id) {
    realisateurRepository.deleteById(id);
  }
}
