package CajeroAutomatico.JPA;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cuenta {

    @Id
    @Column(name = "IdCuenta")
    @JsonProperty("idCuenta")
    private int IdCuenta;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    @JsonProperty("usuario")
    private Usuario Usuario;

    @ManyToOne
    @JoinColumn(name = "IdBanco")
    @JsonProperty("banco")
    private Banco Banco;

    @Column(name = "NumeroCuenta")
    @JsonProperty("numeroCuenta")
    private String NumeroCuenta;

    @Column(name = "Saldo")
    @JsonProperty("saldo")
    private int Saldo;

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public Banco getBanco() {
        return Banco;
    }

    public void setBanco(Banco Banco) {
        this.Banco = Banco;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

}