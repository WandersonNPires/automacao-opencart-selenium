package pages;

import org.openqa.selenium.WebDriver;

import bases.PageBase;

public class EditAccountPage extends PageBase {

    public EditAccountPage(WebDriver navegador){
        super(navegador);
    }


    public void acessarAplicacaoWeb(){
        String url = "http://localhost/opencart/index.php?route=account/login&language=en-gb";
        navegador.get(url);
    }



    
    
}
