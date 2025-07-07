package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class WiishListCheck extends PageBase {

    public WiishListCheck(WebDriver navegador) {
        super(navegador);
        
    }

    public String  telaDesejoAcessada(){
         return obterTexto(By.tagName("h1"));
    }


    
}
