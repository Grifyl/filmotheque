package reynaud.pierre.filmotheque.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String libelle;

  @OneToMany(mappedBy = "role")
  private List<Utilisateur> utilisateurs;
}

