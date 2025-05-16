package servicios;

import modelos.RegistroDeConversion;

import java.util.ArrayList;
import java.util.List;

// Esta clase guarda un historial de todas las conversiones que se han hecho
public class HistorialDeConversion {
    // Declarar variables con la interfaz (List) y no con la implementación (ArrayList)
    private final List<RegistroDeConversion> registros;

    public HistorialDeConversion() {
        // "Array" que puede crecer automáticamente.
        this.registros = new ArrayList<>();
    }

    public void registrarConversion(RegistroDeConversion registro) {
        registros.add(registro);
    }

    public void mostrarHistorial() {
        if (registros.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            System.out.println("\n--- Historial de Conversiones ---");
            // Recorrer cada elemento de la lista registros y mostrarlo en pantalla el metodo toString fue sobreescrito
            for (RegistroDeConversion registro : registros) {
                System.out.println(registro);
            }
        }
    }
}
