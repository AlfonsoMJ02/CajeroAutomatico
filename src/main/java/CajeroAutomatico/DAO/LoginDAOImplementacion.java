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
            TypedQuery<Tarjeta> query = entityManager.createQuery("SELECT t FROM Tarjeta t WHERE t.NumeroTarjeta = :numeroTarjeta AND t.Nip = :nip AND t.Cuenta.Banco.Nombre = :nombre", Tarjeta.class);
            
            query.setParameter("numeroTarjeta", request.getNumeroTarjeta());
            query.setParameter("nip", request.getNip());
            query.setParameter("nombre", request.getBanco());
            
            Tarjeta tarjeta = query.getSingleResult();
            
            result.object = tarjeta;
            result.correct = true;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
}
