package Flipk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DropDownTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        Thread.sleep(4000);
       driver.findElement(By.xpath("//div[@aria-label=\"Home & Furniture\"]")).click();

        driver.findElement(By.xpath("//a[normalize-space()='Kitchen & Dining']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Cookware']")).click();


    }
}
