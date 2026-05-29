package CajeroAutomatico.DAO;

import CajeroAutomatico.JPA.Cuenta;
import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.Service.EmailService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaDAOImplementation implements ICuenta {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EmailService emailService;

    @Override
    public Result Add(Cuenta cuenta) {
        Result result = new Result();
        try {
            boolean existe = ExisteUsuarioBanco(cuenta.getUsuario().getCurp(), cuenta.getBanco().getIdBanco());

            if (existe) {
                result.correct = false;
                result.errorMessage = "Ya existe una cuenta registrada de este usuario en este banco";

                return result;
            }

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("RegistrarUsuarioSP");

            query.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_APELLIDOPATERNO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_APELLIDOMATERNO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_CURP", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_EMAIL", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_PASSWORD", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_TELEFONO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_FECHANACIMIENTO", java.sql.Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_IDBANCO", Integer.class, ParameterMode.IN);

            query.registerStoredProcedureParameter("P_IDUSUARIO", Integer.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("P_NUMEROTARJETA", String.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("P_NIP", Integer.class, ParameterMode.OUT);

            query.setParameter("P_NOMBRE", cuenta.getUsuario().getNombre());
            query.setParameter("P_APELLIDOPATERNO", cuenta.getUsuario().getApellidoPaterno());
            query.setParameter("P_APELLIDOMATERNO", cuenta.getUsuario().getApellidoMaterno());
            query.setParameter("P_CURP", cuenta.getUsuario().getCurp());
            query.setParameter("P_EMAIL", cuenta.getUsuario().getEmail());
            query.setParameter("P_PASSWORD", cuenta.getUsuario().getPassword());
            query.setParameter("P_TELEFONO", cuenta.getUsuario().getTelefono());
            query.setParameter("P_FECHANACIMIENTO", java.sql.Date.valueOf(cuenta.getUsuario().getFechaNacimiento()));
            query.setParameter("P_IDBANCO", cuenta.getBanco().getIdBanco());

            query.execute();

            Integer idUsuario = (Integer) query.getOutputParameterValue("P_IDUSUARIO");
            String numeroTarjeta = (String) query.getOutputParameterValue("P_NUMEROTARJETA");
            Integer nip = (Integer) query.getOutputParameterValue("P_NIP");

            result.object = idUsuario;
            result.correct = true;

            emailService.enviarCredenciales(cuenta.getUsuario().getEmail(), cuenta.getUsuario().getNombre() + " " + cuenta.getUsuario().getApellidoPaterno() + " " + cuenta.getUsuario().getApellidoMaterno(), numeroTarjeta, nip, cuenta.getBanco().getNombre());
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = "Error al registrar usuario";
            result.ex = ex;
        }
        return result;
    }

    @Override
    public boolean ExisteUsuarioBanco(String curp, Integer idBanco) {
        try {
            Long total = entityManager.createQuery(
                    "SELECT COUNT(c) FROM Cuenta c WHERE c.Usuario.Curp = :curp AND c.Banco.IdBanco = :idBanco", Long.class)
                    .setParameter("curp", curp)
                    .setParameter("idBanco", idBanco)
                    .getSingleResult();
            return total > 0;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return false;
    }
}
