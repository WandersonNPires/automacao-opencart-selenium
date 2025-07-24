package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createChrome() {
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

            // Comentado para rodar sempre em headless
            // options.addArguments("--start-maximized");
            // return new ChromeDriver(options);

            // Headless ativado mesmo no Windows
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            return new ChromeDriver(options);
        } else {
            // Configuração para ambiente de CI (Linux + Selenium Grid)
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            try {
                return new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("URL do Selenium Grid inválida", e);
            }
        }
    }

    public static WebDriver createFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

            // Comentado para rodar sempre em headless
            // options.addArguments("--start-maximized");
            // return new FirefoxDriver(options);

            // Headless ativado mesmo no Windows
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            return new FirefoxDriver(options);
        } else {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            try {
                return new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("URL do Selenium Grid inválida", e);
            }
        }
    }
}
