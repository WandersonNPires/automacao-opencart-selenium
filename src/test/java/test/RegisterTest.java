package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.nio.file.Files;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Checks.RegisterCheck;
import data.MassOfData;
import pages.RegisterPage;
import utils.DriverFactory;
import utils.Report;

public class RegisterTest {

    @Test
    public void AcessarTelaRegistro() {

        String firstName = "usuarioNovo";
        String lastName = "Silva";
        String email = "Peter@gmail.com";
        String password = "eumesmo12";
        String ExpectedMessenge = "Your Account Has Been Created!";

        ChromeDriver navegador = DriverFactory.createChrome();
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
        String mensagemExibida = registerSucess.mensagemRegistroComSucesso();
        Assert.assertEquals(mensagemExibida, ExpectedMessenge);

        String nomePasta = "RegisterTestDocuments";
        String nomeTeste = "AcessarTelaRegistro";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

    

    @Test
    public void RegistroEmailJaCadastrado() {

        String firstName = MassOfData.FIRST_NAME_VALIDO;
        String lastName = MassOfData.LAST_NAME_VALIDO;
        String email = MassOfData.EMAIL_VALIDO;
        String password = MassOfData.SENHA_VALIDA;
        String ExpectedMessenge = "Warning: E-Mail Address is already registered!";

        ChromeDriver navegador = DriverFactory.createChrome();
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

        
        String nomePasta = "RegisterTestDocuments";
        String nomeTeste = "RegistroEmailJaCadastrado";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

}
