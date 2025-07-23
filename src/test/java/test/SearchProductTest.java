package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Checks.SearchProductCheck;
import data.MassOfData;
import pages.LoginPage;
import pages.SearchProductPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class SearchProductTest {

    WebDriver navegador;

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();

    }

    @BeforeMethod
    public void setup() {
         navegador = DriverFactory.createChrome();
        navegador.manage().window().setSize(new Dimension(1920, 1080));

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

        PastasDocuments.criarPastaSeNaoExistir("SearchProductDocuments");
        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "buscarTodosProdutosNaCategotiaDesktops";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

    @Test
    public void acessarLaptopseNotebooks() {

        SearchProductPage serachProtucPage = new SearchProductPage(navegador);

        serachProtucPage.buscarDesktop();
        serachProtucPage.acessarLaptopseNotebooks();

        SearchProductCheck LaptopsEnotebooks = new SearchProductCheck(navegador);
        String mensagemEsperada = LaptopsEnotebooks.validarLaptops();
        Assert.assertTrue(mensagemEsperada.contains("Shop Laptop feature only the best laptop deals on the market."));

         PastasDocuments.criarPastaSeNaoExistir("SearchProductDocuments");
        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "acessarLaptopseNotebooks";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

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

         PastasDocuments.criarPastaSeNaoExistir("SearchProductDocuments");
        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "acessarMonitores";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

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

         PastasDocuments.criarPastaSeNaoExistir("SearchProductDocuments");
        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "acessarTablets";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

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

         PastasDocuments.criarPastaSeNaoExistir("SearchProductDocuments");
        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "acessarCelulares";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();
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

         PastasDocuments.criarPastaSeNaoExistir("SearchProductDocuments");
        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "acessarCameras";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

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

         PastasDocuments.criarPastaSeNaoExistir("SearchProductDocuments");
        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "acessarMp3";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

    @Test
    public void acessarprodutoIndisponivel() {

        SearchProductPage searchProductPage = new SearchProductPage(navegador);

        searchProductPage.acessarProdutoInexistente();

        SearchProductCheck macs = new SearchProductCheck(navegador);
        String mensagemEsperada = macs.validarProdutoInexistente();
        Assert.assertTrue(mensagemEsperada.contains("There are no products to list in this category."));

         PastasDocuments.criarPastaSeNaoExistir("SearchProductDocuments");
        String nomePasta = "SearchProductDocuments";
        String nomeTeste = "acessarprodutoIndisponivel";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }

}
