package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class EditPassWordCheck extends PageBase {

    public EditPassWordCheck(WebDriver navegador) {
        super(navegador);
    }

    public String mudarSenhaSucesso() {
        
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        WebElement alerta = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-success')]")
        ));
        return alerta.getText().trim();
    }
}
