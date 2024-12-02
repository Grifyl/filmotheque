package reynaud.pierre.filmotheque.entites;

import org.springframework.stereotype.Component;

@Component
public class UtilisateurConnecte {
  private Utilisateur utilisateur;

  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  public boolean isAdmin() {
    return utilisateur.getRole().getLibelle().equals("Admin");
  }

  public boolean isAuthenticated() {
    return utilisateur != null;
  }

  public void logout() {
    utilisateur = null;
  }
}
