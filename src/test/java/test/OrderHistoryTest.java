package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.OrderHistoryCheck;
import data.MassOfData;
import pages.LoginPage;
import pages.OrderHistoryPage;
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

        ChromeDriver navegador = new ChromeDriver();
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

        
        String nomePasta = "RegisterTestDocuments";
        String nomeTeste = "acessarHistorico";

        Report.tirarScreenshot(navegador, nomePasta, nomeTeste);
        Report.gerarRelatorioPorTeste(nomePasta, nomeTeste);

        navegador.quit();

    }
    
}
