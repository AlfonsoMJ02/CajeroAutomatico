package CajeroAutomatico.DTO;

public class LoginRequest {
    private String numeroTarjeta;
    private int nip;
    private String banco;
    
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
    
    public String getBanco(){
        return banco;
    }
    
    public void setBanco(String banco){
        this.banco = banco;
    }
}
