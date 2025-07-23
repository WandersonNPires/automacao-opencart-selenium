package pages;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class WishListPage extends PageBase {

    public WishListPage(WebDriver navegador) {
        super(navegador);
    
    }


    public void acessarAplicacaoWeb(){
        acessarAplicaca();
    }


public void acessarListaDesejo() {
    WebDriverWait wait = new WebDriverWait(navegador, 5); // Espera de até 5 segundos
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Wish List")));

    clicar(By.linkText("Wish List"));
}

    public void  acessarListaDesejo2(){
         
       // clicar(By.xpath("//a[text()='Modify your wish list']"));
    }


}
