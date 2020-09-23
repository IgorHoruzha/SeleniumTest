

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Email {
    private static ChromeDriver driver;

    @BeforeEach
    public void beforeEachTest() {
        final String MY_MAIL = "sdfsdfasdf98@yahoo.com";
        final String MY_PASSWORD = "SDFASDFASDF3Q4212A3";

        System.setProperty("webdriver.chrome.driver", "D:\\MyVisualStudioPrijects\\Old\\SteamProject3 - Copy\\WpfApp1\\bin\\x64\\Debug\\netcoreapp3.1\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("force-device-scale-factor=0.75");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://login.yahoo.com/?.src=ym&.lang=ru-RU&.intl=ru&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%3Fpspid%3D2023538075%26activity%3Dybar-mail");


        sendKeysToElement(By.id("login-username"), MY_MAIL);
        clickOnElement(By.id("login-signin"));
        sendKeysToElement(By.id("login-passwd"), MY_PASSWORD);
        clickOnElement(By.id("login-signin"));

        clickOnElement(By.cssSelector("a[data-test-id=\"compose-button\"]"));

        sendKeysToElement(By.id("message-to-field"), MY_MAIL);
        final  String THEME= "Hello word theme.";
        sendKeysToElement(By.cssSelector("input[data-test-id=\"compose-subject\"]"),THEME);
        final  String MESSAGE_BODY= "Hello word from message body.";
        sendKeysToElement(By.cssSelector("div[data-test-id=\"rte\"]"),MESSAGE_BODY);
    }

    private void clickOnElement(By selector) {
        for (int i = 0; i < 10; i++) {
            try {
                WebElement logInBtn = driver.findElement(selector);
                logInBtn.click();
                return;
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        Assertions.fail();
    }

    private void sendKeysToElement(By selector, String text) {
        for (int i = 0; i < 10; i++) {
            try {
                WebElement messageTheme = driver.findElement(selector);
                messageTheme.sendKeys(text);
                return;
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

        Assertions.fail();
    }

    //    @AfterEach
//    public void quitDriver() {
//        driver.quit();
//    }
    @Test
    public void testSendMail() {


    }
}