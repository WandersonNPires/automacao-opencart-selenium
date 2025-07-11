package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.AddProductToCartCheck;
import data.MassOfData;
import pages.AddProductToCartPage;
import pages.LoginPage;

public class AddProductToCartTest {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }

    @Test

    public void adicionarProdutoNoCarrinho() {
        String emailAddress = MassOfData.EMAIL_VALIDO;
        String password = MassOfData.SENHA_VALIDA;

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

        AddProductToCartPage addProductToCartPage = new AddProductToCartPage(navegador);

        addProductToCartPage.acessarAplicacaoWeb();
        addProductToCartPage.acessarMac();
        addProductToCartPage.clicarNoCarrinhoDeCompra();

        AddProductToCartCheck adicionaCarrinho = new AddProductToCartCheck(navegador);
        String menssagemEsperada = adicionaCarrinho.validandoProdutoInclusoNoCarrinho();
        String expectedMessage = "Success: You have added iMac to your shopping cart!";
        Assert.assertEquals(menssagemEsperada, expectedMessage);

        addProductToCartPage.abrirCarrinhoComProdutos();

        AddProductToCartCheck validarQuatidadeCarrinho = new AddProductToCartCheck(navegador);
        String mensssagemEsperada = validarQuatidadeCarrinho.validarQuantidadeNoCarrinho();
        String expextedMessage2 ="x 1";
        Assert.assertEquals(mensssagemEsperada, expextedMessage2);

        addProductToCartPage.clicarNoCarrinhoDeCompra();

        AddProductToCartCheck adicionaCarrinho2 = new AddProductToCartCheck(navegador);
        String menssagemEsperada2 = adicionaCarrinho2.validandoProdutoInclusoNoCarrinho();
        String expectedMessage2 = "Success: You have added iMac to your shopping cart!";
        Assert.assertEquals(menssagemEsperada2, expectedMessage2);

        addProductToCartPage.abrirCarrinhoComProdutos();
        AddProductToCartCheck validarQuatidadeCarrinho2 = new AddProductToCartCheck(navegador);
        String mensssagemEsperada2 = validarQuatidadeCarrinho2.validarQuantidadeNoCarrinho();
        String expextedMessage3 ="x 2";
        Assert.assertEquals(mensssagemEsperada2, expextedMessage3);
        

    }

}
