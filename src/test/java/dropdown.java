import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class dropdown {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        driver.manage().window().maximize();

        WebElement dropDown = driver.findElement(By.id("course"));
        Select options = new Select(dropDown);

        options.selectByIndex(1);
        Thread.sleep(3000);
        options.selectByValue("python");
        Thread.sleep(3000);
        options.selectByVisibleText("Dot Net");
        Thread.sleep(3000);
        driver.quit();
    }


}
