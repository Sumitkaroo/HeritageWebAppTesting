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


        //tag attribute tag[attribute='value']
        driver.findElement(By.cssSelector("[placeholder='Mobile Number']")).sendKeys("8800012365");

        driver.findElement(By.linkText("Contact")).click();
        //tag id tag#id
        driver.findElement(By.cssSelector("input#input_comp-k5xo3y0u")).sendKeys("abc@gmail.com");

        //Absolute xpath
        driver.findElement(By.xpath("/html/body/div/div/div[3]/div/main/div/div/div/div[2]/div/div/div/section/div[2]/div/div[5]/div/div/form/div/div/div[3]/div/input")).sendKeys("808802564");

        //Relative xpath
        driver.findElement(By.xpath("//*[@id=\"textarea_comp-k5xo3y15\"]")).sendKeys("Test Demo");

        //xpath with multiple attribute
        driver.findElement(By.xpath("//input[@name='name' and @placeholder='Name'] ")).sendKeys("Raj");



        driver.quit();

    }
}