import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
Actividad 4
1
----------------------------------

        Scanner obj = new Scanner(System.in);
        String opt;
        System.out.print("Ingrese una opcion a/d (Acendente o Descendente): ");
        opt = obj.next();
        System.out.println("El resultado es: " + ordenarNum(new Integer[]{}, opt));
        System.out.println("El resultado es: " + ordenarNum(new Integer[]{3,2,4,6}, "d"));


-----------------------------------
*/
        System.out.println(sumaOmulti(
                stringToArray(
                        leerArchivo("act2_numeros.txt")),
                "m"));
   /*
   ------------------------------------------
3
 */
        System.out.println("texto cifrado: " + decifradoCesar("ipmbrvfubm", 1));

    }

    public static String ordenarNum(Integer[] nums, String opcion) {

        Scanner obj = new Scanner(System.in);
        //verifico si existe el array
        if (Arrays.equals(nums, new Integer[]{})) {
            int nArray;
            System.out.print("Ingrese el tamaño del vector: ");
            nArray = obj.nextInt();
            nums = new Integer[nArray];
            for (int i = 0; i < nArray; i++) {
                System.out.print("Ingrese el valor de la posicion " + i + ": ");
                nums[i] = obj.nextInt();
            }
        }
        //lo ordeno dependiendo la opcion
        if (opcion.equalsIgnoreCase("ascendente") || opcion.equalsIgnoreCase("a")) {
            Arrays.sort(nums);
            return Arrays.toString(nums);
        }
        if (opcion.equalsIgnoreCase("descendente") || opcion.equalsIgnoreCase("d")) {
            Arrays.sort(nums, Collections.reverseOrder());
            return Arrays.toString(nums);
        }

        return "Seleccione una opcion valida porfavor 😡";
    }

    public static String leerArchivo(String path) {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        try {
            archivo = new File(path);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea, contenido = "";
            while ((linea = br.readLine()) != null) {
                contenido += linea;
            }
            return contenido;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static int sumaOmulti(Integer[] nums, String opt) {
        int resultado = 0;
        switch (opt) {
            case "s", "suma" -> {
                for (Integer num : nums) resultado += num;
            }
            case "m", "multiplicar" -> {
                for (Integer num : nums) {
                    resultado = resultado == 0 ? num : resultado * num;
                }
            }
        }
        return resultado;
    }

    public static Integer[] stringToArray(String str) {
        String[] s = str.replaceAll("\\{", "")
                .replaceAll("}", "")
                .replaceAll(",", " ")
                .replaceAll("\\s+", " ")
                .split(" ");
        Integer[] arr = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        return arr;
    }

    public static String cifradoCesar(String palabra, int desplazamiento) {
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        String palabraLimpia = palabra.replaceAll(" ", "").toLowerCase();
        String palabraCifrada = "";
        for (int i = 0; i < palabraLimpia.length(); i++) {
            char letra = palabraLimpia.charAt(i);
            int indiceLetra = abecedario.indexOf(letra);
            if (indiceLetra == -1) {
                palabraCifrada += letra;
            } else {
                palabraCifrada += abecedario.charAt((indiceLetra + desplazamiento) % abecedario.length());
            }
        }
        return palabraCifrada;
    }

    public static String decifradoCesar(String palabra, int desplazamiento) {
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        String palabraLimpia = palabra.replaceAll(" ", "").toLowerCase();
        String palabraDecifrada = "";
        if (desplazamiento>abecedario.length()) return "⚡☣ el desplazamiento debe ser menor a 27";
        for (int i = 0; i < palabraLimpia.length(); i++) {
            char letra = palabraLimpia.charAt(i);
            int indiceLetra = abecedario.indexOf(letra);
            if (indiceLetra == -1) {
                palabraDecifrada += letra;
            } else {
                if (indiceLetra-desplazamiento < 0) {
                    palabraDecifrada += abecedario.charAt( abecedario.length()+(indiceLetra - desplazamiento) );
                } else {
                    palabraDecifrada += abecedario.charAt((indiceLetra - desplazamiento) % abecedario.length());
                }
            }
        }
        return palabraDecifrada;
    }
}