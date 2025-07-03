package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class EditCheck extends PageBase {

    public EditCheck(WebDriver navegador) {
        super(navegador);
    }

    public String mudarSenhaSucesso() {
        // Espera até o elemento estar presente no DOM (não necessariamente visível)
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        WebElement alerta = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-success')]")
        ));
        return alerta.getText().trim();
    }
}
