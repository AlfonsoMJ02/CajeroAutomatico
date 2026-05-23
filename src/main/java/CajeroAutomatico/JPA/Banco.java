package CajeroAutomatico.JPA;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Banco {
    @JsonProperty("idBanco")
    private int IdBanco;
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