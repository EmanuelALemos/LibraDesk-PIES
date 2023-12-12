package strategy;

public class MultaEspecial implements CalculadoraMulta {
    
    @Override
    public double calcularMulta(long diasAtraso) {
        return ((diasAtraso - 30) * 2) + 30;
    }
}
