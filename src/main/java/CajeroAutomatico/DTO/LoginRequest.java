package CajeroAutomatico.DTO;

public class LoginRequest {
    private String numeroTarjeta;
    private int nip;
    
    public String getNumeroTarjeta(){
        return numeroTarjeta;
    }
    
    public void setNumeroTarjeta(String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public int getNip(){
        return nip;
    }
    
    public void setNip(int nip){
        this.nip = nip;
    }
}
