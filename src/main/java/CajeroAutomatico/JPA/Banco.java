package CajeroAutomatico.JPA;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Banco {
    @Id
    @JsonProperty("idBanco")
    private int IdBanco;
    @JsonProperty("nombre")
    private String Nombre;
    
    public int getIdBanco(){
        return IdBanco;
    }
    
    public void setIdBanco(int IdBanco){
        this.IdBanco = IdBanco;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
}