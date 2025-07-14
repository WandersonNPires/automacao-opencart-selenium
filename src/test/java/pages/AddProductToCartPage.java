package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class AddProductToCartPage extends PageBase {

    public AddProductToCartPage(WebDriver navegador) {
        super(navegador);

    }

    public void acessarAplicacaoWeb() {
        acessarAplicaca();
    }

    public void acessarMac() {

        WebDriverWait wait = new WebDriverWait(navegador, 10); //

        WebElement menuDesktops = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Desktops') and contains(@class,'dropdown-toggle')]")));
        new Actions(navegador).moveToElement(menuDesktops).perform();

        WebElement showAllLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[text()='Mac (1)']")));

        showAllLink.click();

    }

    public void clicarNoCarrinhoDeCompra() {

        WebDriverWait wait = new WebDriverWait(navegador, 15);
        By by = By.xpath("//button[i[contains(@class, 'fa-shopping-cart')]]");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".alert-success")));

        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(by));

        Actions actions = new Actions(navegador);
        actions.moveToElement(elemento).click().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-success')]")));
    }

    public void abrirCarrinhoComProdutos() {
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        By botaoExibirProdutos = By.xpath("//*[@id='cart']/div/button");

        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(botaoExibirProdutos));

        Actions actions = new Actions(navegador);
        actions.moveToElement(botao).click().perform();
    }

    public void removerCarrinhoDeCompra() {
        clicar(By.xpath("//div[@id='cart']//table//tr//td//form/button"));

        WebDriverWait wait = new WebDriverWait(navegador, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-success")));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".alert-success")));

    }

}
