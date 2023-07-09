import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailinput = driver.findElement(By.cssSelector("[type='email']"));
        emailinput.click();
        emailinput.clear();
        emailinput.sendKeys( "demo@class");

        WebElement passwordinput = driver.findElement(By.cssSelector("[type='password']"));
        passwordinput.click();
        passwordinput.clear();
        passwordinput.sendKeys( "te$t$tudent");

        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();

        Assert.assertEquals(driver.getCurrentUrl(),url);
        Assert.assertTrue(submitLogin.isDisplayed());

        driver.quit();
    }
}
