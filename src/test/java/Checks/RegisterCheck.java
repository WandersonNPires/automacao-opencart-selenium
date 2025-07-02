package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class RegisterCheck  extends PageBase{

      public RegisterCheck(WebDriver navegador) {
        super(navegador);
    }

public String mensagemRegistroComSucesso() {
   return obterTexto(By.xpath("//h1[text()='Your Account Has Been Created!']"));
}

public String capturarAlerta() {
    return alerta(By.xpath("//div[contains(@class, 'alert-danger')]"));
}




    
}
