package reynaud.pierre.filmotheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reynaud.pierre.filmotheque.entites.Categorie;
import reynaud.pierre.filmotheque.repositories.CategorieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
  private final CategorieRepository categorieRepository;

  public CategorieService(CategorieRepository categorieRepository) {
    this.categorieRepository = categorieRepository;
  }

  public List<Categorie> findAllById(List<Long> ids) {
    return categorieRepository.findAllById(ids);
  }

  public List<Categorie> findAll() {
    return categorieRepository.findAll();
  }

  public Optional<Categorie> findById(Long id) {
    return categorieRepository.findById(id);
  }

  public Categorie save(Categorie categorie) {
    return categorieRepository.save(categorie);
  }

  public void deleteById(Long id) {
    categorieRepository.deleteById(id);
  }
}
