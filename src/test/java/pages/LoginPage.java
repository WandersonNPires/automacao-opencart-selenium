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
       acessarAplicaca();
    }


    public void inserirEmailLogin(String emailAddress){

        preencherCampo(By.id("input-email"), emailAddress);
    }

    public void inserirPassWordLogin(String password){

        preencherCampo(By.id("input-password"), password);
    }

    public void logar(){
        clicar(By.xpath("//form[@id='form-login']//button"));
    }

    
}
