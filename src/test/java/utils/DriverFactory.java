package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static ChromeDriver createChrome() {
        ChromeOptions options = new ChromeOptions();

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            // Pode deixar janela maximizada localmente se quiser
            options.addArguments("--start-maximized");
        } else {
            // No CI/Linux rodar em headless e com flags para estabilidade
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        return new ChromeDriver(options);
    }
}
