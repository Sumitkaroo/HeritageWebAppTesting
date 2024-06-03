package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.heritageenterprises.in/");
        driver.manage().window().maximize();
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for(WebElement e:links){
            String getlink=e.getAttribute("href");
            System.out.println(getlink);
        }

        List<WebElement> images=driver.findElements(By.tagName("img"));
        System.out.println("Total Images present in Home Page are: "+images.size());

        driver.findElement(By.partialLinkText("Sell")).click();

        driver.quit();

    }
}