package allureReport;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class allureDemo_Report {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		
		WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setScriptTimeout(Duration.ofSeconds(30));
        chromeOptions.setPageLoadTimeout(Duration.ofMillis(30000));
        chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(20));
        chromeOptions.addArguments("--remote-allow-origins=*");    
        driver =new ChromeDriver(chromeOptions);
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test(priority=1,description="Display the website logo")
	@Description("Test desription: Display valid website logo")
	@Epic("Regression Testing")
	@Story("Validate website logo")
	@Feature("Website Logo tests")
	public void logodisplay() {
		
		
		boolean dislogo=driver.findElement(By.xpath("//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]")) != null;
		Assert.assertEquals(dislogo,true);
		
		}
	@Test(priority=2,description="Valid login scenario with valid username and password")
	public void login() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		WebElement username=driver.findElement(By.xpath("//input[@id='Email']"));
		username.sendKeys("anu312537@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("abc12345");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
			}
	@Test(priority=3)
	public void endprogram() {
		driver.quit();
	}

}
