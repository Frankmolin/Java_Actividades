import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "productos";
        Carrito carrito = new Carrito();

        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Producto producto = new Producto(datos[2], Integer.parseInt(datos[1]));
                carrito.agregarItem(new ItemCarrito(producto, Integer.parseInt(datos[0])));
            }
System.out.println(carrito.calcularTotal());
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}