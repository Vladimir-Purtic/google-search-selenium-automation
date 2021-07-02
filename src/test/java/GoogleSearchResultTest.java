import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearchResultTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void searchTestForBloxico() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("bloxico" + Keys.ENTER);
        // This wont work so i sent Keys.ENTER to search
        //driver.findElement(By.name("btnK")).click();

        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"rso\"]/div[@class=\"g\"]"));

        list.stream().filter(i -> i.getText().contains("https://bloxico.com")).forEach(i -> {
            System.out.println(i.getText());
            i.click();
        });

        driver.navigate().to("https://bloxico.com/#contact");
        driver.findElement(By.name("email")).sendKeys("vlada.purtic@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("QA Task1 for Bloxico");
        driver.findElement(By.name("message")).sendKeys("Hello guys i hope you are all doing well :)");

        // Dont wanna spam you guys :)
        //driver.findElement(By.name("submit")).click();

        // Just to see results before it closes :)
        Thread.sleep(9000);
    }
}
