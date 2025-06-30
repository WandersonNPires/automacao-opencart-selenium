package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterSucess {

    private ChromeDriver navegador;

       public RegisterSucess(ChromeDriver chromeDriver) {
        this.navegador = chromeDriver;
    }

public String mensagemRegistroComSucesso() {
    WebDriverWait wait = new WebDriverWait(navegador, 10);
    
    WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//h1[text()='Your Account Has Been Created!']")
    ));

    return mensagem.getText();
}




    
}
