
import java.util.Arrays;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {
        act1();
        System.out.println("-------------------");
        System.out.println("Actividad 2");
        act2();
    }

    public static void act1() {
        //-1-a
        System.out.println("1-a");
        System.out.println(contarLetra('l', "ladLlLdsa"));
        System.out.println("-------------------");
        //-1-b
        System.out.println("1-b");
        ordenarNum(new Integer[]{4, 2, 3, 1}, "Descendente");
        System.out.println("-------------------");
        //-1-c
        System.out.println("1-c");
        System.out.println(sumarMayorX(2, new int[]{1, 2, 3, 1}));
    }

    public static int contarLetra(char letra, String palabra) {
        int nLetra = 0;
        for (int i = 0; i < palabra.length(); i++) {

            if (Character.toLowerCase(letra) == Character.toLowerCase(palabra.charAt(i))) nLetra++;
        }
        return nLetra;
    }

    public static void ordenarNum(Integer[] nums, String opcion) {


        //   if (opcion.toLowerCase().equals("ascendente")) {
        Arrays.sort(nums);
        System.out.println("Ascendente: " + Arrays.toString(nums));
        //  }
        //  if (opcion.toLowerCase().equals("descendente")){
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println("Descendente: " + Arrays.toString(nums));
        //  };
    }



    public static int sumarMayorX(int x, int[] nums) {
        int total = 0;
        for (int num : nums) {
            if (num > x) {
                total += num;
            }
        }
        return total;
    }



    public static void act2() {
        String palabra = "hola que tal";
        System.out.println("Palabra no cifrada: " + palabra);
        System.out.println("Palabra cifrada: " + cifradoCesar(palabra, 28));
    }

    public static String cifradoCesar(String palabra, int desplazamiento) {
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        String palabraLimpia = palabra.replaceAll(" ", "").toLowerCase();
        String palabraCifrada = "";
        for (int i = 0; i < palabraLimpia.length(); i++) {
            char letra=palabraLimpia.charAt(i);
            int indiceLetra = abecedario.indexOf(letra);
            if(indiceLetra == -1){
                palabraCifrada += letra;
            }else{
                palabraCifrada += abecedario.charAt( (indiceLetra + desplazamiento) % abecedario.length() );
            }
        }
        return palabraCifrada;
    }


}
