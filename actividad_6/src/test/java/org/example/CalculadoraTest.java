package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    @DisplayName("sumar numeros")
    void sumar() {
        assertEquals(4, Calculadora.sumar(2, 2));
    }

    @Test
    @DisplayName("restar numeros")
    void restar() {
        assertEquals(0, Calculadora.restar(2, 2));
    }

    @Test
    @DisplayName("multiplicar numeros")
    void multiplicar() {
        assertAll(
                () -> assertEquals(240, Calculadora.multiplicar(80, 3)),
                () -> assertEquals(605, Calculadora.multiplicar(Calculadora.restar(90,50),15)),
                () -> assertEquals(2700, Calculadora.multiplicar(Calculadora.sumar(40,70), 25))
        );

    }

    @Test
    @DisplayName("dividir numeros")
    void dividir() {
        assertAll(
                () -> assertEquals(3, Calculadora.dividir(9, 3)),
                () -> assertEquals(110, Calculadora.dividir(Calculadora.sumar(150, 180), 3))
        );
    }
}