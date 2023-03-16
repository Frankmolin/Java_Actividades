public class DescuentoPorcentaje extends Descuento {
    public DescuentoPorcentaje(double porcentaje) {
        super(porcentaje);
    }
    @Override
    public double calcularDescuento(double total) {
        return total * this.getPorcentaje() / 100;
    }
}
