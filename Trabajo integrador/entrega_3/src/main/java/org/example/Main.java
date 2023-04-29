package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Participante> participantes = new ArrayList<>();
        List<Ronda> partidos = new ArrayList<>();
        Map<String, Integer> puntuaciones = new HashMap<>();
        Map<Integer, Map<Integer, Map<Integer, Ronda>>> partidosPorFase = new HashMap<>();
        Map<String, Map<Integer, Participante>> participantesPorNombre = new HashMap<>();
        dbConnector database = new dbConnector(Config.getUrl(), Config.getDbUser(), Config.getDbPassword());
        try {
            participantes = obtenerParticipantes(database);
            partidos = obtenerPartidos(database);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Crea un map agrupado por los participante ej:"mariana"->List , "pedro"->List
        //  Y guarda sus partidos por id
        participantesPorNombre = agruparParticipantesPorNombre(participantes);
        partidosPorFase = agruparPartidos(partidos);

//saco las puntuaciones
        for (Map.Entry<String, Map<Integer, Participante>> entry : participantesPorNombre.entrySet()) {
            String nombreParticipante = entry.getKey();
            Map<Integer, Participante> predicciones = entry.getValue();
            int puntuacion = calcularPuntuacion(predicciones, partidosPorFase);
            puntuaciones.put(nombreParticipante, puntuacion);
        }

//las imprimo
        imprimirPuntuaciones(puntuaciones);

    }

    public static void imprimirPuntuaciones(Map<String, Integer> puntuaciones) {
        System.out.println("Puntuaciones🎺🎊🎉");
        Map.Entry<String, Integer> maxEntry = Collections.max(puntuaciones.entrySet(),
                Map.Entry.comparingByValue());
        puntuaciones.forEach((key, value) -> {
            Random rand = new Random();
            int colorCode = rand.nextInt(8) + 30; // genera un número aleatorio entre 30 y 37
            String colorString = "\u001B[" + colorCode + "m";
            System.out.print("-" + key + ": ");
            System.out.print(colorString + value + "\u001B[0m ");//<-resetea el color
            System.out.println(key == maxEntry.getKey() ? "Ganador😻" : "Perdedor😂");
        });
    }

    private static int calcularPuntuacion(Map<Integer, Participante> predicciones, Map<Integer, Map<Integer, Map<Integer, Ronda>>> partidosPorFase) {
        int puntuacion = 0;
        Boolean extraFase = true;

        for (Map.Entry<Integer, Map<Integer, Map<Integer, Ronda>>> fase : partidosPorFase.entrySet()) {
            Map<Integer, Map<Integer, Ronda>> mapGrupos = fase.getValue();
            Boolean extraRonda = true;

            for (Map.Entry<Integer, Map<Integer, Ronda>> grupo : mapGrupos.entrySet()) {
                Map<Integer, Ronda> mapPartidos = grupo.getValue();


                for (Map.Entry<Integer, Ronda> partido : mapPartidos.entrySet()) {
                    Ronda ronda = partido.getValue();
                    if (predicciones.containsKey(ronda.getIdPartido())) {
                        Participante prediccion = predicciones.get(ronda.getIdPartido());
                        if (prediccion.getEmpata() && ronda.getEmpata()) {
                            puntuacion += Config.getValor_Puntaje();
                            continue;
                        }
                        if (prediccion.getGana_1() && ronda.getGana_1()) {
                            puntuacion += Config.getValor_Puntaje();
                            continue;
                        }
                        if (prediccion.getGana_2() && ronda.getGana_2()) {
                            puntuacion += Config.getValor_Puntaje();
                            continue;
                        }
                    }
                    extraRonda = false;
                }

            }
            if (!extraRonda) {
                extraFase = false;
            } else {
                puntuacion += Config.getValor_Ronda();
            }
            if (extraFase) {
                puntuacion += Config.getValor_Fase();
            }
        }

        return puntuacion;
    }

    public static List<Participante> obtenerParticipantes(dbConnector database) throws SQLException {
        List<Participante> participantes = new ArrayList<>();
        database.conectar();
        ResultSet res1 = database.ejecutarConsulta("select * from pronostico");
        while (res1.next()) {
            participantes.add(new Participante(
                    res1.getInt("Participante_id"),
                    res1.getString("Participante_nombre"),
                    res1.getInt("Partido_id"),
                    res1.getInt("Equipo_1_id"),
                    Objects.equals(res1.getString("Gana_1"), "X"),
                    Objects.equals(res1.getString("Empata"), "X"),
                    Objects.equals(res1.getString("Gana_2"), "X"),
                    res1.getInt("Equipo_2_id")
            ));
        }
        res1.close();
        database.desconectar();
        return participantes;
    }

    public static List<Ronda> obtenerPartidos(dbConnector database) throws SQLException {
        List<Ronda> partidos = new ArrayList<>();
        database.conectar();
        ResultSet res2 = database.ejecutarConsulta("select * from resultados");
        while (res2.next()) {
            partidos.add(new Ronda(
                    res2.getInt("Partido_id"),
                    res2.getInt("Fase_nro"),
                    res2.getInt("Ronda_nro"),
                    res2.getInt("Equipo_1_id"),
                    res2.getString("Equipo_1_nombre"),
                    res2.getString("Equipo_1_descripcion"),
                    res2.getInt("Equipo_1_cantidad_goles"),
                    res2.getInt("Equipo_2_cantidad_goles"),
                    res2.getInt("Equipo_2_id"),
                    res2.getString("Equipo_2_nombre"),
                    res2.getString("Equipo_2_descripcion")
            ));
        }
        res2.close();
        database.desconectar();
        return partidos;
    }

    public static Map<String, Map<Integer, Participante>> agruparParticipantesPorNombre(List<Participante> participantes) {
        return participantes.stream()
                .collect(Collectors.groupingBy(
                        Participante::getParticipante_nombre,
                        Collectors.toMap(
                                Participante::getPartido_id,
                                Function.identity()
                        )
                ));
    }

    public static Map<Integer, Map<Integer, Map<Integer, Ronda>>> agruparPartidos(List<Ronda> partidos) {
        Map<Integer, Map<Integer, Map<Integer, Ronda>>> partidosAgrupados = new HashMap<>();
        for (Ronda partido : partidos) {
            int fase = partido.getNroFase();
            int ronda = partido.getNroRonda();
            int idPartido = partido.getIdPartido();

            partidosAgrupados.computeIfAbsent(fase, k -> new HashMap<>())
                    .computeIfAbsent(ronda, k -> new HashMap<>())
                    .put(idPartido, partido);
        }
        return partidosAgrupados;
    }

}