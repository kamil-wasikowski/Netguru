import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Login {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kamil\\Desktop\\Netguru\\src\\main\\java\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://trello.com/login");
        driver.manage().window().setSize(new Dimension(1350, 800));
        driver.findElement(By.id("user")).sendKeys("kamil.wasikowski.91+1@gmail.com");
        driver.findElement(By.id("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("login-submit")).click();
        driver.findElement(By.id("password")).sendKeys("Netguru_Tests");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("login-submit")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actualUrl="https://trello.com/kamilwasikowski911/boards";
        String expectedUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}