package org.example;

public class DescuentoFijo extends Descuento {

    public DescuentoFijo(double porcentaje) {
        super(porcentaje);

    }



    @Override
    public double calcularDescuento(double total) {
        if (total !=total-this.getPorcentaje()) {
            return total-this.getPorcentaje();
        } else {
            return 0;
        }
    }
}
