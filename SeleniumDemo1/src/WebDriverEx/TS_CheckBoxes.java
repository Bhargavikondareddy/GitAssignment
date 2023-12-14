package WebDriverEx;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TS_CheckBoxes {
	private static List<WebElement> cb;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		
		driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/input[1]"));
		
//		for i in range(len(checkboxes));
//				checkboxes[i].click();
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
		Thread.sleep(2000);
		
		driver.close();
	}
}