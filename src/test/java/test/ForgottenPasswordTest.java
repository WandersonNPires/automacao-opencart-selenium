package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ForgottenPasswordPage;
import pages.ForgottenPasswordSucess;

public class ForgottenPasswordTest {

    @Test
    public void inserindoEmail(){

        String emailAddress= "wandersonneivaa@gmail.com";
        String ExpectedMessege ="text_success";

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        ForgottenPasswordPage ForgottenPasswordPage = new ForgottenPasswordPage(navegador);

         ForgottenPasswordPage.acessarAplicacaoWeb();
         ForgottenPasswordPage.esqueciMinhaSenha();
         ForgottenPasswordPage.inserirEmail(emailAddress);
         ForgottenPasswordPage.clicarEmContinue();

         ForgottenPasswordSucess sucess = new ForgottenPasswordSucess(navegador);
         String mensagemEsperada = sucess.textoSucesso();
         Assert.assertEquals(mensagemEsperada, ExpectedMessege); 

        





    }
    
}
