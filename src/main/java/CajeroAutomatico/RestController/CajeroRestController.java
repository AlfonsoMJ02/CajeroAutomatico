package CajeroAutomatico.RestController;

import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.Service.CajeroService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cajero")
public class CajeroRestController {

    @Autowired
    private CajeroService cajeroService;

    @PostMapping("/Retirar/{monto}")
    public ResponseEntity<Result> Retiro(@PathVariable double monto, HttpSession session) {

        Integer idTarjeta = (Integer) session.getAttribute("idTarjeta");

        if (idTarjeta == null) {
            
            Result result = new Result();
            result.correct = false;
            result.errorMessage = "Usuario no autenticado";

            return ResponseEntity.badRequest().body(result);
        }

        Result result = cajeroService.Retiros(idTarjeta, monto);

        if (result.correct) {
            return ResponseEntity.ok(result);

        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
