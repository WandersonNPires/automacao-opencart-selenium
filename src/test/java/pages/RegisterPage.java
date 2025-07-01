package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class RegisterPage extends PageBase {

    public RegisterPage(WebDriver navegador) {
        super(navegador);
    }

    public void acessarAplicacaoWeb() {
      
     String url = "http://localhost/opencart/index.php?route=account/register&language=en-gb";
        navegador.get(url);;
    }

    public void inserirPrimeiroNome(String firstName) {

        preencherCampo(By.id("input-firstname"), firstName);

    }

    public void inserirUltimoNome(String lastName) {
        preencherCampo(By.id("input-lastname"), lastName);
    }

    public void inserindoEmail(String email) {
        preencherCampo(By.id("input-email"), email);
    }

    public void inserirSenha(String password) {

        preencherCampo(By.id("input-password"), password);
    }

    public void aceitarPolitica() {

        WebElement checkbox = navegador.findElement(By.xpath("//form[@id='form-register']//input[@name='agree']"));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", checkbox);

    }

    public void clicarParaCriar() {
        JavascriptExecutor js = (JavascriptExecutor) navegador;
        WebElement webElement = navegador.findElement(By.xpath("//form[@id='form-register']//button[@type='submit']"));
        js.executeScript("arguments[0].click();", webElement);

    }

}
