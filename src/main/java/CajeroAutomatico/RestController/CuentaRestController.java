package CajeroAutomatico.RestController;

import CajeroAutomatico.DAO.CuentaDAOImplementation;
import CajeroAutomatico.JPA.Cuenta;
import CajeroAutomatico.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Usuario")
public class CuentaRestController {

    @Autowired
    public CuentaDAOImplementation usuarioDAO;

    @PostMapping
    public ResponseEntity<Result> Add(@RequestBody Cuenta cuenta) {
        Result result = usuarioDAO.Add(cuenta);

        if (result.correct) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
