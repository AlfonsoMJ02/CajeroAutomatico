package CajeroAutomatico.JPA;

import java.util.List;

public class Result<T> {
    public boolean correct;
    public String errorMessage;
    public String message;
    public Exception ex;
    public Object object;
    public List<T> objects; 
}
