package CajeroAutomatico.Service;

import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.ML.Denominacion;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CajeroService {
    
    private List<Denominacion> denominaciones;
    
    @PostConstruct
    public void Cajero(){
        denominaciones = new ArrayList<>();
        
        denominaciones.add(new Denominacion(1000, 2));
        denominaciones.add(new Denominacion(500, 5));
        denominaciones.add(new Denominacion(200, 10));
        denominaciones.add(new Denominacion(100, 20));
        denominaciones.add(new Denominacion(50, 30));
        denominaciones.add(new Denominacion(20, 40));
        denominaciones.add(new Denominacion(10, 50));
        denominaciones.add(new Denominacion(5, 100));
        denominaciones.add(new Denominacion(2, 200));
        denominaciones.add(new Denominacion(1, 300));
        denominaciones.add(new Denominacion(0.5, 100));
        
    }
    
    public Result Retiros(double monto){
        Result result = new Result();
        
        try {
            List<Denominacion> retiro = new ArrayList<>();
            
            double restante = monto;
            
            for (Denominacion denominacion : denominaciones) {
                
                int usar = 0;
                
                while (restante >= denominacion.getValor() && denominacion.getCantidad() > 0){
                    restante -= denominacion.getValor();
                    
                    restante = Math.round(restante * 100.0) / 100.0;
                    
                    denominacion.setCantidad(denominacion.getCantidad() - 1);
                    
                    usar++;
                }
                if (usar > 0) {
                    retiro.add(new Denominacion(denominacion.getValor(), usar));
                }
            }
            
            if (restante > 0) {
                result.correct = false;
                result.errorMessage = "No hay denominaciones suficientes";
                
                return result;
            }
            
            result.correct = false;
            result.object = retiro;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
}
