package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbConnector {
    private Connection conexion;
    private String url;
    private String usuario;
    private String password;

    public dbConnector(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    public void conectar() throws SQLException {
        conexion = DriverManager.getConnection(url, usuario, password);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public ResultSet ejecutarConsulta(String consulta) throws SQLException {
        PreparedStatement statement = conexion.prepareStatement(consulta);

        // Ejecutar la consulta y obtener los resultados
        ResultSet resultado = statement.executeQuery();

        return resultado;
    }
}
