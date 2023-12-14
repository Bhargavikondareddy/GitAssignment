package WebDriverEx;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS_ExplicitWait {
		public static void main(String[] args) throws InterruptedException {
		//open a browser
		WebDriver driver = new EdgeDriver();
		
		//Enter URL
		driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
		
		driver.manage().window().maximize();
		
		//search text
		driver.findElement(By.name("fname")).sendKeys("Bhargavi");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement txt_lname = driver.findElement(By.name("lname"));
		wait.until(ExpectedConditions.elementToBeClickable(txt_lname)).sendKeys("reddy");
		//wait.until(ExpectedConditions.elementToBeClickable(txt_lname));
		//txt_lname.sendKeys("Reddy");
		driver.close();
	}
}
