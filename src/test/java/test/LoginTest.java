package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Checks.LoginCheck;
import Checks.RegisterCheck;
import data.MassOfData;
import pages.LoginPage;

public class LoginTest {

    @Test
    public void acessarTeladeLogin() {
        // Usando constantes da massa de dados
        String emailAddress = MassOfData.EMAIL_VALIDO;
        String password = MassOfData.SENHA_VALIDA;
        String expectedLogin = "My Account";

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

        LoginCheck loginsucess = new LoginCheck(navegador);
        String mensagemExibida = loginsucess.loginFeito();
        Assert.assertEquals(mensagemExibida, expectedLogin);

        navegador.quit();
    }

    @Test
    public void loginSemSucesso() {
        // Usando constantes da massa de dados para email e senha inválidos
        String emailAddress = MassOfData.EMAIL_INVALIDO;
        String password = MassOfData.SENHA_INVALIDA;
        String expectedLogin = "Warning: No match for E-Mail Address and/or Password.";

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

        RegisterCheck loginNotsucess = new RegisterCheck(navegador);
        String mensagemExibida = loginNotsucess.capturarAlerta();
        Assert.assertEquals(mensagemExibida, expectedLogin);

        navegador.quit();
    }
}
