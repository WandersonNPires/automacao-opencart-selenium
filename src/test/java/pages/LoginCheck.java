package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.PageBase;


public class LoginCheck extends PageBase  {

 
   public LoginCheck(WebDriver navegador) {
        super(navegador);
    }

    public String loginFeito(){

        return obterTexto(By.tagName("h1"));


        

    }
    
   public String capturarAlerta() {

return alerta(By.xpath("//div[contains(@class, 'alert-danger')]"));
   
}



    
}
