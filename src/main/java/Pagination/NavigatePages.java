package Pagination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class NavigatePages {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Intellij idea\\chromedriver-win641\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> links=driver.findElements(By.xpath("//ul[@class=\"pagination\"]//li"));
        int total_pages=links.size();
        for(int i=1;i<=total_pages;i++){
            driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li["+i+"]//a")).click();

            for(int r=1;r<6;r++){
                    for(int c=1;c<4;c++){
                        String id=driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//td["+c+"]")).getText();
                        System.out.println(id);
                    }
                    driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//input")).click();
                }
            }

        }

}
