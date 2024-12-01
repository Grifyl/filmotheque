package reynaud.pierre.filmotheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reynaud.pierre.filmotheque.entites.Utilisateur;
import reynaud.pierre.filmotheque.repositories.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
  private final UtilisateurRepository utilisateurRepository;

  public UtilisateurService(UtilisateurRepository utilisateurRepository) {
    this.utilisateurRepository = utilisateurRepository;
  }

  public List<Utilisateur> findAll() {
    return utilisateurRepository.findAll();
  }

  public Optional<Utilisateur> findById(Long id) {
    return utilisateurRepository.findById(id);
  }

  public Utilisateur save(Utilisateur utilisateur) {
    return utilisateurRepository.save(utilisateur);
  }

  public void deleteById(Long id) {
    utilisateurRepository.deleteById(id);
  }
}
