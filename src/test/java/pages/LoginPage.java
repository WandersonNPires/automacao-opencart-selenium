package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bases.PageBase;

public class LoginPage extends PageBase{

    
   public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public void acessarAplicacaoWeb() {
       String url = "http://localhost/opencart/index.php?route=account/login&language=en-gb";
        navegador.get(url);
    }


    public void inserirEmailLogin(String emailAddress){

        preencherCampo(By.id("input-email"), emailAddress);
    }

    public void inserirPassWordLogin(String password){

        preencherCampo(By.id("input-password"), password);
    }

    public void logar(){
        clicar(By.xpath("//*[@id=\"form-login\"]/div[3]/button"));
    }

    
}
