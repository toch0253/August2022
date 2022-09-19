package august2022.August2022;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Registration {
	
	
		
		WebDriver driver;
		
	public void registrationDemo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a")).click();
		String createaccountheader = driver.findElement(By.xpath("//*[@id='mainContent']/div[3]/h1")).getText();
		
		assertEquals(createaccountheader, "Create an account");
		/*if (createaccountheader.equals("Create an account")) {
			
		
			System.out.println("Registration page displayed properly");
			System.out.println(" Header message is "+createaccountheader);
		}
		else
			System.out.println("Failed to display registration page");*/

		// ADDED/EDITED CODE BELOW
		SeleniumDemo sd = new SeleniumDemo();
		sd.initProperties();
		
		driver.findElement(By.id("firstname")).sendKeys(sd.getFirstname());
		driver.findElement(By.id("lastname")).sendKeys(sd.getLastname());
		driver.findElement(By.id("Email")).sendKeys(sd.getEmail());
		driver.findElement(By.id("password")).sendKeys(sd.getPassword());
		// driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT")).click();
		
		driver.findElement(By.id("gh-la")).click();
		driver.findElement(By.xpath("//*[@id=\"gh-cat\"]/option[3]")).click();
		
		
	}
	
	
	
	
	

}
