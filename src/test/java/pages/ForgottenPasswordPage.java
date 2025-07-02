package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bases.PageBase;

public class ForgottenPasswordPage extends PageBase {


    public ForgottenPasswordPage(WebDriver navegador){
    super(navegador);
    }
    
     public void acessarAplicacaoWeb() {
       String url = "http://localhost/opencart/index.php?route=account/login&language=en-gb";
        navegador.get(url);
    }

    public void  esqueciMinhaSenha(){
        WebElement elemento = navegador.findElement(By.xpath("//a[contains(@href, 'route=account/forgotten')]"));
((JavascriptExecutor) navegador).executeScript("arguments[0].click();", elemento);
    }


    public void inserirEmail(String emailAddress){
        preencherCampo(By.id("input-email"), emailAddress);
    }


    public void clicarEmContinue()
    {
        clicar(By.xpath("//form[@id='form-forgotten']//button"));

    }
}
