package org.example;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Calculadora {
    static double sumar(double... nums){
        return Arrays.stream(nums).sum();
    }
    static double restar(double... nums){
        double num1 = 0;
        for(double num:nums){
            num1= (num1 ==0) ?num:num1-num;
        }
        return  num1;
    }
    static double multiplicar(double... nums){
        return DoubleStream.of(nums).reduce(1,(a, b)->a*b);
    }
    static double dividir(double... nums){
        double num1 = 0;
        for(double num:nums){
            num1= (num1 ==0) ?num:num1/num;
        }
        return  num1;
    }
}
