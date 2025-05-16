package servicios;

import java.util.Map;

// Esta clase se encarga de hacer las conversiones entre diferentes monedas
public class ConvertidorDeDivisas {
    private Map<String, Double> tasas;

    public ConvertidorDeDivisas(Map<String, Double> tasas) {
        this.tasas = tasas;
    }

    public double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        // Si el usuario pone una moneda que no existe lanzo una excepción
        if (!tasas.containsKey(monedaOrigen) || !tasas.containsKey(monedaDestino)) {
            throw new IllegalArgumentException("Una de las monedas no está disponible.");
        }

        // Aquí obtengo las tasas de cambio para la moneda de origen y destino
        double tasaOrigen = tasas.get(monedaOrigen);
        double tasaDestino = tasas.get(monedaDestino);

        return (cantidad / tasaOrigen) * tasaDestino;
    }
}
