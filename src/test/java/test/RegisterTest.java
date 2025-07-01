package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.RegisterPage;
import pages.RegisterCheck;

public class RegisterTest {

    @Test
    public void AcessarTelaRegistro() {

        String firstName = "wanderson";
        String lastName = "Silva";
        String email = "wandersonneivatest@gmail.com";
        String password = "eumesmo12";
        String ExpectedMessenge = "Your Account Has Been Created!";

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

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

    }

    

    @Test
    public void RegistroEmailJaCadastrado() {

        String firstName = "wanderson";
        String lastName = "Silva";
        String email = "wandersonneiva@gmail.com";
        String password = "eumesmo12";
        String ExpectedMessenge = "Warning: E-Mail Address is already registered!";

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

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

    }

}
