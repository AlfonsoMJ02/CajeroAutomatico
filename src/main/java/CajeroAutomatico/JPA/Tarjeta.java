package CajeroAutomatico.JPA;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarjeta {

    @Id
    @Column(name = "IdTarjeta")
    @JsonProperty("idTarjeta")
    private int IdTarjeta;

    @ManyToOne
    @JoinColumn(name = "IdCuenta")
    @JsonProperty("cuenta")
    private Cuenta Cuenta;

    @Column(name = "NumeroTarjeta")
    @JsonProperty("numeroTarjeta")
    private String NumeroTarjeta;

    @Column(name = "Nip")
    @JsonProperty("nip")
    private int Nip;

    @Column(name = "VerificacionNip")
    @JsonProperty("verificacionNip")
    private int VerificacionNip;

    public int getIdTarjeta() {
        return IdTarjeta;
    }

    public void setIdTarjeta(int IdTarjeta) {
        this.IdTarjeta = IdTarjeta;
    }

    public Cuenta getCuenta() {
        return Cuenta;
    }

    public void setCuenta(Cuenta Cuenta) {
        this.Cuenta = Cuenta;
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

}