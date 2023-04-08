package org.example;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class lectorArchivo {
    private String rutaArchivo1 ;
    private String rutaArchivo2 ;
    private List<pronosticoType> pronostico;
    private List<resultadoType> resultado;

    public lectorArchivo(String rutaArchivo1, String rutaArchivo2) {

        try {

            pronostico = new CsvToBeanBuilder(new FileReader(rutaArchivo1))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(pronosticoType.class)
                    .build()
                    .parse();
            resultado = new CsvToBeanBuilder(new FileReader(rutaArchivo2))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(resultadoType.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<pronosticoType> getPronostico() {
        return this.pronostico;
    }
    public List<resultadoType> getResultado() {
        return this.resultado;
    }

}
