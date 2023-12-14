package WebDriverEx;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS_alert {
	public static void main(String[] args) throws InterruptedException {
		//open a browser
		WebDriver driver = new EdgeDriver();
		
		//Enter URL
		driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//search text
		driver.findElement(By.xpath("//*[@id=\"post-body-4292417847084983089\"]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String msg = driver.findElement(By.id("demo")).getText();
		System.out.println(msg);
		driver.close();
	}
}
