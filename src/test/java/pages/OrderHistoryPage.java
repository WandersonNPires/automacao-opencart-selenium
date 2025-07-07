package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class OrderHistoryPage extends PageBase {

    public OrderHistoryPage(WebDriver navegador) {
        super(navegador);
        
    }

    public void acessarAplicacaoWeb(){
        acessarAplicaca();
    }


    public void  acessarHistoricoPedidos(){
        clicar(By.xpath("//a[text()='View your order history']"));
    }

    


    


}
