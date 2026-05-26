package CajeroAutomatico.DAO;

import CajeroAutomatico.DTO.LoginRequest;
import CajeroAutomatico.JPA.Result;

public interface ILogin {
    Result Login(LoginRequest request);
}
