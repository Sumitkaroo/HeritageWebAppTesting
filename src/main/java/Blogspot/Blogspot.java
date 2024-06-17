package Blogspot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.model.WindowID;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Blogspot {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
        driver.findElement(By.className("wikipedia-search-button")).click();
        Thread.sleep(2000);
        //to search from that specific session
        WebElement session=driver.findElement(By.className("wikipedia-search-main-container"));
        List<WebElement> link=session.findElements(By.tagName("a"));
        System.out.println(link.size());
        int n= link.size();

        //for loop to click on each link
        for(int i=0;i< link.size();i++){
            WebElement links = link.get(i);
            System.out.println(links.getAttribute("href"));
            links.click();

        }
        //get all the open windows id
        Set<String> windowsID=driver.getWindowHandles();
        for(String id:windowsID){
            System.out.println(id);
          String title= driver.switchTo().window(id).getTitle();
            System.out.println(title);
            if(title.equals("Automation Testing Practice") || title.equals("Selenium disulfide - Wikipedia") || title.equals("Selenium (software) - Wikipedia") || title.equals("Selenium in biology - Wikipedia")) {
                driver.close();
            }
        }

    }
}
