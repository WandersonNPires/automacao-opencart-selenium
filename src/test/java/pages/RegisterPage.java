package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private ChromeDriver navegador;

    public RegisterPage(ChromeDriver chromeDriver) {
        this.navegador = chromeDriver;

    }

    public void acessarAplicacaoWeb() {
        String url = "http://localhost/opencart/index.php?route=account/register&language=en-gb";
        navegador.get(url);
    }

    public void inserirPrimeiroNome(String firstName) {

        WebElement webElement = navegador.findElement(By.id("input-firstname"));
        webElement.sendKeys(firstName);
    }


    public void inserirUltimoNome(String lastName) {
        WebElement webElement = navegador.findElement(By.id("input-lastname"));
        webElement.sendKeys(lastName);
    }


    public void inserindoEmail(String email)
    {

        WebElement webElement = navegador.findElement(By.id("input-email"));
        webElement.sendKeys(email);
    }


    public void inserirSenha(String password){
        WebElement webElement = navegador.findElement(By.id("input-password"));
        webElement.sendKeys(password);
    }

    public void aceitarPolitica(){
        
WebElement checkbox = navegador.findElement(By.xpath("//form[@id='form-register']//input[@name='agree']"));
((JavascriptExecutor) navegador).executeScript("arguments[0].click();", checkbox);

        
    }


    public void clicarParaCriar(){
     JavascriptExecutor js = (JavascriptExecutor) navegador;
WebElement webElement = navegador.findElement(By.xpath("//form[@id='form-register']//button[@type='submit']"));
js.executeScript("arguments[0].click();", webElement);


    }



}
