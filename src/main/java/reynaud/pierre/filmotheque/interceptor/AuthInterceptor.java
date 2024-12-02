package reynaud.pierre.filmotheque.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reynaud.pierre.filmotheque.entites.UtilisateurConnecte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class AuthInterceptor implements HandlerInterceptor {

  @Autowired
  private UtilisateurConnecte utilisateurConnecte;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String uri = request.getRequestURI();
    if (uri.startsWith("/login") || uri.startsWith("/logout")) {
      return true;
    }
    if (!utilisateurConnecte.isAuthenticated()) {
      response.sendRedirect("/login");
      return false;
    }
    if (!utilisateurConnecte.isAdmin() && (uri.startsWith("/films/create") || uri.startsWith("/films/edit") || uri.startsWith("/films/delete"))) {
      response.sendRedirect("/?error=Unauthorized");
      return false;
    }
    return true;
  }
}
