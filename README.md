# Conversor de Monedas

## Descripción del Proyecto
Este proyecto es un conversor de divisas desarrollado en Java que permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio en tiempo real. La aplicación obtiene las tasas de cambio actualizadas a través de una API externa (ExchangeRate-API) y proporciona una interfaz de consola para realizar conversiones y ver el historial de operaciones.

## Funcionalidades
- Conversión entre múltiples monedas internacionales
- Obtención de tasas de cambio en tiempo real mediante API
- Registro y visualización del historial de conversiones
- Interfaz de usuario por consola

## Conceptos y Tecnologías Implementadas
- **Java Records**: Utilizado para modelar datos inmutables (RespuestaTipoDeCambio, Moneda)
- **Clases tradicionales**: Para modelar entidades con comportamiento (RegistroDeConversion)
- **GSON**: Biblioteca para el procesamiento de JSON en la comunicación con la API
- **API REST**: Integración con servicios web externos para obtener tasas de cambio
- **Programación Orientada a Objetos**: Encapsulamiento, herencia, polimorfismo
- **Manejo de excepciones**: Try-catch para gestionar errores en la comunicación con la API
- **Colecciones de Java**: ArrayList, HashMap para almacenar datos

## Estructura del Proyecto
- **api/**: Clases relacionadas con la comunicación con la API externa
    - `RespuestaTipoDeCambio.java`: Record para almacenar la respuesta de la API
    - `ServicioTipoDeCambio.java`: Servicio para comunicarse con la API
- **modelos/**: Clases que representan las entidades del dominio
    - `Moneda.java`: Record que representa una moneda
    - `RegistroDeConversion.java`: Clase que representa un registro de conversión
- **servicios/**: Clases que implementan la lógica de negocio
    - `ConvertidorDeDivisas.java`: Servicio para realizar conversiones entre monedas
    - `HistorialDeConversion.java`: Servicio para gestionar el historial de conversiones
- **Principal.java**: Clase principal con el método main y la interfaz de usuario

