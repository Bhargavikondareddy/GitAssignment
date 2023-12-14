package WebDriverEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TS_LaunchGoogle {
	public static void main(String[] args) throws InterruptedException {
		//open a browser
		WebDriver driver = new EdgeDriver();
		
		//Enter URL
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		//search text
		driver.findElement(By.name("q")).sendKeys("Selenium tutorial");
		
		Thread.sleep(2000);
		
		//click on search button
		driver.findElement(By.name("btnK")).click();
		
		//pause
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		if(title.equals("Selenium tutorial - Google Search")) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
		
		driver.close();
	}

}
