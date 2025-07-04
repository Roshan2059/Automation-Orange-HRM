import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class checkbox {
    public static void main(String[] args) throws InterruptedException{
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h1[normalize-space()='Check Box'])[1]")));
        driver.findElement(By.className("rct-option-expand-all")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("label[for=\"tree-node-react\"] span[class=\"rct-title\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("label[for=\"tree-node-commands\"] span[class=\"rct-title\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("label[for=\"tree-node-general\"] span[class=\"rct-title\"]")).click();
        Thread.sleep(5000);


        driver.quit();

    }
}
