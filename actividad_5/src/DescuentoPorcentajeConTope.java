public class DescuentoPorcentajeConTope extends Descuento {
    private final double tope;

    public DescuentoPorcentajeConTope(double porcentaje, double tope) {
        super(porcentaje);
        this.tope = tope;
    }

    @Override
    public double calcularDescuento(double total) {
       double descuento =total * this.getPorcentaje() / 100;
        if (descuento > tope) {
            return total-tope;
        }else {
            return descuento;
        }

    }
}
