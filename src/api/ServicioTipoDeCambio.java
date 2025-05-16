package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Logica para conectarse a la API externa como en la que se desarrollo en el curso
public class ServicioTipoDeCambio {
    // Aun dudando de si es buena idea guardar la API Key en el código porque el repositorio es publico
    private static final String API_KEY = "e3266bc7c3e7c5cae16e61d7";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String BASE_CURRENCY = "PEN"; // Moneda base, en este caso Sol Peruano

    public RespuestaTipoDeCambio obtenerTipoDeCambio() {
        // Construir URL
        String urlDeConsulta = BASE_URL + API_KEY + "/latest/" + BASE_CURRENCY;

        // Si no se hace el manejo de errores se marca como error asi que lo implemente como en el curso anterior
        try {
            // Esta parte del codigo se encuentra en la documentación de la API
            // Making Request
            URL url = new URL(urlDeConsulta);
            HttpURLConnection solicitud = (HttpURLConnection) url.openConnection();
            solicitud.connect();

            // Convert to JSON
            InputStreamReader lectorContenido = new InputStreamReader((InputStream) solicitud.getContent());
            JsonElement root = JsonParser.parseReader(lectorContenido);
            JsonObject jsonObject = root.getAsJsonObject();

            // Accesing object
            String resultado = jsonObject.get("result").getAsString();

            // El campo "conversion_rates" tiene todas las tasas de cambio
            JsonObject tasasDeConversion = jsonObject.get("conversion_rates").getAsJsonObject();

            // Cada moneda (key) tiene asociada una tasa de cambio (value)
            Map<String, Double> tasas = new HashMap<>();
            for (String key : tasasDeConversion.keySet()) {
                tasas.put(key, tasasDeConversion.get(key).getAsDouble());
            }

            // Finalmente creo un objeto con toda la información usando el record que definí
            return new RespuestaTipoDeCambio(resultado, tasas);
        } catch (IOException e) {
            // Si algo falla, imprimo el error y devuelvo null
            // printStackTrace() muestra el detalle del error en la consola
            e.printStackTrace();
            return null;
        }
    }
}
