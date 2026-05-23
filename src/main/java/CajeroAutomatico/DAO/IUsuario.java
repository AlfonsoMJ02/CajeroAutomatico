package CajeroAutomatico.DAO;

import CajeroAutomatico.JPA.Result;
import CajeroAutomatico.JPA.Usuario;

public interface IUsuario {
    Result Add(Usuario usuario);
    boolean ExisteUsuarioBanco(String curp, Integer idBanco);
}
