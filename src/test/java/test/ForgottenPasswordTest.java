package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Checks.ForgottenPasswordCheck;
import pages.ForgottenPasswordPage;

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

         ForgottenPasswordCheck sucess = new ForgottenPasswordCheck(navegador);
         String mensagemEsperada = sucess.textoSucesso();
         Assert.assertEquals(mensagemEsperada, ExpectedMessege); 

        





    }
    
}
