package pages;

import java.security.PublicKey;

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
                ExpectedConditions.elementToBeClickable(by)));

        new Actions(navegador).moveToElement(element).click().perform();
    }

    public void selecionarEmailJaCadastrado() {
        clicar(By.xpath("//*[@id=\"input-shipping-address\"]/option[2]"));
    }

    public void selecionarModoDeEnvio() {
        clicar(By.xpath("//*[@id=\"button-shipping-methods\"]"));
    }

public void confirmarFrete() {
    WebDriverWait wait = new WebDriverWait(navegador, 10); 

    // Espera o alerta sumir, se estiver visível
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".alert")));
   //botão pronto para clicar
    WebElement botao = wait.until(
        ExpectedConditions.elementToBeClickable(By.id("button-shipping-method"))
    );

    botao.click();
}

    public void selecionarMetodoDePagamento(){
        clicar(By.xpath("//*[@id=\"button-payment-methods\"]"));
    }

    public void confirmarMetodoPagamento(){
        WebDriverWait wait = new WebDriverWait(navegador, 10); 

    // Espera o alerta sumir, se estiver visível
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".alert")));
   //botão pronto para clicar
    WebElement botao = wait.until(
        ExpectedConditions.elementToBeClickable(By.id("button-payment-method"))
    );

    botao.click();
    }

    public void finalizarCompra(){

           WebDriverWait wait = new WebDriverWait(navegador, 10);
    WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));

    // Hover no botão para forçar rolagem
    new Actions(navegador).moveToElement(botao).perform();

    // Clicar
    botao.click();
    }


    public void inserirPrimeiroNome(String FIRST_NAME_VALIDO) {
        preencherCampo(By.id("input-shipping-firstname"), FIRST_NAME_VALIDO);
    }

    public void inserirUltimoNome(String LAST_NAME_VALIDO) {

        preencherCampo(By.id("input-shipping-lastname"), LAST_NAME_VALIDO);

    }

    public void inserirEmpresa(String company) {
        preencherCampo(By.id("input-shipping-company"), company);

    }

    public void inserirEndereco(String address) {

        preencherCampo(By.id("input-shipping-address-1"), address);

    }

    public void inserirCidade(String city) {
        preencherCampo(By.id("input-shipping-city"), city);
    }

    public void inseirCodigoPostal(String postCode) {
        preencherCampo(By.id("input-shipping-postcode"), postCode);
    }

}
