package CajeroAutomatico.RestController;

import CajeroAutomatico.DAO.BancoDAOImplementation;
import CajeroAutomatico.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Banco")
public class BancoRestController {
    @Autowired
    private BancoDAOImplementation bancoDAO;
    
    @GetMapping()
    public ResponseEntity<Result> getAll(){
        Result result = bancoDAO.GetAll();
        if (result.correct) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
