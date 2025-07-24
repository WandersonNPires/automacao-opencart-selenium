package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Checks.ContactUsCheck;
import data.MassOfData;
import pages.AddProductToCartPage;
import pages.ContactUsPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class ContactUsTest {
    WebDriver navegador;
    
    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }

     @BeforeMethod
    public void setup() {
       
         navegador = DriverFactory.createChrome();
        // navegador.manage().window().maximize();
        navegador.manage().window().setSize(new Dimension(1920, 1080));

        LoginPage loginPage = new LoginPage(navegador);
        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(MassOfData.EMAIL_VALIDO);
        loginPage.inserirPassWordLogin(MassOfData.SENHA_VALIDA);
        loginPage.logar();
    }


    @Test
    public void contactarEmpresa(){

        ContactUsPage contactUsPage = new ContactUsPage(navegador);

        contactUsPage.acessarAplicacaoWeb();
        contactUsPage.clicarEmContato();
        contactUsPage.inserirInformacao();
        contactUsPage.clicaremEnviar();

        ContactUsCheck mensagemEnviada = new ContactUsCheck(navegador);
        String mensagemEsperada = mensagemEnviada.validarMensagemEnviada();
        String expectedMessage = "Your enquiry has been successfully sent to the store owner!";
        Assert.assertEquals(mensagemEsperada, expectedMessage);
        
        String nomePasta ="ContactUsDocuments";
       String nomeTeste ="contactarEmpresa";

       Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
       Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);


    }
    @Test
    public void campoContactarEmBranco(){

        ContactUsPage contactUsPage = new ContactUsPage(navegador);

        contactUsPage.acessarAplicacaoWeb();
        contactUsPage.clicarEmContato();
        contactUsPage.naoInserirInformacao();
        contactUsPage.clicaremEnviar();

        ContactUsCheck nadaEnviado = new ContactUsCheck(navegador);
        String mensagemEsperada2 = nadaEnviado.validarMensagemFalha();
        String expectedMessage2 = "Enquiry must be between 10 and 3000 characters!";
        Assert.assertEquals(mensagemEsperada2, expectedMessage2);


        PastasDocuments.criarPastaSeNaoExistir("ContactUsDocuments");

       String nomePasta ="ContactUsDocuments";
       String nomeTeste ="campoContactarEmBranco";

       Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
       Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

       
    }
        @AfterMethod
    public void tearDown() {
        if (navegador != null) {
            navegador.quit();
        }
    }
    
}

