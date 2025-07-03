import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class editInfoTest {
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

            System.out.println("✅ Dashboard page appeared. Login successful!");

            WebElement myInfoTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Info']")));
            myInfoTab.click();


//            wait.until(ExpectedConditions.urlContains("/pim"));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-label")));

            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")));
            dropdown.click();

//            WebElement marriedOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Other']/../following-sibling::div//div[contains(@class, 'oxd-select-text')]")));
//            marriedOption.click();
            Thread.sleep(5000);

            Select options = new Select(dropdown);
            options.selectByIndex(3);
//            options.selectByVisibleText("Other");
            Thread.sleep(10000);

//            boolean isDisplayed = driver.findElement(By.tagName("h6")).getText().contains("Dashboard");
//            if(isDisplayed){
//                System.out.println("----------------Test Successful-------------------");
//            }else{
//                System.out.println("-----------------Test failed-----------------");
//            }

            driver.quit();
        }
    }
