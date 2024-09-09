package Swag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Swaglabs {
    ChromeDriver driver;
    @BeforeTest
    public void Url(){
        String ChromePath = System.getProperty("User.dir")+"\\resources\\chromedriver.exe";
        System.setProperty("Wedriver.chrome.driver",ChromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @Test(priority = 1)
    public void Login() throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void Add() throws InterruptedException {
        WebElement Backapps = driver.findElement(By.id("item_4_img_link"));
        Backapps.click();
        Thread.sleep(2000);
        WebElement AddCart = driver.findElement(By.id("add-to-cart"));
        AddCart.click();
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void Back(){
        WebElement BackToproduct = driver.findElement(By.id("back-to-products"));
        BackToproduct.click();
        WebElement title = driver.findElement(By.className("title"));
        Assert.assertEquals("Products",title.getText());
    }
    @Test(priority = 4)
    public void Shopping() throws InterruptedException {
        WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
        ShoppingCart.click();
        Thread.sleep(500);
        WebElement Title = driver.findElement(By.className("title"));
        Assert.assertEquals("Your Cart",Title.getText());
        Thread.sleep(500);
        WebElement Check = driver.findElement(By.id("checkout"));
        Check.click();
        Thread.sleep(2000);
        WebElement FirstName = driver.findElement(By.id("first-name"));
        FirstName.sendKeys("Mohamed");
        Thread.sleep(500);
        WebElement LastName = driver.findElement(By.id("last-name"));
        LastName.sendKeys("Shalaby");
        Thread.sleep(500);
        WebElement Postal = driver.findElement(By.id("postal-code"));
        Postal.sendKeys("31511");
        Thread.sleep(500);
        WebElement Continue = driver.findElement(By.id("continue"));
        Continue.click();
        Thread.sleep(500);
        WebElement Overview = driver.findElement(By.className("title"));
        Assert.assertEquals("Checkout: Overview",Overview.getText());
        Thread.sleep(500);
        WebElement Finish = driver.findElement(By.id("finish"));
        Finish.click();
        Thread.sleep(2000);
        WebElement FinishTxt = driver.findElement(By.className("complete-header"));
        Assert.assertEquals("Thank you for your order!",FinishTxt.getText());
        Back();
        Thread.sleep(1000);

        }

    @AfterTest
    public void Close(){
        driver.quit();
    }
}
