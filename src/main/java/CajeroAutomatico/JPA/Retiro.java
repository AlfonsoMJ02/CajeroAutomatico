package CajeroAutomatico.JPA;

import java.util.Date;

public class Retiro {
    private int IdRetiro;
    private int IdTarjeta;
    private int Monto;
    private Date FechaRetiro;
    
    private Tarjeta Tarjeta;
    
    public int getIdRetiro(){
        return IdRetiro;
    }
    
    public void setIdRetiro(int IdRetiro){
        this.IdRetiro = IdRetiro;
    }

    public int getIdTarjeta() {
        return IdTarjeta;
    }

    public void setIdTarjeta(int IdTarjeta) {
        this.IdTarjeta = IdTarjeta;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }

    public Date getFechaRetiro() {
        return FechaRetiro;
    }

    public void setFechaRetiro(Date FechaRetiro) {
        this.FechaRetiro = FechaRetiro;
    }

    public Tarjeta getTarejta() {
        return Tarjeta;
    }

    public void setTarejta(Tarjeta Tarejta) {
        this.Tarjeta = Tarejta;
    }
}
