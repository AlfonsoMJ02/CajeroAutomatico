package CajeroAutomatico.JPA;

public class Tarjeta {
    private int IdTarjeta;
    private int IdCuenta;
    private String NumeroTarjeta;
    private int Nip;
    private int VerificacionNip;
    
    private Cuenta Cuenta;
    
    public int getIdTarjeta(){
        return IdTarjeta;
    }
    
    public void setIdTarjeta(int IdTarjeta){
        this.IdTarjeta = IdTarjeta;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public String getNumeroTarjeta() {
        return NumeroTarjeta;
    }

    public void setNumeroTarjeta(String NumeroTarjeta) {
        this.NumeroTarjeta = NumeroTarjeta;
    }

    public int getNip() {
        return Nip;
    }

    public void setNip(int Nip) {
        this.Nip = Nip;
    }

    public int getVerificacionNip() {
        return VerificacionNip;
    }

    public void setVerificacionNip(int VerificacionNip) {
        this.VerificacionNip = VerificacionNip;
    }

    public Cuenta getCuenta() {
        return Cuenta;
    }

    public void setCuenta(Cuenta Cuenta) {
        this.Cuenta = Cuenta;
    }
}
