package pages;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class WishListPage extends PageBase {

    public WishListPage(WebDriver navegador) {
        super(navegador);
    
    }


    public void acessarAplicacaoWeb(){
        acessarAplicaca();
    }



    public void  acessarListaDesejo(){
        clicar(By.xpath("//a[text()='Modify your wish list']"));
    }


}
