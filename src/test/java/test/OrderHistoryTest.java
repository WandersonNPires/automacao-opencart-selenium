package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.OrderHistoryCheck;
import data.MassOfData;
import pages.LoginPage;
import pages.OrderHistoryPage;
import utils.DriverFactory;
import utils.PastasDocuments;
import utils.Report;

public class OrderHistoryTest {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }
     @Test
    public void acessarHistorico(){
        String emailAddress = MassOfData.EMAIL_VALIDO;
        String password = MassOfData.SENHA_VALIDA;
        String expextedMessege = "Orders";

       WebDriver navegador = DriverFactory.createChrome();
        //navegador.manage().window().setSize(new Dimension(1920, 1080));
        navegador.manage().window().maximize();
        
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();


        OrderHistoryPage  orderHistoryPage = new OrderHistoryPage(navegador);

        orderHistoryPage.acessarAplicacaoWeb();
        orderHistoryPage.acessarHistoricoPedidos();

       OrderHistoryCheck historico = new OrderHistoryCheck(navegador);
       String  mensagemEsperda  = historico.TelaHistorico();
       Assert.assertEquals(mensagemEsperda, expextedMessege);

        PastasDocuments.criarPastaSeNaoExistir("OrderHistoryDocuments");
        String nomePasta = "OrderHistoryDocuments";
        String nomeTeste = "acessarHistorico";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }
    
}
