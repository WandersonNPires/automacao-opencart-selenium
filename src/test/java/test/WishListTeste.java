package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import Checks.WiishListCheck;
import data.MassOfData;
import pages.LoginPage;
import pages.WishListPage;
import utils.Report;

public class WishListTeste {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }

    @Test
    public void acesarTelaDeDesejo() {

        String emailAddress = MassOfData.EMAIL_VALIDO;
        String password = MassOfData.SENHA_VALIDA;
        String expextedMessege = "My Wishlist";

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

       WishListPage wishListPage = new WishListPage(navegador);

       wishListPage.acessarAplicacaoWeb();
       wishListPage.acessarListaDesejo();

       WiishListCheck listaDesejo = new WiishListCheck(navegador);
       String mensagemEsperda = listaDesejo.telaDesejoAcessada();
       Assert.assertEquals(mensagemEsperda, expextedMessege);

       String nomePasta ="WishTestDocuments";
       String nomeTeste ="AcessarTelaDeDesejo";

       Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
       Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

       navegador.quit();

    }

}
