package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class LogoutCheck extends PageBase {

    public LogoutCheck(WebDriver navegador) {
        super(navegador);
    }


    public String logoutRealizado(){

        return obterTexto(By.tagName("h1"));
    }
    
}
