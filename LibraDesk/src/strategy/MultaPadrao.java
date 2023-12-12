package strategy;

public class MultaPadrao implements CalculadoraMulta {
    
    @Override
    public double calcularMulta(long diasAtraso) {
        return diasAtraso;
    }
}
