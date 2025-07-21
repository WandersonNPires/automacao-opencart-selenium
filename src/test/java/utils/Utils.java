package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Utils {
public static List<String[]> lerCsv(String caminho) {
    List<String[]> dados = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(
            Utils.class.getClassLoader().getResourceAsStream(caminho)))) {

        String linha;
        boolean cabecalho = true;
        while ((linha = br.readLine()) != null) {
            if (cabecalho) {
                cabecalho = false;
                continue;
            }

            // Ignora linhas vazias ou mal formatadas
            if (linha.trim().isEmpty()) continue;

            String[] campos = linha.split(",");
            if (campos.length < 3) {
                System.out.println("Linha ignorada (faltando colunas): " + linha);
                continue;
            }

            dados.add(campos);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return dados;
}

    public static List<String[]> lerTxt(String caminho) {
        List<String[]> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(linha.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

@DataProvider(name = "loginData")
public static Object[][] fornecerDadosLogin() {
   List<String[]> dados = lerCsv("dataR/login_dataR.csv");


    Object[][] matriz = new Object[dados.size()][3];

    for (int i = 0; i < dados.size(); i++) {
        matriz[i][0] = dados.get(i)[0];
        matriz[i][1] = dados.get(i)[1];
        matriz[i][2] = dados.get(i)[2];
    }

    return matriz;
}

}