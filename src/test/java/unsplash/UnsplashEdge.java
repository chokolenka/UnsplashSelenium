package unsplash;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.edge.EdgeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnsplashEdge extends UnsplashChrome {

    @Test
    @Order(1)
    public void openBrowser() {
        System.setProperty("webdriver.edge.driver", "C:/Drivers/edgedriver_win64/msedgedriver.exe"); // указали путь к драйверу
        driver = new EdgeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

}
