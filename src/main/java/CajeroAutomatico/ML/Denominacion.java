package CajeroAutomatico.ML;

public class Denominacion {
    private double valor;
    private int cantidad;
    
    public Denominacion(double valor, int cantidad){
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
