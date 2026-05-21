package CajeroAutomatico.RestController;

import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.Service.CajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cajero")
public class CajeroRestController {
    
    @Autowired
    private CajeroService cajeroService;
    
    @PostMapping("/Retirar/{monto}")
    public ResponseEntity<Result> Retiro(@PathVariable double monto){
        Result result = cajeroService.Retiros(monto);
        if (result.correct) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
