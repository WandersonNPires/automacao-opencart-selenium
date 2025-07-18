package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Checks.SearchProductCheck;
import data.MassOfData;
import pages.LoginPage;
import pages.SearchProductPage;
import utils.Report;

public class SearchProductTest {

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
    public void buscarTodosProdutosNaCategotiaDesktops() {

        String expectedMessage = "Desktops";

        SearchProductPage serachProtucPage = new SearchProductPage(navegador);

        serachProtucPage.buscarDesktop();

        SearchProductCheck monirtores = new SearchProductCheck(navegador);
        String mensagemEsperada = monirtores.validarDekstops();
        Assert.assertEquals(mensagemEsperada, expectedMessage);

        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "buscarTodosProdutosNaCategotiaDesktops";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

    }

    @Test
    public void acessarLaptopseNotebooks() {

        SearchProductPage serachProtucPage = new SearchProductPage(navegador);

        serachProtucPage.buscarDesktop();
        serachProtucPage.acessarLaptopseNotebooks();

        SearchProductCheck LaptopsEnotebooks = new SearchProductCheck(navegador);
        String mensagemEsperada = LaptopsEnotebooks.validarLaptops();
        Assert.assertTrue(mensagemEsperada.contains("Shop Laptop feature only the best laptop deals on the market."));

        
    }

    @Test
    public void acessarMonitores() {
        SearchProductPage serachProtucPage = new SearchProductPage(navegador);

        String expectedMessage = "Monitors";

        serachProtucPage.buscarDesktop();
        serachProtucPage.acessarComponentesEmonitores();

        SearchProductCheck monitores = new SearchProductCheck(navegador);
        String mensagemEsperada = monitores.validarMonitors();
        Assert.assertEquals(mensagemEsperada, expectedMessage);
    }

    @Test
    public void acessarTablets() {
        SearchProductPage serachProtucPage = new SearchProductPage(navegador);

        String expectedMessage = "Tablets";
        serachProtucPage.buscarDesktop();
        serachProtucPage.acessarTablets();

        SearchProductCheck tablet = new SearchProductCheck(navegador);
        String mensagemEsperada = tablet.validarTablets();
        Assert.assertEquals(mensagemEsperada, expectedMessage);

    }

    @Test
    public void acessarCelulares() {
        SearchProductPage serachProtucPage = new SearchProductPage(navegador);
        String expectedMessage = "Phones & PDAs";
        serachProtucPage.buscarDesktop();
        serachProtucPage.acessarCelulares();

        SearchProductCheck celulares = new SearchProductCheck(navegador);
        String mensagemEsperada = celulares.validarCelulares();
        Assert.assertEquals(mensagemEsperada, expectedMessage);
    }

    @Test
    public void acessarCameras() {
        SearchProductPage serachProtucPage = new SearchProductPage(navegador);
        String expectedMessage = "Cameras";
        serachProtucPage.buscarDesktop();
        serachProtucPage.acessarCameras();

        SearchProductCheck cameras = new SearchProductCheck(navegador);
        String mensagemEsperada = cameras.validarCameras();
        Assert.assertEquals(mensagemEsperada, expectedMessage);

    }

    @Test
    public void acessarMp3() {
        SearchProductPage serachProtucPage = new SearchProductPage(navegador);
        String expectedMessage = "MP3 Players";
        serachProtucPage.buscarDesktop();
        serachProtucPage.acessarMp3();

        SearchProductCheck mp3 = new SearchProductCheck(navegador);
        String mensagemEsperada = mp3.validarMp3();
        Assert.assertEquals(mensagemEsperada, expectedMessage);

    }

    @Test
    public void acessarprodutoIndisponivel() {

        SearchProductPage searchProductPage = new SearchProductPage(navegador);

        searchProductPage.acessarProdutoInexistente();

        SearchProductCheck macs = new SearchProductCheck(navegador);
        String mensagemEsperada = macs.validarProdutoInexistente();
        Assert.assertTrue(mensagemEsperada.contains("There are no products to list in this category."));

    }

}
