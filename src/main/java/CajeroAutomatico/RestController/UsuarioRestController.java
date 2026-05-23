package CajeroAutomatico.RestController;

import CajeroAutomatico.DAO.UsuarioDAOImplementation;
import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.JPA.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioRestController {

    @Autowired
    public UsuarioDAOImplementation usuarioDAO;

    @PostMapping
    public ResponseEntity<Result> Add(@RequestBody Usuario usuario) {
        Result result = usuarioDAO.Add(usuario);

        if (result.correct) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
