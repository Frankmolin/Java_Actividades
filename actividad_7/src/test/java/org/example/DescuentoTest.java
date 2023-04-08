package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescuentoTest {

    @Test
    void calcularDescuento() {
        Descuento a, b, c;
        a = new DescuentoFijo(20);
        b = new DescuentoPorcentaje(20);
        c = new DescuentoPorcentajeConTope(50, 200);

        assertEquals(10, a.calcularDescuento(30));
        assertEquals(20, b.calcularDescuento(100));
        assertEquals(1800, c.calcularDescuento(2000));

    }
}