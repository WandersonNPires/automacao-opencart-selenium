package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.awt.Desktop;
import java.io.File;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

    public static void tirarScreenshot(WebDriver navegador, String nomePasta, String nomeTeste) {
        File screenshot = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String caminhoArquivo = "src/test/java/documents/" + nomePasta + "/" + nomeTeste + "_" + timestamp + ".png";

        try {
            Files.copy(screenshot.toPath(), Paths.get(caminhoArquivo));
            System.out.println(" Print salvo em: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println(" Erro ao salvar print: " + e.getMessage());
        }
    }

    public static void gerarRelatorioPorTeste(String nomePasta, String nomeTeste) {
        String caminhoArquivo = "src/test/java/documents/" + nomePasta + "/" + nomeTeste + "_relatorio.html";

        try {
            FileWriter writer = new FileWriter(caminhoArquivo);
            writer.write("<html><head><title>Relatorio de Teste</title></head><body>");
            writer.write("<h1>Relatorio: " + nomeTeste + "</h1>");
            writer.write("<p>Data e hora: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "</p>");
            writer.write("<p>Status:  Teste executado com sucesso</p>");
            writer.write("</body></html>");
            writer.close();
            System.out.println(" Relatprio salvo em: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println(" Erro ao salvar relatorio: " + e.getMessage());
        }

        try {
            File htmlFile = new File(caminhoArquivo);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir relatório no navegador: " + e.getMessage());
        }
    }
}
