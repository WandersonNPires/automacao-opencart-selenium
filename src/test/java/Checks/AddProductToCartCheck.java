package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class AddProductToCartCheck extends PageBase {

    public AddProductToCartCheck(WebDriver navegador) {
        super(navegador);

    }

    public String validandoProdutoInclusoNoCarrinho() {
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        WebElement alerta = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-success')]")));
        return alerta.getText();

    }

    public String validarQuantidadeNoCarrinho() {
        return obterTexto(By.xpath("//div[@id='cart']//td[contains(@class, 'text-end') and contains(text(), 'x')]"));

    }

    public String validarRemoçãoDoCarrinho() {
        WebDriverWait wait = new WebDriverWait(navegador, 15);

        By botaoCarrinho = By.xpath("//*[@id='cart']/div/button");
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(botaoCarrinho));
        new Actions(navegador).moveToElement(botao).click().perform();

        return obterTexto(By.xpath("//*[@id=\"cart\"]/div/ul/li[contains(text(), 'Your shopping cart is empty!')]"));

    }

    public String validarMensagemdeRemocaodeItem(){
        
        WebDriverWait wait = new WebDriverWait(navegador, 15); 
    WebElement alerta = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[@id='alert']/div")
    ));
    return alerta.getText();
    }

    public String validarTotalCarrinho() {
        

        By botaoCarrinho = By.xpath("//*[@id='cart']/div/button");
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(botaoCarrinho));
        new Actions(navegador).moveToElement(botao).click().perform();

        return obterTexto(By.xpath("//div[@id='cart']//td[contains(@class, 'text-end') and contains(text(), '$')]"));

    }

    public String visualizarCarrinho(){
        return obterTexto(By.tagName("h1"));

    }

    public String visualizarCarrinhoComProduto(){
        return obterTexto(By.xpath("//div[@id='output-cart']//td[2]//ul/li/small"));
    }

}
