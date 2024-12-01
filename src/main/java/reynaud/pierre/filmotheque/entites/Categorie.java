package reynaud.pierre.filmotheque.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Categorie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String libelle;

  @ManyToMany(mappedBy = "categories")
  private List<Film> films;
}
