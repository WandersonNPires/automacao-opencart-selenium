package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class CheckoutPage extends PageBase {

    public CheckoutPage(WebDriver navegador) {
        super(navegador);

    }

    public void acessarAplicacaoWeb() {
        acessarAplicaca();
    }

    public void finalizarCompraCarrinhoVazio() {
    WebDriverWait wait = new WebDriverWait(navegador, 15);

    By by = By.xpath("//a[@title='Checkout' and .//span[text()='Checkout']]");


    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));

   
    WebElement element = wait.until(ExpectedConditions.refreshed(
        ExpectedConditions.elementToBeClickable(by)
    ));

    
    new Actions(navegador).moveToElement(element).click().perform();
}


}
