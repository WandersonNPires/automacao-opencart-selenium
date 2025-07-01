package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bases.PageBase;

public class LogoutPage  extends PageBase{

public LogoutPage(WebDriver navegador){

super(navegador);
}

public void acessarLogin(){
String url = "http://localhost/opencart/index.php?route=account/login&language=en-gb";
        navegador.get(url);

}

public void acessarAplicacaoWeb(){

     String url = "http://localhost/opencart/index.php?route=account/account&language=en-gb&customer_token=cee47c17282cfa98b3b86365e4";
        navegador.get(url);
}

public void clicarBotaoLogout(){

    WebElement elemento = navegador.findElement(By.xpath("//a[contains(@href, 'route=account/logout')]"));
((JavascriptExecutor) navegador).executeScript("arguments[0].click();", elemento);

}


    
}
