package HandlingAlertsinWebPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomePage {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
        Alert w=driver.switchTo().alert();
        Thread.sleep(1000);
        w.accept();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        Thread.sleep(1000);
        w.dismiss();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        Thread.sleep(1000);
        w.sendKeys("Hello");
        Thread.sleep(1000);
        w.accept();
        driver.close();
    }

}
