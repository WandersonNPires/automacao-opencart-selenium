package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class AddProductToCartPage  extends PageBase{

    public AddProductToCartPage(WebDriver navegador) {
        super(navegador);
        
    }

    public void acessarAplicacaoWeb(){
        acessarAplicaca();
    }


    public void acessarMac(){

         WebDriverWait wait = new WebDriverWait(navegador, 10); //

        WebElement menuDesktops = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Desktops') and contains(@class,'dropdown-toggle')]")));
        new Actions(navegador).moveToElement(menuDesktops).perform();

        WebElement showAllLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[text()='Mac (1)']")));

        showAllLink.click();

    }

    public void clicarNoCarrinhoDeCompra(){
       By by = By.xpath("//button[i[contains(@class, 'fa-shopping-cart')]]");

    WebDriverWait wait = new WebDriverWait(navegador, 10);

    WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(by));

    Actions actions = new Actions(navegador);
    actions.moveToElement(elemento).perform();

    wait.until(ExpectedConditions.elementToBeClickable(by));

    elemento.click();
}

        }


