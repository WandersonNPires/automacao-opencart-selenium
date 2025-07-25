package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.EditAccountInformationCheck;
import data.MassOfData;
import pages.EditAccountInformationPage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class EditAccountInformationTest {

    WebDriver navegador;

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }

    @AfterMethod
    public void tearDown() {
        if (navegador != null) {
            navegador.quit();
        }
    }

    

    @Test
    public void editarInformacaoConta() {
        
         navegador = DriverFactory.createChrome();
       navegador.manage().window().maximize();
        //navegador.manage().window().setSize(new Dimension(1920, 1080));

        LoginPage loginPage = new LoginPage(navegador);

        String emailAddress = MassOfData.EMAIL_VALIDO_4;
        String password = MassOfData.SENHA_VALIDA_4;
        String expectedMessage = "Success: Your account has been successfully updated.";

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

        EditAccountInformationPage edit = new EditAccountInformationPage(navegador);

        edit.acessarTelaAlterarConta();
        edit.clicarParaMudarDadosConta();

        String novoNome = "WandersonALTERADO";
        String novoUltimoNome = "SilvaaLTERADO";
        String novoEmail = "wandersonneivaaLTERADO@gmail.com";
        edit.inserirNovosDados(novoNome);
        edit.inserirUltimoNome(novoUltimoNome);
        edit.inseriEmail(novoEmail);
        edit.cliarParaTrocarDados();

        EditAccountInformationCheck contaAlterada = new EditAccountInformationCheck(navegador);
        String mensagemEsperada = contaAlterada.mudarConta();
        Assert.assertEquals(mensagemEsperada, expectedMessage);

        PastasDocuments.criarPastaSeNaoExistir("EditAccountDocuments");
        String nomePasta = "EditAccountDocuments";
        String nomeTeste = "editarInformacaoConta";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        

    }
}
