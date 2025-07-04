package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class EditAccountInformationCheck extends PageBase {

    public EditAccountInformationCheck(WebDriver navegador) {
        super(navegador);
      
    }

    public String  mudarConta(){
          WebDriverWait wait = new WebDriverWait(navegador, 15);
        WebElement alerta = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-success')]")
        ));
        return alerta.getText();
    }




    
}
