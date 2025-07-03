package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Checks.EditPassWordCheck;
import data.MassOfData;
import pages.EditPassWordAccountPage;
import pages.LoginPage;

public class EditPassWordAccountTeste {

    @BeforeClass
    public void prepararBanco() {
        MassOfData.prepararMassa(); 
    }

    @Test
    public void editarConta() throws InterruptedException {
        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

       
            LoginPage loginPage = new LoginPage(navegador);

            String emailAddress = MassOfData.EMAIL_VALIDO_4;
            String password = MassOfData.SENHA_VALIDA_4;
            String expectedMessage = "Success: Your password has been successfully updated.";

            loginPage.acessarAplicacaoWeb();
            loginPage.inserirEmailLogin(emailAddress);
            loginPage.inserirPassWordLogin(password);
            loginPage.logar();

            EditPassWordAccountPage editAccountPage = new EditPassWordAccountPage(navegador);

            editAccountPage.acessarTelaMudarSenha();
            editAccountPage.clicarEmTrocar();
            String novaSenha = "senhanova";
            editAccountPage.inserirNovaSenha(novaSenha);
            editAccountPage.inserirConfirmacaoSenha(novaSenha);
            editAccountPage.clicarParaTrocar();

            EditPassWordCheck trocaFeita = new EditPassWordCheck(navegador);
            String mensagemEsperada = trocaFeita.mudarSenhaSucesso();
            Assert.assertEquals(mensagemEsperada, expectedMessage);



        } 
        }


