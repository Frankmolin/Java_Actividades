package org.example;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class lectorArchivo {
    private String rutaArchivo1 ;
    private String rutaArchivo2 ;
    private List<pronosticoType> pronostico;
    private List<resultadoType> resultado;

    public lectorArchivo(String rutaArchivo1, String rutaArchivo2) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream input1 = classLoader.getResourceAsStream(rutaArchivo1);
        InputStream input2 = classLoader.getResourceAsStream(rutaArchivo2);

        pronostico = new CsvToBeanBuilder(new InputStreamReader(input1))
                .withSkipLines(1)
                .withSeparator(';')
                .withType(pronosticoType.class)
                .build()
                .parse();
        resultado = new CsvToBeanBuilder(new InputStreamReader(input2))
                .withSkipLines(1)
                .withSeparator(';')
                .withType(resultadoType.class)
                .build()
                .parse();

    }

    public List<pronosticoType> getPronostico() {
        return this.pronostico;
    }
    public List<resultadoType> getResultado() {
        return this.resultado;
    }

}
