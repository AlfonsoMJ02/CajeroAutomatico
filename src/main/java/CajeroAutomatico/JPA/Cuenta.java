package CajeroAutomatico.JPA;

public class Cuenta {
    private int IdCuenta;
    private int IdUsuario;
    private int IdBanco;
    private String NumeroCuenta;
    private int Saldo;
    
    private Usuario Usuario;
    private Banco Banco;
    
    public int getIdCuenta(){
        return IdCuenta;
    }
    
    public void setIdCuenta(int IdCuenta){
        this.IdCuenta = IdCuenta;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdBanco() {
        return IdBanco;
    }

    public void setIdBanco(int IdBanco) {
        this.IdBanco = IdBanco;
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
    
    
            
}
