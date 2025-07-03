import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class rasioButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='yesRadio']")));

        driver.findElement(By.cssSelector("label[for=\"impressiveRadio\"]")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
