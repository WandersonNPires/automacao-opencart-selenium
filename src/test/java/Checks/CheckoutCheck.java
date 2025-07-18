package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class CheckoutCheck extends PageBase {

    public CheckoutCheck(WebDriver navegador) {
        super(navegador);
    }

    public String validarCarrinhoVazio() {

        return obterTexto(By.tagName("h1"));

    }

    public String validarConfirmacaoFreteEnvio() {
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        WebElement alerta = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='alert']/div")));
        return alerta.getText();
    }

    public String validarConfirmacaoPagamento() {
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        WebElement alerta = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='alert']/div")));
        return alerta.getText();
    }

    public String validarCompra(){
         WebDriverWait wait = new WebDriverWait(navegador, 10);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(
        By.tagName("h1"), "Your order has been placed!"));

    return obterTexto(By.tagName("h1"));
    }

    public String validarDadoIvalidos(){
      return  obterTexto(By.xpath("//*[@id=\"error-shipping-firstname\"]"));
    }
}
