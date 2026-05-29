package CajeroAutomatico.DTO;

public class CambiarNipRequest {
    private int idTarjeta;
    private int nuevoNip;
    
    public int getIdTarjeta(){
        return idTarjeta;
    }
    
    public void setIdTarjeta(int idTarjeta){
        this.idTarjeta = idTarjeta;
    }
    
    public int getNuevoNip(){
        return nuevoNip;
    }
    
    public void setNuevoNip(int nuevoNip){
        this.nuevoNip = nuevoNip;
    }
}
