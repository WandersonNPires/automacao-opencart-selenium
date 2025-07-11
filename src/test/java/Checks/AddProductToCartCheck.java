package Checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;


public class AddProductToCartCheck extends PageBase{

    public AddProductToCartCheck(WebDriver navegador) {
        super(navegador);
        
    }

    public String validandoProdutoInclusoNoCarrinho(){
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        WebElement alerta = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-success')]")
        ));
        return alerta.getText();

    }

    public String validarQuantidadeNoCarrinho(){
        return obterTexto(By.xpath("//div[@id='cart']//td[contains(@class, 'text-end') and contains(text(), 'x')]"));

    }

    
}
