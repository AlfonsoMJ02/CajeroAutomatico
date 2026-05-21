package CajeroAutomatico.DAO;

import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImplementation implements IUsuario{
    
    @Autowired
    public EntityManager entityManager;
    
    @Override
    public Result Add(Usuario usuario) {
        Result result = new Result();
        try {
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
            
            
            query.setParameter("P_NOMBRE", usuario.getNombre());
            query.setParameter("P_APELLIDOPATERNO", usuario.getApellidoPaterno());
            query.setParameter("P_APELLIDOMATERNO", usuario.getApellidoMaterno());
            query.setParameter("P_CURP", usuario.getCurp());
            query.setParameter("P_EMAIL", usuario.getEmail());
            query.setParameter("P_PASSWORD", usuario.getPassword());
            query.setParameter("P_TELEFONO", usuario.getTelefono());
            query.setParameter("P_FECHANACIMIENTO", java.sql.Date.valueOf(usuario.getFechaNacimiento()));
            query.setParameter("P_IDBANCO", usuario.getBanco().getIdBanco());
            
            query.execute();
            
            Integer idUsuario = (Integer) query.getOutputParameterValue("P_IDUSUARIO");
            
            result.object = idUsuario;
            result.correct = true;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
    
}