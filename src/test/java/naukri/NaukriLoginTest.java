package naukri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NaukriLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void naukriLogin() throws InterruptedException {
String username = System.getProperty("naukriUser");
    String password = System.getProperty("naukriPass");

        driver.get("https://www.naukri.com");

        Thread.sleep(3000);

        driver.findElement(By.id("login_Layer")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
                .sendKeys(username);

        driver.findElement(By.xpath("//input[@placeholder='Enter your password']"))
                .sendKeys(password);

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        Thread.sleep(5000);

        driver.findElement(By.linkText("View profile")).click();

                Thread.sleep(5000);

                driver.findElement(By.xpath("//em[text()='editOneTheme']")).click();        
                
                Thread.sleep(5000);
driver.findElement(By.xpath("//button[text()='Save']")).click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}