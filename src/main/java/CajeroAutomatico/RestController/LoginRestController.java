package CajeroAutomatico.RestController;

import CajeroAutomatico.DTO.LoginRequest;
import CajeroAutomatico.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Auth")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginRestController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/Login")
    public ResponseEntity<Result> Login(@RequestBody LoginRequest login, HttpSession session) {

        Result result = new Result();

        try {

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("TarjetaLoginSP");

            query.registerStoredProcedureParameter("pNumeroTarjeta", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("pNip", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("pCursor", void.class, ParameterMode.REF_CURSOR);
            query.setParameter("pNumeroTarjeta", login.getNumeroTarjeta());
            query.setParameter("pNip", login.getNip());

            query.execute();

            List<Object[]> datos = query.getResultList();

            if (datos.isEmpty()) {
                result.correct = false;
                result.errorMessage = "Numeor de Tarjeta o NIP incorrecto";

                return ResponseEntity.badRequest().body(result);
            }

            Object[] obj = datos.get(0);

            session.setAttribute("idTarjeta", ((BigDecimal)obj[0]).intValue());
            session.setAttribute("idCuenta", ((BigDecimal)obj[2]).intValue());
            session.setAttribute("idUsuario", ((BigDecimal)obj[6]).intValue());

            Map<String, Object> usuario = new HashMap<>();

            usuario.put("idTarjeta", ((BigDecimal)obj[0]).intValue());
            usuario.put("numeroTarjeta", obj[1]);            
            usuario.put("saldo", ((BigDecimal)obj[3]).doubleValue());
            usuario.put("banco", obj[5]);
            usuario.put("nombre", obj[7] + " " + obj[8]);

            result.correct = true;
            result.object = usuario;

            return ResponseEntity.ok(result);

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;

            return ResponseEntity.badRequest().body(result);
        }
    }
}