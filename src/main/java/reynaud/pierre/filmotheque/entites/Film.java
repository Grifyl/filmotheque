package reynaud.pierre.filmotheque.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Film {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titre;
  private LocalDate dateSortie;
  private String description;

  @ManyToOne
  @JoinColumn(name = "id_realisateur")
  private Realisateur realisateur;

  @ManyToMany
  @JoinTable(
          name = "film_categorie",
          joinColumns = @JoinColumn(name = "id_film"),
          inverseJoinColumns = @JoinColumn(name = "id_categorie")
  )
  private List<Categorie> categories;
}
