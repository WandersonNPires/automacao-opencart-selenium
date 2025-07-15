package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class CheckoutCheck extends PageBase{

    public CheckoutCheck(WebDriver navegador) {
        super(navegador);
    }

    public String validarCarrinhoVazio(){

        return obterTexto(By.tagName("h1"));

    }
    
}
