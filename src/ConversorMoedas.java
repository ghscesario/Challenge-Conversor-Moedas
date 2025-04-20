import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoedas {

    public double convertCurrency(String origem, String destino, double quantidade) {
        try {
            HttpResponse<String> response;
            try (HttpClient client = HttpClient.newHttpClient()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://v6.exchangerate-api.com/v6/99e971f0ed397504d53326ce/latest/" + origem))
                        .build();

                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }

            Gson gson = new Gson();
            Moedas exchangeRate = gson.fromJson(response.body(), Moedas.class);

            Double rate = exchangeRate.getConversionRates().get(destino);

            double resultado = quantidade * rate;
            System.out.println("**************************************************************");
            if (resultado>0.001){
                System.out.printf("Taxa de conversão: 1 %s = %.4f %s%n", origem, rate, destino);
                System.out.printf("Valor convertido(Arredondado): %.2f %s%n", resultado, destino);
            }
            else {
                System.out.printf("Taxa de conversão: 1 %s = %.4f %s%n", origem, rate, destino);
                System.out.printf("Valor convertido(Arredondado): %.4f %s%n", resultado, destino);
            }
            return resultado;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return -1;
        }
    }
}