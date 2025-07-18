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
import pages.AddProductToCartPage;
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

    @Test
    public void realizarCompraEnderecoJaCadastrado() {

        AddProductToCartPage addProductToCartPage = new AddProductToCartPage(navegador);

        addProductToCartPage.acessarMac();
        addProductToCartPage.clicarNoCarrinhoDeCompra();
        addProductToCartPage.abrirCarrinhoComProdutos();
        addProductToCartPage.acessarTelaFinalizarCompra();

        CheckoutPage checkoutPage = new CheckoutPage(navegador);

        checkoutPage.selecionarEmailJaCadastrado();
        checkoutPage.selecionarModoDeEnvio();
        checkoutPage.confirmarFrete();

        CheckoutCheck validarConfirmacaoFrete = new CheckoutCheck(navegador);
        String mensagemEsperada = validarConfirmacaoFrete.validarConfirmacaoFreteEnvio();
        String expectedMessage = "Success: You have changed shipping method!";
        Assert.assertEquals(mensagemEsperada, expectedMessage);

        checkoutPage.selecionarMetodoDePagamento();
        checkoutPage.confirmarMetodoPagamento();

        CheckoutCheck validarConfirmacaoPagamento = new CheckoutCheck(navegador);
        String mensagemEsperada2 = validarConfirmacaoPagamento.validarConfirmacaoPagamento();
        String expectedMessage2 = "Success: You have changed payment method!";
        Assert.assertEquals(mensagemEsperada2, expectedMessage2);

        checkoutPage.finalizarCompra();

        CheckoutCheck validarCompra = new CheckoutCheck(navegador);
        String mensagemEsperada3 = validarCompra.validarCompra();
        String expectedMessage3 = "Your order has been placed!";
        Assert.assertEquals(mensagemEsperada3, expectedMessage3);
    }

    @Test
    public void realizarCompraNovoEdereço() {

        AddProductToCartPage addProductToCartPage = new AddProductToCartPage(navegador);

        addProductToCartPage.acessarMac();
        addProductToCartPage.clicarNoCarrinhoDeCompra();
        addProductToCartPage.abrirCarrinhoComProdutos();
        addProductToCartPage.acessarTelaFinalizarCompra();

        CheckoutPage checkoutPage = new CheckoutPage(navegador);

        String firstName = MassOfData.FIRST_NAME_VALIDO;
        String lastName = MassOfData.LAST_NAME_VALIDO;
        String company = "B2";
        String address = "Rua nova2";
        String city = "Belo Horizonte";
        String postCode = "133";

        checkoutPage.inserirNovoEndereco();
        checkoutPage.inserirPrimeiroNome(firstName);
        checkoutPage.inserirUltimoNome(lastName);
        checkoutPage.inserirEmpresa(company);
        checkoutPage.inserirEndereco(address);
        checkoutPage.inserirCidade(city);
        checkoutPage.inseirCodigoPostal(postCode);
        checkoutPage.selecionarPais();
        checkoutPage.selecionarRegiao();
        checkoutPage.confirmanovoEmail();
        checkoutPage.selecionarModoDeEnvio();
        checkoutPage.confirmarFrete();
        CheckoutCheck validarConfirmacaoFrete = new CheckoutCheck(navegador);
        String mensagemEsperada = validarConfirmacaoFrete.validarConfirmacaoFreteEnvio();
        String expectedMessage = "Success: You have changed shipping method!";
        Assert.assertEquals(mensagemEsperada, expectedMessage);

        checkoutPage.selecionarMetodoDePagamento();
        checkoutPage.confirmarMetodoPagamento();

        CheckoutCheck validarConfirmacaoPagamento = new CheckoutCheck(navegador);
        String mensagemEsperada2 = validarConfirmacaoPagamento.validarConfirmacaoPagamento();
        String expectedMessage2 = "Success: You have changed payment method!";
        Assert.assertEquals(mensagemEsperada2, expectedMessage2);

        checkoutPage.finalizarCompra();

        CheckoutCheck validarCompra = new CheckoutCheck(navegador);
        String mensagemEsperada3 = validarCompra.validarCompra();
        String expectedMessage3 = "Your order has been placed!";
        Assert.assertEquals(mensagemEsperada3, expectedMessage3);

    }
    @Test
    public void realizarTentativaDeCompraDadosInvalidos(){

         AddProductToCartPage addProductToCartPage = new AddProductToCartPage(navegador);

        addProductToCartPage.acessarMac();
        addProductToCartPage.clicarNoCarrinhoDeCompra();
        addProductToCartPage.abrirCarrinhoComProdutos();
        addProductToCartPage.acessarTelaFinalizarCompra();

        CheckoutPage checkoutPage = new CheckoutPage(navegador);

        String firstName = "";
        String lastName = "";
        String company = "B2";
        String address = "Rua nova2";
        String city = "Belo Horizonte";
        String postCode = "133";

        checkoutPage.inserirNovoEndereco();
        checkoutPage.inserirPrimeiroNome(firstName);
        checkoutPage.inserirUltimoNome(lastName);
        checkoutPage.inserirEmpresa(company);
        checkoutPage.inserirEndereco(address);
        checkoutPage.inserirCidade(city);
        checkoutPage.inseirCodigoPostal(postCode);
        checkoutPage.selecionarPais();
        checkoutPage.selecionarRegiao();
        checkoutPage.confirmanovoEmail();

        CheckoutCheck dadodInvalidos = new CheckoutCheck(navegador);
        String mensagemEsperada = dadodInvalidos.validarDadoIvalidos();
        String expectedMessage ="First Name must be between 1 and 32 characters!";
        Assert.assertEquals(mensagemEsperada, expectedMessage);

    }

}
