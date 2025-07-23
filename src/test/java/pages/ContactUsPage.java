package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class ContactUsPage extends PageBase {

    public ContactUsPage(WebDriver navegador) {
        super(navegador);
    }

    public void acessarAplicacaoWeb(){
        acessarAplicaca();
    }
    
    public void clicarEmContato(){
        clicar(By.xpath("//span[text()='123456789']"));
    }

    public void inserirInformacao(){
        preencherCampo(By.id("input-enquiry"), "Ola, Gostaria de Entrar em Contato com voces");
    }

    public void naoInserirInformacao(){
        preencherCampo(By.id("input-enquiry"), "");
    }

    public void clicaremEnviar(){
        clicar(By.xpath("//button[contains(text(), 'Submit')]"));
    }


}
