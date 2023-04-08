package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;
    private double descuento;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemCarrito item) {
        this.items.add(item);
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void eliminarItem(ItemCarrito item) {
        this.items.remove(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
        return total-this.descuento;
    }
}
