package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class SearchProductCheck  extends PageBase{

    public SearchProductCheck(WebDriver navegador) {
        super(navegador);
    }


    public String validarDekstops(){
       return obterTexto(By.tagName("h1"));
    }

    public String validarLaptops(){
        return obterTexto(By.xpath("//div[@id='content']//p[contains(text(), 'Shop Laptop feature')]"));
    }

    public String validarMonitors(){
       return obterTexto(By.tagName("h1"));
    }


    public String validarProdutoInexistente(){
        return obterTexto(By.xpath("//div[@id='content']//p[contains(text(), 'There are no products to list in this category.')]"));

    }

    public String validarTablets(){
        return obterTexto(By.tagName("h1"));
    }



    
}
