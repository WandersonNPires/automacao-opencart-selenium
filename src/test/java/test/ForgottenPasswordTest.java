package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.ForgottenPasswordCheck;
import data.MassOfData;
import pages.ForgottenPasswordPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class ForgottenPasswordTest {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }

    @Test
    public void inserindoEmail() {

        String emailAddress = MassOfData.EMAIL_VALIDO_3;
        String ExpectedMessege = "text_success";
        
        WebDriver navegador = DriverFactory.createChrome();
        navegador.manage().window().setSize(new Dimension(1920, 1080));

        ForgottenPasswordPage ForgottenPasswordPage = new ForgottenPasswordPage(navegador);

        ForgottenPasswordPage.acessarAplicacaoWeb();
        ForgottenPasswordPage.esqueciMinhaSenha();
        ForgottenPasswordPage.inserirEmail(emailAddress);
        ForgottenPasswordPage.clicarEmContinue();

        ForgottenPasswordCheck sucess = new ForgottenPasswordCheck(navegador);
        String mensagemEsperada = sucess.textoSucesso();
        Assert.assertEquals(mensagemEsperada, ExpectedMessege);

        PastasDocuments.criarPastaSeNaoExistir("ForgottenPassDocuments");
        String nomePasta = "ForgottenPassDocuments";
        String nomeTeste = "inserindoEmail";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

}
