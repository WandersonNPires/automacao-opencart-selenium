package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createChrome() {
        ChromeOptions options = new ChromeOptions();

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            options.addArguments("--start-maximized");
            return new ChromeDriver(options);
        } else {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            try {
                // Usa o serviço Selenium do container no CI
                return new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("URL do Selenium Grid está inválida", e);
            }
        }
    }
}
