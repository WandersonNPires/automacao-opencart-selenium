package Checks;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class ContactUsCheck extends PageBase{

    public ContactUsCheck(WebDriver navegador) {
        super(navegador);
    }

    public String validarMensagemEnviada(){
       return obterTexto(By.xpath("//*[@id='content']/p"));
    }

    public String validarMensagemFalha(){
        return obterTexto(By.xpath("//*[@id=\"error-enquiry\"]"));
    }
    
}
