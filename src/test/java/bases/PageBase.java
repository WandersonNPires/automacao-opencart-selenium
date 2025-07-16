package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver navegador;

    public PageBase(WebDriver navegador) {
        this.navegador = navegador;
    }

    protected void acessarAplicaca() {
        String url = "http://localhost/opencart/index.php?route=account/login&language=en-gb";
        navegador.get(url);
    }

    protected void preencherCampo(By by, String valor) {
        navegador.findElement(by).sendKeys(valor);
    }

    protected void clicar(By by) {
         navegador.findElement(by).click();

    }

    protected String obterTexto(By by) {
        // return navegador.findElement(by).getText();
        WebDriverWait wait = new WebDriverWait(navegador, 10); 
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return elemento.getText();
    }

    protected String alerta(By by) {

        WebDriverWait wait = new WebDriverWait(navegador, 10);

        WebElement alerta = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-danger')]")));

        String textoAlerta = alerta.getText();

        wait.until(ExpectedConditions.invisibilityOf(alerta));

        return textoAlerta;
    }

}
