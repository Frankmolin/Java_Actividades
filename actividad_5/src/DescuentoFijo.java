public class DescuentoFijo extends Descuento {
    private double monto;

    public DescuentoFijo(double porcentaje, double monto) {
        super(porcentaje);
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public double calcularDescuento(double total) {
        if (total >= this.monto) {
            return this.getPorcentaje();
        } else {
            return 0;
        }
    }
}
