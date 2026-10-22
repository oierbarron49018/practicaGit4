import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTION DE CITAS TALLER ---");
            System.out.println("1. Registrar nueva cita");
            System.out.println("2. Consultar citas por fecha");
            System.out.println("3. Calcular coste de servicio");
            System.out.println("4. Salir");
            System.out.print(" Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
                //funcion1
            }
            if (opcion == 2) {
                //funcion2
            }
            if (opcion == 3) {
                probarCalculoCoste(scanner);
            }
            if (opcion == 4) {
                salir = true;
                System.out.println(" Saliendo del programa ...");
            }
        }
    }

    public static double calcularCosteServicio(int tipoServicio, String matricula) {
        try {
            double precioBase;
            switch (tipoServicio) {
                case 1:
                    precioBase = 50.0; // Cambio de aceite y filtro
                    break;
                case 2:
                    precioBase = 120.0; // Revision general
                    // Pre -ITV
                    break;
                case 3:
                    precioBase = 200.0; // Cambio de frenos y discos
                    break;
                case 4:
                    precioBase = 350.0; // Reparacion de distribuicion
                    break;
                default:
                    System.out.println("Opcion de servicio no valida");
                    precioBase = 80;
                    break;


            }

            String matriculaLimpia = matricula.trim().toUpperCase();

            double porcentajeDescuento = 0.0;
            // Regla A: Vehıculos hıbridos/ electricos o flotas especiales (ejemplo: terminan en "ECO ")
            if (matriculaLimpia.endsWith("ECO")) {
                porcentajeDescuento = 0.20; // 20 % de descuento
                System.out.println("Aplicado 20 % de descuento por matrıcula ECO.");

            } else
                // Regla B: Vehıculos antiguos o promocionales (ejemplo: contienen el numero "00")
                if (matriculaLimpia.contains("00")) {
                    porcentajeDescuento = 0.10; // 10 % de descuento
                    System.out.println(" Aplicado 10 % de descuento por promocion especial (serie 00).");

                }
                // Regla C: Formato historico o especial (ejemplo:empieza por la letra "H")

                else if (matriculaLimpia.startsWith("H")) {
                    porcentajeDescuento = 0.15; // 15 % de descuento
                    System.out.println(" Aplicado 15 % de descuento para vehıculo historico.");
                } else {
                    System.out.println("No se aplican descuentos a esta matricula.");
                }
            // 4. Calculo final del coste ´
            double descuento = precioBase * porcentajeDescuento;
            double precioFinal = precioBase - descuento;
            return precioFinal;
        } catch (Exception e) {
            System.out.println("Has cometido un error");
            return 0.0;
        }
    }

        public static void probarCalculoCoste (Scanner scanner) {
        try{
            System.out.println("\n--- C´ALCULO DE COSTE DE SERVICIO ---");
            System.out.println("1. Cambio de aceite y filtro (50?)");
            System.out.println("2. Revisi´on general (120?)");
            System.out.println("3. Cambio de frenos (200?)");
            System.out.println("4. Distribuci´on (350?)");
            System.out.print(" Seleccione el tipo de servicio : ");
            int opcionServicio = scanner.nextInt();
            scanner.nextLine(); // Limpieza de bufer tras nextInt ()
            System.out.print(" Introduzca la matrıcula del vehıculo (ej. 1234 ECO , H1234BBB , 0012 KFX): ");
            String matriculaInput = scanner.nextLine();

            double total = calcularCosteServicio (opcionServicio ,
                    matriculaInput );

            System.out.printf("El importe total a pagar es: %.2f ?\n", total);


    }
        catch (Exception e)
        {
            System.out.println("Has cometido un error");
            scanner.nextLine();
        }
    }
}