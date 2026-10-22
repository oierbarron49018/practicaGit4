import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    boolean salir = false;

    while (! salir) {
        System.out.println("\n--- GESTION DE CITAS TALLER ---");
        System.out.println("1. Registrar nueva cita");
        System.out.println("2. Consultar citas por fecha");
        System.out.println("3. Calcular coste de servicio");
        System.out.println("4. Salir");
        System.out.print(" Seleccione una opcion: ");
        int opcion = scanner.nextInt ();
        if (opcion==1){
            //funcion1
        }
        if (opcion==2){
            //funcion2
        }
        if (opcion==3){
            //funcion3
        }
        if (opcion == 4) {
        salir = true;
        System.out.println(" Saliendo del programa ...");
        }
        }
    }
}