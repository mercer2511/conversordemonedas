package modelos;

// Estoy practicando usar records para datos simples.
// Aquí guardo el código de la moneda (como "USD" o "EUR") y su tasa de cambio.
public record Moneda(String codigo, double tasa) {
}
