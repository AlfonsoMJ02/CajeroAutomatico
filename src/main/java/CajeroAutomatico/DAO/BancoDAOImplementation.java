package CajeroAutomatico.DAO;

import CajeroAutomatico.JPA.Banco;
import CajeroAutomatico.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BancoDAOImplementation implements IBanco{
    
    @Autowired 
    public EntityManager entityManager;

    @Override
    public Result GetAll() {
        Result result = new Result();
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("BancoGetAllSP");
            
            query.registerStoredProcedureParameter("pCursor", void.class, ParameterMode.REF_CURSOR);
            
            query.execute();
            
            List<Object[]> bancos = query.getResultList();
            result.objects = new ArrayList();
            
            for (Object[] obj : bancos) {
                Banco banco = new Banco();
                
                banco.setIdBanco(((BigDecimal)obj[0]).intValue());
                
                banco.setNombre(obj[1].toString());
                
                result.objects.add(banco);
            }
            
            result.correct = true;
            
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
}