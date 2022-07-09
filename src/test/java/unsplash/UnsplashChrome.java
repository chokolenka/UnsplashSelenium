package unsplash;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnsplashChrome {
    public static WebDriver driver = null;
    public final String baseUrl = "https://unsplash.com/"; // сайт, с которым будем работать


    @Test
    @Order(1)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe"); // указали путь к драйверу
        driver = new ChromeDriver();// Создаем объект
        driver.get(baseUrl);//Переходим по заданному адресу
        driver.manage().window().maximize(); //расширение окна на всю страницу
    }

    @Test    //Перейти по ссылке "Wallpapers".
    @Order(2)
    public void getWallpapers() {
        driver.get(baseUrl + "wallpapers");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Hd wallpapers".toUpperCase()));
    }

    @Test    //Регистрация Join
    @Order(3)
    public void SignUp() {
        driver.get(baseUrl + "join");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Join Unsplash".toUpperCase()));
    }

    @Test    //Ввод всех необходимых полей для регистрации и нажатие на кнопку "Join"
    @Order(4)
    public void JoinUnsplash() {
        //*[@id="user_first_name"]
        //*[@id="user_last_name"]
        //*[@id="user_email"]
        //*[@id="user_username"]
        //*[@id="user_password"]
        //*[@id="new_user"]
        //*[@id="new_user"]/div[5]/a

        String text = "Helen";
        WebElement firstname = driver.findElement(By.id("user_first_name"));
        firstname.sendKeys(text);// вводим имя

        String text1 = "Timofeyeva";
        WebElement lastname = driver.findElement(By.id("user_last_name"));
        lastname.sendKeys(text1);// вводим фамилию

        WebElement email = driver.findElement(By.id("user_email"));
        email.sendKeys(generate()); // набираем несуществующую почту

        WebElement username = driver.findElement(By.id("user_username"));
        username.sendKeys(generate1()); // вводим имя пользователя

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("abcde12345"); // вводим пароль

        WebElement button = driver.findElement(By.xpath("//*[@id='new_user']/div[5]/a"));
        button.click(); // кликаем на кнопку "Join"

    }
    @Test
    @Order(5)
    //Выход из аккаунта
    public void getMenu(){
        driver.get(baseUrl+"logout"); //Переход на страницу выхода
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Unsplash".toUpperCase()));

        WebElement menubutton = driver.findElement(By.xpath("//*[@id='popover-avatar-loggedin-menu-desktop']/button/div"));
        menubutton.click(); //кликнуть по ссылке menubutton // нажатие на кнопку меню

        WebElement button = driver.findElement(By.xpath("//*[@id='popover-avatar-loggedin-menu-desktop']/div/div/div/div[2]/ul[2]"));
        button.click(); //кликнуть по ссылке logout + "username"  // нажатие на кнопку "username"  и выход на главную страницу

    }

    @Test
    @Order(6)
    //Задаем рандомно почту
    public String generate() {
        //Генерируем случайным образом буквы
        String s = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int n = random.nextInt(122 - 97 + 1) + 97;
            char c = (char) n;
            s += c;
        }

        int number = random.nextInt(1000) + 1000;
        s += String.valueOf(number);
        s += "@mail.ru";
        return s;

    }
    @Test
    @Order(7)
    //Задаем рандомно почту
    public String generate1() {
        //Генерируем случайным образом буквы
        String s = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int n = random.nextInt(122 - 97 + 1) + 97;
            char c = (char) n;
            s += c;
        }

        return s;
    }
}



