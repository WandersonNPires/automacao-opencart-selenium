package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.ForgottenPasswordCheck;
import data.MassOfData;
import pages.ForgottenPasswordPage;

public class ForgottenPasswordTest {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa(); 
    }

    @Test
    public void inserindoEmail(){

        String emailAddress= MassOfData.EMAIL_VALIDO_3;
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
