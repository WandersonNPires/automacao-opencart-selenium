package data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MassOfData {

    
  public static final String FIRST_NAME_VALIDO = "Wanderson";
    public static final String LAST_NAME_VALIDO = "Silva";
    public static final String EMAIL_VALIDO = "wandersonneiva@gmail.com";
    public static final String SENHA_VALIDA = "eumesmo123";

    public static final String FIRST_NAME_VALIDO_2 = "Marilene";
    public static final String LAST_NAME_VALIDO_2 = "Lourenço";
    public static final String EMAIL_VALIDO_2 = "marilene.lourenco@base2.com.br";
    public static final String SENHA_VALIDA_2 = "senha123";

    public static final String FIRST_NAME_VALIDO_3 = "Maria";
    public static final String LAST_NAME_VALIDO_3 = "Santos";
    public static final String EMAIL_VALIDO_3 = "maria@example.com";
    public static final String SENHA_VALIDA_3 = "senha4senha123";

    public static final String FIRST_NAME_VALIDO_4 = "WandersonN";
    public static final String LAST_NAME_VALIDO_4 = "SilvaP";
    public static final String EMAIL_VALIDO_4 = "wandersonneivaa@gmail.com";
    public static final String SENHA_VALIDA_4 = "eumesmo12";



    public static final String FIRST_NAME_VALIDO_5 = "NovousuarioTeste";
    public static final String LAST_NAME_VALIDO_5 = "Silva";
    public static final String EMAIL_VALIDO_5 = "wandersonneivaQA@gmail.com";
    public static final String SENHA_VALIDA_5 = "eumesmo12";


    public static final String Email_Invalido ="wandersonnnnnn@gmail.com";
    public static final String Senha_Ivalida = "eumesmo12";


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
