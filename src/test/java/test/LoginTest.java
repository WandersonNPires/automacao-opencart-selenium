package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginCheck;
import pages.LoginPage;
import pages.RegisterCheck;

public class LoginTest {

    @Test
    public void acessarTeladeLogin() {

        String emailAddress= "wandersonneivaa@gmail.com";
        String password= "eumesmo12";
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
        Assert.assertEquals(mensagemExibida,expectedLogin);




    }

    @Test
    public void loginSemSucesso(){

        String emailAddress= "wandersonneiv@gmail.com";
        String password= "";
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




    }

}
