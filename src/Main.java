import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format. DateTimeParseException ;
import java.util.Locale;
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
            GestorFechas.probarFormatoFecha(scanner);
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
    //Constante con el patron de formato español
    private static final String PATRON_FECHA = "dd/MM/yyyy HH:mm";

    //Formateador reutilizable configurado con la localizacion en español
    private static final DateTimeFormatter FORMATO_ESPANOL = DateTimeFormatter.ofPattern(PATRON_FECHA, new Locale("es", "ES"));

    /**
     * Convierte un objeto LocalDateTime a una cadena con formato espanol dd/MM/yyyy HH:mm ˜
     *
     * @param fechaHora Objeto LocalDateTime a formatear
     * @return Cadena de texto formateada o mensaje de error si el parametro es nulo ´
     */
    public static String formatearFechaEspanol ( LocalDateTime fechaHora ) {
        if ( fechaHora == null) {
            return "Fecha no disponible ";
        }
        return fechaHora .format( FORMATO_ESPANOL );
    }

    /**
     * Pide al usuario una fecha y hora por consola , valida la entrada
     * y la devuelve como objeto LocalDateTime .
     *
     * @param scanner Objeto Scanner activo
     * @return LocalDateTime introducido por el usuario o la fecha actual si falla
     */
    public static LocalDateTime leerYValidarFecha (Scanner scanner) {
        System.out.print(" Introduzca la fecha y hora de la cita (" + PATRON_FECHA + "): ");
        String entrada = scanner.nextLine().trim();

        try {
            // Intenta parsear la cadena ingresada seg´un el patron definido ´
            LocalDateTime fechaParseada = LocalDateTime .parse(entrada , FORMATO_ESPANOL );
            System.out.println(" Fecha registrada correctamente. ");
            return fechaParseada ;

        } catch ( DateTimeParseException e) {
            System.out.println("Formato incorrecto . Debe usar exactamente el formato: dd/MM/yyyy HH:mm");
            System.out.println("Se asignar´a la fecha y hora actual por defecto.");
            return LocalDateTime.now ();
        }
    }

    /**
     * Ejemplo de prueba para invocar desde la opcion´ correspondiente del men´u.
     */
    public static void probarFormatoFecha (Scanner scanner) {
        System.out.println("\n--- CONSULTA Y REGISTRO DE FECHAS ---");
        // 1. Mostrar la fecha/hora actual formateada
        LocalDateTime ahora = LocalDateTime .now ();
        String fechaActualFormateada = formatearFechaEspanol (ahora);
        System.out.println(" Fecha y hora actual del sistema: " + fechaActualFormateada );

        // 2. Pedir una fecha al usuario y mostrar el resultado formateado
        LocalDateTime fechaCita = leerYValidarFecha (scanner);
        System.out.println("Cita fijada para el: " + formatearFechaEspanol ( fechaCita ));
    }
}

}