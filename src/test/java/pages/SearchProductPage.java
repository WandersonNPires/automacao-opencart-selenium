package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;

public class SearchProductPage extends PageBase {

    public SearchProductPage(WebDriver navegador) {
        super(navegador);

    }

    public void acessarAplicacaoWeb() {
        acessarAplicaca();
    }

    public void buscarDesktop() {
        WebDriverWait wait = new WebDriverWait(navegador, 10); //

        WebElement menuDesktops = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Desktops') and contains(@class,'dropdown-toggle')]")));
        new Actions(navegador).moveToElement(menuDesktops).perform();

        WebElement showAllLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[text()='Show All Desktops']")));

        showAllLink.click();
    }

    public void acessarLaptopseNotebooks() {
        By seletor = By.cssSelector("#column-left > div.list-group.mb-3 > a.list-group-item");
        List<WebElement> links = navegador.findElements(seletor);

        for (WebElement link : links) {
            if (link.getText().contains("Laptops & Notebooks")) {
                link.click();
                break;
            }
        }

    }

    public void acessarTablets(){
        By seletor = By.cssSelector("#column-left > div.list-group.mb-3 > a.list-group-item");
        List<WebElement> links = navegador.findElements(seletor);

        for (WebElement link : links) {
            if (link.getText().contains("Tablets ")) {
                link.click();
                break;
            }
        }
    }

    public void acessarComponentesEmonitores() {
        WebDriverWait wait = new WebDriverWait(navegador, 10);
        WebElement componentsLink = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("#column-left > div.list-group.mb-3 > a:nth-child(5)")));
        ((JavascriptExecutor) navegador).executeScript("arguments[0].scrollIntoView(true);", componentsLink);
        ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", componentsLink);

        List<WebElement> links = navegador
                .findElements(By.cssSelector("#column-left > div.list-group.mb-3 > a.list-group-item"));
        for (WebElement link : links) {
            if (link.getText().contains("Monitors")) {
                ((JavascriptExecutor) navegador).executeScript("arguments[0].scrollIntoView(true);", link);
                ((JavascriptExecutor) navegador).executeScript("arguments[0].click();", link);
                break;
            }

        }

    }

      public void acessarProdutoInexistente(){

         WebDriverWait wait = new WebDriverWait(navegador, 10); //

        WebElement menuDesktops = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Laptops & Notebooks') and contains(@class,'dropdown-toggle')]")));
        new Actions(navegador).moveToElement(menuDesktops).perform();

        WebElement showAllLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[text()='Macs (0)']")));

        showAllLink.click();
    }
            
        }

      

