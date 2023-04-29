package org.example;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Participante> participantes = new ArrayList<>();
        Map<Integer, Ronda> partidos = new HashMap<>();
        Map<String, Integer> puntuaciones = new HashMap<>();
        Map<Integer, Map<Integer, Ronda>> partidosPorRonda = new HashMap<>();
        Map<Integer, Map<Integer, Map<Integer, Ronda>>> partidosPorFase = new HashMap<>();

        MySQLConnector database = new MySQLConnector(Config.getUrl(), Config.getDbUser(), Config.getDbPassword());
        try {
            database.conectar();
            ResultSet res1 = database.ejecutarConsulta("select * from pronostico");
            while (res1.next()) {
                participantes.add(new Participante(
                        res1.getInt("Participante_id"),
                        res1.getString("Participante_nombre"),
                        res1.getInt("Partido_id"),
                        res1.getInt("Equipo_1_id"),
                        Objects.equals(res1.getString("Gana_1"),"X"),
                        Objects.equals(res1.getString("Empata"),"X"),
                        Objects.equals(res1.getString("Gana_2"),"X"),
                        res1.getInt("Equipo_2_id")

                ));
            }

            //Recorro el map con los 2 paricipantes
            res1.close();
            ResultSet res2 = database.ejecutarConsulta("select * from resultados");
            while (res2.next()) {
                partidos.put(res2.getInt("Partido_id"), new Ronda(
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Crea un map agrupado por los participante ej:"mariana"->List , "pedro"->List
        //  Y guarda sus partidos por id

        Map<String, Map<Integer, Participante>> participantesPorNombre =
                participantes.stream()
                        .collect(Collectors.toMap(
                                Participante::getParticipante_nombre, // clave: nombre del participante
                                participante -> Map.of(              // valor: map de partidos por id
                                        participante.getPartido_id(), participante),
                                (map1, map2) -> {                      // fusión de los maps por clave
                                    Map<Integer, Participante> mergedMap = new HashMap<>(map1);
                                    mergedMap.putAll(map2);
                                    return mergedMap;
                                }));


        //Crea un map agrupado por los grupos ej: 1->Map,2->Map

        for (Map.Entry<Integer, Ronda> partido : partidos.entrySet()) {
            Ronda value = partido.getValue();
            Integer key = partido.getKey();
            partidosPorRonda.computeIfAbsent(value.getNroRonda(), k -> new HashMap<>())
                    .put(key, value);
        }

        //crea un map agrupando por las fases
        for (Map.Entry<Integer, Map<Integer, Ronda>> ronda : partidosPorRonda.entrySet()) {
            Map<Integer, Ronda> partidosDeRonda = ronda.getValue();
            Integer nroRonda = ronda.getKey();
            Integer nroFase = partidosDeRonda.values().iterator().next().getNroFase();
            Map<Integer, Map<Integer, Ronda>> punteroMap = Map.of(nroRonda, partidosDeRonda);

            //crea un nuevo map con el map original y le agrega ➕
            // el nuevo map, retornando asi un nuevo map agrupando los anteriores
            partidosPorFase.merge(nroFase, punteroMap, (oldMap, newMap) -> {
                Map<Integer, Map<Integer, Ronda>> mergedMap = new HashMap<>(oldMap);
                mergedMap.putAll(newMap);
                return mergedMap;
            });
        }

        for (Map.Entry<String, Map<Integer, Participante>> participante :
                participantesPorNombre.entrySet()) {
            Map<Integer, Participante> predicciones = participante.getValue();
            puntuaciones.put(participante.getKey(), 0);
            Boolean extraFase = true;

            for (Map.Entry<Integer, Map<Integer, Map<Integer, Ronda>>> fase :
                    partidosPorFase.entrySet()) {
                Map<Integer, Map<Integer, Ronda>> mapGrupos = fase.getValue();

                for (Map.Entry<Integer, Map<Integer, Ronda>> grupo :
                        mapGrupos.entrySet()) {
                    Map<Integer, Ronda> mapPartidos = grupo.getValue();
                    Boolean extraRonda = true;

                    for (Map.Entry<Integer, Ronda> part :
                            mapPartidos.entrySet()) {
                        Ronda partido = part.getValue();
                        if (predicciones.containsKey(partido.getIdPartido())) {
                            Participante prediccion = predicciones.get(partido.getIdPartido());

                            if (prediccion.getEmpata()) {
                                if (partido.getEmpata()) {
                                    puntuaciones.put(participante.getKey(), puntuaciones.get(participante.getKey()) + Config.getValor_Puntaje());
                                    continue;
                                }
                            }
                            if (prediccion.getGana_1()) {
                                if (partido.getGana_1()) {
                                    puntuaciones.put(participante.getKey(), puntuaciones.get(participante.getKey()) + Config.getValor_Puntaje());
                                    continue;
                                }
                            }
                            if (prediccion.getGana_2()) {
                                if (partido.getGana_2()) {
                                    puntuaciones.put(participante.getKey(), puntuaciones.get(participante.getKey()) + Config.getValor_Puntaje());
                                    continue;
                                }
                            }
                        }
                        extraRonda = false;
                    }
                    if (extraRonda!=true){
                        extraFase=false;
                    }else{
                        puntuaciones.put(participante.getKey(), puntuaciones.get(participante.getKey()) + Config.getValor_Ronda());
                    }
                }

            }
            if (extraFase==true){
                puntuaciones.put(participante.getKey(), puntuaciones.get(participante.getKey()) + Config.getValor_Fase());
            }
        }

        System.out.println("Puntuaciones🎺🎊🎉");
        Map.Entry<String, Integer> maxEntry = Collections.max(puntuaciones.entrySet(),
                Map.Entry.comparingByValue());
        puntuaciones.forEach((key,value) -> {

            Random rand = new Random();
            int colorCode = rand.nextInt(8) + 30; // genera un número aleatorio entre 30 y 37
            String colorString = "\u001B[" + colorCode + "m";
            System.out.print("-"+key+": ");
            System.out.print(colorString+value+ "\u001B[0m ");//<-resetea el color
            System.out.println(key==maxEntry.getKey()?"Ganador😻":"Perdedor😂");
        });
    }
}