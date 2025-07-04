import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class alerts {
    public static void main(String[] args) throws InterruptedException{
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.manage().window().maximize();

        System.out.println("Window sucessfully maximized");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement alertButton = driver.findElement(By.id("alertBox"));
        System.out.println(alertButton.getText());
        alertButton.click();

        Alert alert = driver.switchTo().alert();

        System.out.println("-----------------------");
        System.out.println(alert.getText());
        System.out.println("-----------------------");

        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(4000);


        WebElement confirmAlert = driver.findElement(By.id("confirmBox"));
        confirmAlert.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();
        WebElement action = driver.findElement(By.id("output"));
        System.out.println(action.getText());
        Thread.sleep(2000);

        WebElement cancelAlert = driver.findElement(By.id("confirmBox"));
        cancelAlert.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        WebElement action1 = driver.findElement(By.id("output"));
        System.out.println(action1.getText());
        Thread.sleep(2000);

        WebElement promptButton = driver.findElement(By.id("promptBox"));
        promptButton.click();
        Alert alert3 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert3.sendKeys("Roshan");
        Thread.sleep(2000);
        alert3.accept();
        System.out.println(action1.getText());


        driver.quit();
    }


}

