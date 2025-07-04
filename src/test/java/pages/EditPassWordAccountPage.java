package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bases.PageBase;

public class EditPassWordAccountPage extends PageBase {

    public EditPassWordAccountPage(WebDriver navegador) {
        super(navegador);
    }

    public void acessarTelaLogin() {
       acessarAplicaca();

    }

       public void acessarTelaMudarSenha() {
        String url = "http://localhost/opencart/index.php?route=account/password&language=en-gb&customer_token=5c0f699ce3d76f5a6bd45dd638";
        navegador.get(url);
    }


    public void clicarEmTrocar() {

        clicar(By.xpath("//a[contains(text(), 'Change your password')]"));
    }

    public void inserirNovaSenha(String SENHA_VALIDA_3){
         WebElement campoEmail = navegador.findElement(By.id("input-password"));
        campoEmail.clear();
        campoEmail.sendKeys(SENHA_VALIDA_3);
       
    }

    public void inserirConfirmacaoSenha(String SENHA_VALIDA_3){

        preencherCampo(By.id("input-confirm"), SENHA_VALIDA_3);
    }


    public void clicarParaTrocar(){

        clicar(By.xpath("//button[text()='Continue']"));
    }

 

}
