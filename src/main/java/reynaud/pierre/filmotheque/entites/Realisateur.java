package reynaud.pierre.filmotheque.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Realisateur {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String prenom;
  private String nom;
  private LocalDate dateNaissance;
}

