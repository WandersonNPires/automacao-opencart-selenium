package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.MassOfData;
import Checks.LoginCheck;
import Checks.RegisterCheck;
import pages.LoginPage;

public class LoginTest {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa(); // Chama o script PHP uma única vez antes de todos os testes dessa classe
    }

    @Test
    public void acessarTeladeLogin() {
        String emailAddress = MassOfData.EMAIL_VALIDO_4;
        String password = MassOfData.SENHA_VALIDA_4;
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
        String emailAddress = MassOfData.Email_Invalido;
        String password = MassOfData.Senha_Ivalida;
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
