package CajeroAutomatico.DAO;

import CajeroAutomatico.DTO.LoginRequest;
import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.JPA.Tarjeta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImplementacion implements ILogin{
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public Result Login(LoginRequest request) {
        Result result = new Result();
        
        try {
            TypedQuery<Tarjeta> query = entityManager.createQuery("SELECT t FROM Tarjeta t WHERE t.NumeroTarjeta = :numeroTarjeta AND t.Nip = :nip", Tarjeta.class);
            
            query.setParameter("numeroTarjeta", request.getNumeroTarjeta());
            query.setParameter("nip", request.getNip());
            
            Tarjeta tarjeta = query.getSingleResult();
            
            String bancoTarjeta = tarjeta.getCuenta().getBanco().getNombre();
            
            if (!bancoTarjeta.equalsIgnoreCase(request.getBanco())) {
                result.correct = false;
                result.errorMessage = "No se encontro una cuenta registrada en este banco con esas credenciales";
            
                return result;
            }      
            
            result.object = tarjeta;
            result.correct = true;
            
        } catch (jakarta.persistence.NoResultException ex){
            result.correct = false;
            result.errorMessage = "Credenciales incorrectas";
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
}
