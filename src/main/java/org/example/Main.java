package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().browserVersion("125.0.6422.142").setup();

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.heritageenterprises.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

        driver.findElement(By.className("_YMhZp")).click();

        //xpath using descendant and ancestor
        //descendant
        driver.findElement(By.xpath("//div[@data-mesh-id=\"comp-k8vx9n7oinlineContent-gridContainer\"]/descendant::span[@class=\"l7_2fn wixui-button__label\"][4]")).click();

        //Navigating to Homepage
        driver.findElement(By.className("_YMhZp")).click();


        //Ancestor
        //driver.findElement(By.xpath("//span[@class=\"l7_2fn wixui-button__label\"]/ancestor::section")).click();

        //get methods
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());


        //conditional method
        WebElement info=driver.findElement(By.xpath("//span[@style=\"text-decoration:underline;\"]"));
        System.out.println(info.isDisplayed());

        driver.findElement(By.xpath("//*[@id=\"comp-k8vx9nll\"]/a/span")).click();
        boolean b=driver.findElement(By.xpath("//*[@id=\"comp-k8y1dfb8\"]/button/div/span[1]")).isEnabled();
        System.out.println(b);

        //Example of Ancestor
        driver.findElement(By.xpath("//img[@alt='LinkedIn']/ancestor::a")).click();
        Set<String> windows=driver.getWindowHandles();
        for(String e:windows){
            System.out.println(e);
        }
        //System.out.println("Windows ids are:"+windows);

        //Browser method
        //driver.close();
        driver.quit();



    }
}