import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".orangehrm-login-slot")));

        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();

        wait.until(ExpectedConditions.urlContains("/dashboard"));

        Thread.sleep(5000);

        boolean isDisplayed = driver.findElement(By.tagName("h6")).getText().contains("Dashboard");
        if(isDisplayed){
            System.out.println("----------------Test Successful-------------------");
        }else{
            System.out.println("-----------------Test failed-----------------");
        }

//        System.out.println("✅ Dashboard page appeared. Login successful!");
        driver.quit();
    }
}
