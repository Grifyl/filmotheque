package reynaud.pierre.filmotheque.entites;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Utilisateur {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String prenom;
  private String nom;
  private String email;
  private String motDePasse;

  @ManyToOne
  @JoinColumn(name = "id_role")
  private Role role;
}

