package pages;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bases.PageBase;

public class EditAccountInformationPage extends PageBase {

    public EditAccountInformationPage(WebDriver navegador) {
        super(navegador);
       
    }

    public void acessarAplicacaoWeb(){
        acessarAplicaca();
    }

    public void acessarTelaAlterarConta(){
         String url = "http://localhost/opencart/index.php?route=account/password&language=en-gb&customer_token=5c0f699ce3d76f5a6bd45dd638";
        navegador.get(url);
    }

    public void clicarParaMudarDadosConta(){
       
   clicar(By.xpath("//a[text()='Edit your account information']"));

    }

    public void inserirNovosDados(String FIRST_NAME_VALIDO_4){

         WebElement campoEmail = navegador.findElement(By.id("input-firstname"));
        campoEmail.clear();
        campoEmail.sendKeys(FIRST_NAME_VALIDO_4);

    }

     public void inserirUltimoNome(String LAST_NAME_VALIDO_4) {
        WebElement campoEmail = navegador.findElement(By.id("input-lastname"));
        campoEmail.clear();
        campoEmail.sendKeys(LAST_NAME_VALIDO_4);
    }

    public void inseriEmail(String EMAIL_VALIDO_4)
    {
         WebElement campoEmail = navegador.findElement(By.id("input-email"));
        campoEmail.clear();
        campoEmail.sendKeys(EMAIL_VALIDO_4);
    }

    public void cliarParaTrocarDados(){
        clicar(By.xpath("//button[text()='Continue']"));
    }

    



    }




    

