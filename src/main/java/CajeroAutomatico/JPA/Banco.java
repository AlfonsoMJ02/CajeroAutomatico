package CajeroAutomatico.JPA;

public class Banco {
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