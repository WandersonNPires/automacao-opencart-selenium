package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Checks.AddProductToCartCheck;
import data.MassOfData;
import pages.AddProductToCartPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class AddProductToCartTest {
    ChromeDriver navegador;

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }

    @BeforeMethod
    public void setup() {
       
        ChromeDriver navegador = DriverFactory.createChrome();
        navegador.manage().window().setSize(new Dimension(1920, 1080));

        LoginPage loginPage = new LoginPage(navegador);
        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(MassOfData.EMAIL_VALIDO);
        loginPage.inserirPassWordLogin(MassOfData.SENHA_VALIDA);
        loginPage.logar();
    }

    @Test
    public void adicionarProdutoNoCarrinho() {

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
        String expextedMessage2 = "x 1";
        Assert.assertEquals(mensssagemEsperada, expextedMessage2);

        addProductToCartPage.clicarNoCarrinhoDeCompra();

        AddProductToCartCheck adicionaCarrinho2 = new AddProductToCartCheck(navegador);
        String menssagemEsperada2 = adicionaCarrinho2.validandoProdutoInclusoNoCarrinho();
        String expectedMessage2 = "Success: You have added iMac to your shopping cart!";
        Assert.assertEquals(menssagemEsperada2, expectedMessage2);

        addProductToCartPage.abrirCarrinhoComProdutos();

        AddProductToCartCheck validarQuatidadeCarrinho2 = new AddProductToCartCheck(navegador);
        String mensssagemEsperada2 = validarQuatidadeCarrinho2.validarQuantidadeNoCarrinho();
        String expextedMessage3 = "x 2";
        Assert.assertEquals(mensssagemEsperada2, expextedMessage3);

        PastasDocuments.criarPastaSeNaoExistir("AddProductDocuments");
        String nomePasta = "AddProductDocuments";
        String nomeTeste = "adicionarProdutoNoCarrinho";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

    @Test
    public void removerProduto() {

        AddProductToCartPage addProductToCartPage = new AddProductToCartPage(navegador);

        addProductToCartPage.acessarAplicacaoWeb();
        addProductToCartPage.acessarMac();
        addProductToCartPage.clicarNoCarrinhoDeCompra();
        addProductToCartPage.abrirCarrinhoComProdutos();
        addProductToCartPage.removerCarrinhoDeCompra();

        AddProductToCartCheck validarRemocaoItem = new AddProductToCartCheck(navegador);
        String mensagemEsperada = validarRemocaoItem.validarMensagemdeRemocaodeItem();
        String expextedMessage = "Success: You have removed an item from your shopping cart!";
        Assert.assertEquals(mensagemEsperada, expextedMessage);

        AddProductToCartCheck validarRemocao = new AddProductToCartCheck(navegador);
        String mensagemEsperada2 = validarRemocao.validarRemoçãoDoCarrinho();
        String expectedMessage2 = "Your shopping cart is empty!";
        Assert.assertEquals(mensagemEsperada2, expectedMessage2);

        PastasDocuments.criarPastaSeNaoExistir("AddProductDocuments");
        String nomePasta = "AddProductDocuments";
        String nomeTeste = "removerProduto";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

    @Test
    public void validarTotalCarrinho() {
        AddProductToCartPage addProductToCartPage = new AddProductToCartPage(navegador);
        addProductToCartPage.acessarMac();
        addProductToCartPage.clicarNoCarrinhoDeCompra();

        AddProductToCartCheck adicionaCarrinho3 = new AddProductToCartCheck(navegador);
        String menssagemEsperada3 = adicionaCarrinho3.validandoProdutoInclusoNoCarrinho();
        String expectedMessage3 = "Success: You have added iMac to your shopping cart!";
        Assert.assertEquals(menssagemEsperada3, expectedMessage3);

        AddProductToCartCheck validarValorCarrinho = new AddProductToCartCheck(navegador);
        String mensagemEsperada = validarValorCarrinho.validarTotalCarrinho();
        String expectedmessange = "$100.00";
        Assert.assertEquals(mensagemEsperada, expectedmessange);

        addProductToCartPage.clicarNoCarrinhoDeCompra();

        AddProductToCartCheck adicionaCarrinho4 = new AddProductToCartCheck(navegador);
        String menssagemEsperada4 = adicionaCarrinho4.validandoProdutoInclusoNoCarrinho();
        String expectedMessage4 = "Success: You have added iMac to your shopping cart!";
        Assert.assertEquals(menssagemEsperada4, expectedMessage4);

        AddProductToCartCheck validarValorCarrinho2 = new AddProductToCartCheck(navegador);
        String mensagemEsperada2 = validarValorCarrinho2.validarTotalCarrinho();
        String expectedmessange2 = "$200.00";
        Assert.assertEquals(mensagemEsperada2, expectedmessange2);

        PastasDocuments.criarPastaSeNaoExistir("AddProductDocuments");
        String nomePasta = "AddProductDocuments";
        String nomeTeste = "validarTotalCarrinho";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

    @Test
    public void visualizarCarrinho() {
        AddProductToCartPage addProductToCartPage = new AddProductToCartPage(navegador);
        addProductToCartPage.acessarAplicacaoWeb();
        addProductToCartPage.acessarMac();
        addProductToCartPage.clicarNoCarrinhoDeCompra();
        addProductToCartPage.abrirCarrinhoComProdutos();
        addProductToCartPage.acessarCarrinhoDeCompras();

        AddProductToCartCheck visualizarCarrinho = new AddProductToCartCheck(navegador);
        String mensagemEsperada = visualizarCarrinho.visualizarCarrinho();
        String expectedMessage = "Shopping Cart (5.00kg)";
        Assert.assertEquals(mensagemEsperada, expectedMessage);

        AddProductToCartCheck carrinhoComProduto = new AddProductToCartCheck(navegador);
        String mensagemEsperada2 = carrinhoComProduto.visualizarCarrinhoComProduto();
        String expectedMessage2 = "- Model: Product 14";
        Assert.assertEquals(mensagemEsperada2, expectedMessage2);

        PastasDocuments.criarPastaSeNaoExistir("AddProductDocuments");
        String nomePasta = "AddProductDocuments";
        String nomeTeste = "visualizarCarrinho";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

}
