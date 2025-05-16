package api;

import java.util.Map;

// Guardar la respuesta de la API con el resultado y las tasas de conversión.
public record RespuestaTipoDeCambio(String result, Map<String, Double> conversion_rates) {
}
