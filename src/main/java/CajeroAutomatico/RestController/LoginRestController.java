package CajeroAutomatico.RestController;

import CajeroAutomatico.DAO.LoginDAOImplementacion;
import CajeroAutomatico.DTO.CambiarNipRequest;
import CajeroAutomatico.DTO.LoginRequest;
import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.JPA.Tarjeta;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Auth")
public class LoginRestController {

    @Autowired
    private LoginDAOImplementacion loginDAO;

    @PostMapping("/Login")
    public ResponseEntity<Result> Login(@RequestBody LoginRequest login, HttpServletRequest request) {
        Result result = loginDAO.Login(login);

        if (result.correct) {
            Tarjeta tarjeta = (Tarjeta) result.object;
            HttpSession session = request.getSession(true);

            session.setAttribute("tarjeta", tarjeta.getNumeroTarjeta());
            session.setAttribute("idCuenta", tarjeta.getCuenta().getIdCuenta());
            session.setAttribute("banco", tarjeta.getCuenta().getBanco().getNombre());
            session.setAttribute("idTarjeta", tarjeta.getIdTarjeta());

            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @PostMapping("/CambiarNip")                                                                                                                                                                                                                                                                                               
    public ResponseEntity<Result> CambiarNip(@RequestBody CambiarNipRequest request){
        Result result = loginDAO.CambiarNip(request);
        
        if (result.correct) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/Logout")
    public ResponseEntity<Result> Logout(HttpServletRequest request, HttpServletResponse response) {

        Result result = new Result();

        try {
            HttpSession session = request.getSession(false);

            if (session != null) {
                session.invalidate();
            }

            Cookie cookie = new Cookie("JSESSIONID", null);

            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);

            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return ResponseEntity.ok(result);
    }
}
