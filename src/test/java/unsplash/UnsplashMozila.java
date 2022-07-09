package unsplash;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnsplashMozila extends UnsplashChrome {


    @Test
    @Order(1)
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver-v0.31.0-win64/geckodriver.exe"); // указали путь к драйверу
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver(options);
        driver.get(baseUrl);
        driver.manage().window().maximize();

    }

}