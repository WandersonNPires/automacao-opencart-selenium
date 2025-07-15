package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Checks.CheckoutCheck;
import data.MassOfData;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }
    @Test
    public void comprar(){

        String emailAddress = MassOfData.EMAIL_VALIDO;
        String password = MassOfData.SENHA_VALIDA;

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        LoginPage loginPage= new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();
        CheckoutPage checkoutPage = new CheckoutPage(navegador);
        checkoutPage.finalizarCompraCarrinhoVazio();

        CheckoutCheck carrinhoVazio = new CheckoutCheck(navegador);
        String mensagemEsperada = carrinhoVazio.validarCarrinhoVazio();
        String expectedmessage ="Shopping Cart";
        Assert.assertEquals(mensagemEsperada, expectedmessage);


    }


    
}
