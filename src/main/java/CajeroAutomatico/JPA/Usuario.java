package CajeroAutomatico.JPA;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Usuario {
    private int IdUsuario;
    @JsonProperty("nombre")
    private String Nombre;
    @JsonProperty("apellidoPaterno")
    private String ApellidoPaterno;
    @JsonProperty("apellidoMaterno")
    private String ApellidoMaterno;
    @JsonProperty("curp")
    private String Curp;
    @JsonProperty("fechaNacimiento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate FechaNacimiento;
    @JsonProperty("email")
    private String Email;
    @JsonProperty("password")
    private String Password;
    @JsonProperty("telefono")
    private String Telefono;
    @JsonProperty("banco")
    private Banco Banco;
    
    public int getIdUsuario(){
        return IdUsuario;
    }
    
    public void setIdUsuario(int IdUsuario){
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }
    
    public String getCurp(){
        return Curp;
    }
    
    public void setCurp(String Curp){
        this.Curp = Curp;
    }
    
    public LocalDate getFechaNacimiento(){
        return FechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate FechaNacimiento){
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Banco getBanco() {
        return Banco;
    }

    public void setBanco(Banco Banco) {
        this.Banco = Banco;
    }
}
