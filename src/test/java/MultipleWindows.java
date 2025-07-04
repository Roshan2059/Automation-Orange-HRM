import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class MultipleWindows {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();

        System.out.println("Window successfully maximized");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent handle is" + parentHandle);
//        WebElement newWinButton = driver.findElement(By.id("newWindowBtn"));
//        newWinButton.click();
//
//        Set<String> handles = driver.getWindowHandles();
//        for (String handle:handles){
//            System.out.println(handle);
//            Thread.sleep(2000);
//            if (!handle.equals(parentHandle)){
//                driver.switchTo().window(handle);
//                Thread.sleep(2000);
//                driver.findElement(By.id("firstName")).sendKeys("Roshan");
//                driver.findElement(By.id("lastName")).sendKeys("Panta");
//                driver.close();
//                System.out.println("I am indide if");
//            }
//            System.out.println("I am inside for loop but outside if");
//        }
//        System.out.println("ABC");
//
        WebElement newTabButton = driver.findElement(By.id("newTabBtn"));
        newTabButton.click();

        Set<String> handles1 = driver.getWindowHandles();
        for (String handle:handles1){
            System.out.println(handle);
            Thread.sleep(2000);
            if (!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                driver.findElement(By.id("alertBox")).click();
                Alert alert = driver.switchTo().alert();
                alert.dismiss();
                driver.close();
                System.out.println("I am indide if");
            }
            System.out.println("I am inside for loop but outside if");
        }
        System.out.println("ABC");

        driver.switchTo().window(parentHandle);
        Thread.sleep(5000);
        driver.findElement(By.id("name")).sendKeys("Roshan2");

        Thread.sleep(5000);
        driver.quit();
    }

}

