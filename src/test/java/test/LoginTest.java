package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;
import data.MassOfData;
import Checks.LoginCheck;
import Checks.RegisterCheck;
import pages.LoginPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class LoginTest {
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
    public void acessarTeladeLogin() {
        String emailAddress = MassOfData.EMAIL_VALIDO_4;
        String password = MassOfData.SENHA_VALIDA_4;
        String expectedLogin = "My Account";

         navegador = DriverFactory.createChrome();
        //navegador.manage().window().maximize();
        navegador.manage().window().setSize(new Dimension(1920, 1080));

        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

        LoginCheck loginsucess = new LoginCheck(navegador);
        String mensagemExibida = loginsucess.loginFeito();
        Assert.assertEquals(mensagemExibida, expectedLogin);

        PastasDocuments.criarPastaSeNaoExistir("LoginTestDocuments");
        String nomePasta = "LoginTestDocuments";
        String nomeTeste = "acessarTeladeLogin";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);


    }

    @Test
    public void loginSemSucesso() {
        String emailAddress = MassOfData.Email_Invalido;
        String password = MassOfData.Senha_Ivalida;
        String expectedLogin = "Warning: No match for E-Mail Address and/or Password.";

         navegador = DriverFactory.createChrome();
        navegador.manage().window().setSize(new Dimension(1920, 1080));

        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

        RegisterCheck loginNotsucess = new RegisterCheck(navegador);
        String mensagemExibida = loginNotsucess.capturarAlerta();
        Assert.assertEquals(mensagemExibida, expectedLogin);

        PastasDocuments.criarPastaSeNaoExistir("LoginTestDocuments");
        String nomePasta = "LoginTestDocuments";
        String nomeTeste = "loginSemSucesso";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

    }

    // Teste com DatDriven e massa de Dados Dinamica Estruturado
    @Test(dataProvider = "loginData", dataProviderClass = Utils.class)
    public void loginDataDrivenTest(String email, String senha, String esperado) {
      
         navegador = DriverFactory.createChrome();
        //navegador.manage().window().setSize(new Dimension(1920, 1080));
        navegador.manage().window().maximize();
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(email);
        loginPage.inserirPassWordLogin(senha);
        loginPage.logar();

        if (esperado.equals("My Account")) {
            LoginCheck loginCheck = new LoginCheck(navegador);
            String mensagemExibida = loginCheck.loginFeito();
            Assert.assertEquals(mensagemExibida, esperado);
        } else {
            RegisterCheck loginCheck2 = new RegisterCheck(navegador);
            String mensagemExibida2 = loginCheck2.capturarAlerta();
            Assert.assertEquals(mensagemExibida2, esperado);
        }

        PastasDocuments.criarPastaSeNaoExistir("LoginTestDocuments");
        String nomePasta = "LoginTestDocuments";
        String nomeTeste = "loginDataDrivenTest";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

    }
}
