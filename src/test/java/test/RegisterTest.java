package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.nio.file.Files;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Checks.RegisterCheck;
import data.MassOfData;
import pages.RegisterPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class RegisterTest {
    WebDriver navegador;

    @AfterMethod
    public void tearDown() {
        if (navegador != null) {
            navegador.quit();
        }
    }

    @Test
    public void AcessarTelaRegistro() {

        String firstName = "usuarioNovo2";
        String lastName = "Silva";
        String email = "PeterNeiva@gmail.com";
        String password = "eumesmo12";
        String ExpectedMessenge = "Your Account Has Been Created!";

         navegador = DriverFactory.createChrome();
        navegador.manage().window().maximize();
        //navegador.manage().window().setSize(new Dimension(1920, 1080));

        RegisterPage registerPage = new RegisterPage(navegador);

        registerPage.acessarAplicacaoWeb();

        registerPage.inserirPrimeiroNome(firstName);
        registerPage.inserirUltimoNome(lastName);
        registerPage.inserindoEmail(email);
        registerPage.inserirSenha(password);
        registerPage.aceitarPolitica();
        registerPage.clicarParaCriar();

        RegisterCheck registerSucess = new RegisterCheck(navegador);
        String mensagemExibida = registerSucess.mensagemRegistroComSucesso();
        Assert.assertEquals(mensagemExibida, ExpectedMessenge);

         PastasDocuments.criarPastaSeNaoExistir("RegisterTestDocuments");
        String nomePasta = "RegisterTestDocuments";
        String nomeTeste = "AcessarTelaRegistro";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);


    }

    

    @Test
    public void RegistroEmailJaCadastrado() {

        String firstName = MassOfData.FIRST_NAME_VALIDO;
        String lastName = MassOfData.LAST_NAME_VALIDO;
        String email = MassOfData.EMAIL_VALIDO;
        String password = MassOfData.SENHA_VALIDA;
        String ExpectedMessenge = "Warning: E-Mail Address is already registered!";

        WebDriver navegador = DriverFactory.createChrome();
        //navegador.manage().window().maximize();
        navegador.manage().window().setSize(new Dimension(1920, 1080));

        RegisterPage registerPage = new RegisterPage(navegador);

        registerPage.acessarAplicacaoWeb();

        registerPage.inserirPrimeiroNome(firstName);
        registerPage.inserirUltimoNome(lastName);
        registerPage.inserindoEmail(email);
        registerPage.inserirSenha(password);
        registerPage.aceitarPolitica();
        registerPage.clicarParaCriar();
        
        RegisterCheck registerSucess = new RegisterCheck(navegador);
        String mensagemExibida = registerSucess.capturarAlerta();
        Assert.assertEquals(mensagemExibida, ExpectedMessenge);

        PastasDocuments.criarPastaSeNaoExistir("RegisterTestDocuments");
        String nomePasta = "RegisterTestDocuments";
        String nomeTeste = "RegistroEmailJaCadastrado";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);


    }

}
