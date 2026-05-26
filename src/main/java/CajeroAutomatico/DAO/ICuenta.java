package CajeroAutomatico.DAO;

import CajeroAutomatico.JPA.Cuenta;
import CajeroAutomatico.JPA.Result;

public interface ICuenta {
    Result Add(Cuenta cuenta);
    boolean ExisteUsuarioBanco(String curp, Integer idBanco);
}
