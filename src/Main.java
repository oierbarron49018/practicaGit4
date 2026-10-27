import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args) {
        boolean salir = false;
        while (! salir) {
            System.out.println("\n--- GESTION DE CITAS TALLER ---");
            System.out.println("1. Registrar nueva cita");
            System.out.println("2. Consultar citas por fecha");
            System.out.println("3. Calcular coste de servicio");
            System.out.println("4. Salir");
            System.out.print(" Seleccione una opcion: ");
            int opcion = sc.nextInt ();
            sc.nextLine();
            if (opcion==1){
                String matricula=registrarMatricula();
                LocalDate fecha=registrarFecha();
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
    public static String registrarMatricula() {
        String matricula;
        while (true) {
            try {
                System.out.println("Introduce la matricula (Mayusculas):");
                matricula = sc.nextLine();
                Pattern pat = Pattern.compile("[0-9]{4}(?![A-Z]*(?:CH|LL|A|E|I|O|U|Q|Ñ))[A-Z]{3}$");
                Matcher mat = pat.matcher(matricula);
                if (!mat.matches()) {
                    throw new IllegalArgumentException("Formato de matricula no válido.");
                }
                System.out.println("Matricula válida: " + matricula);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Inténtalo de nuevo.");
            }
        }
        return matricula;
    }
    public static LocalDate registrarFecha() {
        LocalDate fecha;
        while (true) {
            try {
                System.out.println("Introduce la fecha (formato dd/mm/yyyy):");
                String fechamal = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fecha = LocalDate.parse(fechamal, formatter);
                if (!fecha.isAfter(LocalDate.now())) {
                    throw new IllegalArgumentException("La fecha debe ser posterior a la fecha actual (" + LocalDate.now() + ").");
                }
                LocalDate fechaCita = fecha;
                System.out.println("Fecha registrada correctamente: " + fechaCita);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Inténtalo de nuevo.");
            } catch (Exception e) {
                System.out.println("Error: El formato debe ser dd/mm/yyyy y una fecha existente (ej. 25/12/2026).");
            }
        }
        return fecha;
    }
}