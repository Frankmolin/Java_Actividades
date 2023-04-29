package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties propiedades = new Properties();

    private static String dbHost;
    private static String dbPort;
    private static String dbName;
    private static String dbUser;
    private static String dbPassword;
    private static String dbUrl;
    private static String valor_partido;
    private static String valor_ronda;
    private static String valor_fase;

    static {
        String archivoPropiedades = "config.properties";
        InputStream input = Config.class.getClassLoader().getResourceAsStream(archivoPropiedades);
        try {
            propiedades.load(input);
            dbHost = propiedades.getProperty("db.host");
            dbPort = propiedades.getProperty("db.port");
            dbName = propiedades.getProperty("db.name");
            dbUser = propiedades.getProperty("db.user");
            dbPassword = propiedades.getProperty("db.password");
            valor_partido = propiedades.getProperty("puntaje.partido");
            valor_ronda = propiedades.getProperty("puntaje.ronda");
            valor_fase = propiedades.getProperty("puntaje.fase");

            dbUrl = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDbHost() {
        return dbHost;
    }

    public static String getDbPort() {
        return dbPort;
    }

    public static String getDbName() {
        return dbName;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPassword() {
        return dbPassword;
    }
    public static String getUrl() {
        return dbUrl;
    }
    public static Integer getValor_Puntaje() {
        return Integer.parseInt(valor_partido);
    }
    public static Integer getValor_Ronda() {
        return Integer.parseInt(valor_ronda);
    }
    public static Integer getValor_Fase() {
        return Integer.parseInt(valor_fase);
    }
}
