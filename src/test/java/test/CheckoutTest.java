package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Checks.CheckoutCheck;
import data.MassOfData;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest {
    ChromeDriver navegador;

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }

    @BeforeMethod
    public void setup() {
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        LoginPage loginPage = new LoginPage(navegador);
        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(MassOfData.EMAIL_VALIDO);
        loginPage.inserirPassWordLogin(MassOfData.SENHA_VALIDA);
        loginPage.logar();
    }

    @Test
    public void comprarComCarrinhoVazio() {

        CheckoutPage checkoutPage = new CheckoutPage(navegador);
        checkoutPage.finalizarCompraCarrinhoVazio();

        CheckoutCheck carrinhoVazio = new CheckoutCheck(navegador);
        String mensagemEsperada = carrinhoVazio.validarCarrinhoVazio();
        String expectedmessage = "Shopping Cart";
        Assert.assertEquals(mensagemEsperada, expectedmessage);

    }

    public void realizarCompra() {

        CheckoutPage checkoutPage = new CheckoutPage(navegador);
        



    }

}
