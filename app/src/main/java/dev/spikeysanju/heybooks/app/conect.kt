import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ApiHandler {
    fun fetchData(apiUrl: String): String {
        val url = URL(apiUrl)
        val connection = url.openConnection() as HttpURLConnection

        try {
            // Configurar la conexión
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000 // Tiempo de espera para la conexión en milisegundos

            // Leer la respuesta
            val inputStream = connection.inputStream
            val reader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            var line: String?

            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append("\n")
            }

            return stringBuilder.toString()
        } finally {
            connection.disconnect()
        }
    }
}
