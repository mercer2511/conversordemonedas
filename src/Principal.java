import api.ServicioTipoDeCambio;
import modelos.RegistroDeConversion;
import servicios.ConvertidorDeDivisas;
import servicios.HistorialDeConversion;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ServicioTipoDeCambio servicioAPI = new ServicioTipoDeCambio();
        var respuesta = servicioAPI.obtenerTipoDeCambio();

        if (respuesta == null || !"success".equalsIgnoreCase(respuesta.result())) {
            System.out.println("Error al obtener datos de la API.");
            return;
        }

        ConvertidorDeDivisas convertidor = new ConvertidorDeDivisas(respuesta.conversion_rates());
        HistorialDeConversion historial = new HistorialDeConversion();

        // Usar do-while
        int opcion = 0;
        do {
            System.out.println("\n--- Menú Conversor de Divisas ---");
            System.out.println("1. Convertir Divisa");
            System.out.println("2. Ver historial de conversiones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Pongo estas monedas porque son las que más se usan en Perú
                    System.out.println("\n--- Códigos de Monedas Comunes ---");
                    System.out.println("EUR - Euro");
                    System.out.println("PEN - Sol Peruano");
                    System.out.println("BRL - Real Brasileño");
                    System.out.println("ARS - Peso Argentino");
                    System.out.println("CLP - Peso Chileno");
                    System.out.println("COP - Peso Colombiano");
                    System.out.println("USD - Dólar Estadounidense");
                    System.out.println("----------------------------------------");

                    System.out.print("Ingrese la moneda de origen (Ej: USD): ");
                    String origen = scanner.next().toUpperCase();

                    System.out.print("Ingrese la moneda destino (Ej: ARS): ");
                    String destino = scanner.next().toUpperCase();

                    System.out.print("Ingrese la cantidad a convertir: ");
                    double cantidad = scanner.nextDouble();

                    // Manejo de errores
                    try {
                        double resultado = convertidor.convertir(cantidad, origen, destino);
                        System.out.println("Resultado: " + String.format("%.2f", resultado));

                        // Reto extra generar el historial - usar LocalDateTime.now() para la hora actual!
                        RegistroDeConversion registro = new RegistroDeConversion(
                                cantidad, origen, destino, resultado, LocalDateTime.now()
                        );
                        historial.registrarConversion(registro);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    historial.mostrarHistorial();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:  // En caso no se ingrese una opción válida
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 3);  // El bucle continúa mientras la opcion sea diferente de 3

    }
}
