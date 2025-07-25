package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.EditPassWordCheck;
import data.MassOfData;
import pages.EditPassWordAccountPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class EditPassWordAccountTest {


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
    public void editarConta() throws InterruptedException {
        
         navegador = DriverFactory.createChrome();
       // navegador.manage().window().maximize();
        navegador.manage().window().setSize(new Dimension(1920, 1080));

        LoginPage loginPage = new LoginPage(navegador);

        String emailAddress = MassOfData.EMAIL_VALIDO_4;
        String password = MassOfData.SENHA_VALIDA_4;
        String expectedMessage = "Success: Your password has been successfully updated.";

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

        EditPassWordAccountPage editAccountPage = new EditPassWordAccountPage(navegador);

        editAccountPage.acessarTelaMudarSenha();
        editAccountPage.clicarEmTrocar();
        String novaSenha = "senhanova";
        editAccountPage.inserirNovaSenha(novaSenha);
        editAccountPage.inserirConfirmacaoSenha(novaSenha);
        editAccountPage.clicarParaTrocar();

        EditPassWordCheck trocaFeita = new EditPassWordCheck(navegador);
        String mensagemEsperada = trocaFeita.mudarSenhaSucesso();
        Assert.assertEquals(mensagemEsperada, expectedMessage);

        PastasDocuments.criarPastaSeNaoExistir("EditPassDocuments");
        String nomePasta = "EditPassDocuments";
        String nomeTeste = "editarConta";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        

    }
}
