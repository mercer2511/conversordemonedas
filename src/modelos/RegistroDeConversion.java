package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class RegistroDeConversion {
    private double cantidadOrigen;
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidadDestino;
    // Uso LocalDateTime para guardar cuándo se hizo la conversión
    private LocalDateTime registroHistorial;

    public RegistroDeConversion(double cantidadOrigen, String monedaOrigen, String monedaDestino, double cantidadDestino, LocalDateTime registroHistorial) {
        this.cantidadOrigen = cantidadOrigen;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidadDestino = cantidadDestino;
        this.registroHistorial = registroHistorial;
    }

    // Estos son los getters - permiten acceder a las variables privadas desde fuera de la clase
    public double getCantidadOrigen() {
        return cantidadOrigen;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getCantidadDestino() {
        return cantidadDestino;
    }

    public LocalDateTime getRegistroHistorial() {
        return registroHistorial;
    }

    // Usar @Override al metodo toString para obtener información que se pueda mostrar de manera ordenada
    @Override
    public String toString() {
        // DateTimeFormatter me permite mostrar la fecha y hora en el formato que yo quiera
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Se convirtieron " + String.format("%.2f", cantidadOrigen) + " " + monedaOrigen + " a " +
                String.format("%.2f", cantidadDestino) + " " + monedaDestino + " (" + formatter.format(registroHistorial) + ")";
    }
}
