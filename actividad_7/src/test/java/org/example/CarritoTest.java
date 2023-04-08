package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarritoTest {

    @Test
    void calcularTotal() {
        String productos = "1,40,jabón_en_polvo 3,10,esponjas 2,100,chocolates";
        Carrito carrito = new Carrito();
        String[] a = productos.split(" ");
        for (String producto : a) {
            String[] datos = producto.split(",");
            Producto item = new Producto(datos[2], Integer.parseInt(datos[1]));
            carrito.agregarItem(new ItemCarrito(item, Integer.parseInt(datos[0])));

        }
        carrito.setDescuento(new DescuentoPorcentajeConTope(50,200).calcularDescuento(carrito.calcularTotal()));
        assertEquals(135, carrito.calcularTotal());
    }
}