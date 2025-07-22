package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.LogoutCheck;
import data.MassOfData;
import pages.LoginPage;
import pages.LogoutPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class LogoutTest {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa(); // Chama o script PHP uma única vez antes de todos os testes dessa classe
    }

    @Test
    public void realizarLogout() {

       WebDriver navegador = DriverFactory.createChrome();
        navegador.manage().window().setSize(new Dimension(1920, 1080));
        
        LoginPage loginPage = new LoginPage(navegador);

        String emailAddress = MassOfData.EMAIL_VALIDO_2;
        String password = MassOfData.SENHA_VALIDA_2;
        String ExpectedMessage = "Account Logout";

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

         LogoutPage logoutPage = new LogoutPage(navegador);

        logoutPage.acessarAplicacaoWeb();
        logoutPage.clicarBotaoLogout();

        LogoutCheck logoutSucess = new LogoutCheck(navegador);
        String mensagemExibida = logoutSucess.logoutRealizado();
        System.out.println("Mensagem exibida: " + mensagemExibida);
        Assert.assertEquals(mensagemExibida, ExpectedMessage);


        PastasDocuments.criarPastaSeNaoExistir("LogoutTestDocuments");
        String nomePasta = "LogoutTestDocuments";
        String nomeTeste = "realizarLogout";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);
  
        navegador.quit();
    }

}
