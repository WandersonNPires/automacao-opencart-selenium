package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class OrderHistoryCheck extends PageBase {

    public OrderHistoryCheck(WebDriver navegador) {
        super(navegador);
        
    }

    
    public String  TelaHistorico(){
         return obterTexto(By.tagName("h1"));
    }
    
}
