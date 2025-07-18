package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.EditAccountInformationCheck;
import data.MassOfData;
import pages.EditAccountInformationPage;
import pages.LoginPage;
import pages.RegisterPage;

public class EditAccountInformationTest {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa();
    }

    @Test
    public void editarInformacaoConta() {
        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        LoginPage loginPage = new LoginPage(navegador);

        String emailAddress = MassOfData.EMAIL_VALIDO_4;
        String password = MassOfData.SENHA_VALIDA_4;
        String expectedMessage = "Success: Your account has been successfully updated.";

        loginPage.acessarAplicacaoWeb();
        loginPage.inserirEmailLogin(emailAddress);
        loginPage.inserirPassWordLogin(password);
        loginPage.logar();

        EditAccountInformationPage edit = new EditAccountInformationPage(navegador);

        edit.acessarTelaAlterarConta();
        edit.clicarParaMudarDadosConta();

        String novoNome = "WandersonP";
        String novoUltimoNome ="SilvaP";
        String novoEmail = "wandersonneivaP@gmail.com";
        edit.inserirNovosDados(novoNome);
        edit.inserirUltimoNome(novoUltimoNome);
        edit.inseriEmail(novoEmail);
        edit.cliarParaTrocarDados();

        EditAccountInformationCheck contaAlterada = new EditAccountInformationCheck(navegador);
        String mensagemEsperada = contaAlterada.mudarConta();
        Assert.assertEquals(mensagemEsperada, expectedMessage);



    }
}
