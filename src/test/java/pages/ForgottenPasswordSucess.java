package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class ForgottenPasswordSucess extends PageBase{

       public ForgottenPasswordSucess(WebDriver navegador) {
        super(navegador);
       }

        public String textoSucesso(){
            return obterTexto(By.xpath("//div[@id='account-login']/div[1]"));

        }

        }
        
       
    


    

