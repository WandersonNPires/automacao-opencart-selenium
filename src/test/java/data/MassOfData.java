package data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MassOfData {

    



    // Método para chamar o script PHP e criar a massa de dados no banco
    public static void prepararMassa() {
        try {
            // URL do script PHP
            URL url = new URL("http://localhost/opencart/scripts/create_user.php");

            // Abrindo conexão
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            // Verificando a resposta
            int responseCode = conexao.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Massa de dados criada com sucesso.");
            } else {
                System.out.println("Falha ao criar massa de dados. Código de resposta: " + responseCode);
            }

            conexao.disconnect();
        } catch (IOException e) {
            System.out.println("Erro ao conectar ao script PHP: " + e.getMessage());
        }
    }
}
