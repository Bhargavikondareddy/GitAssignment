package pages;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class YatraPage extends BaseTest {

    // PageFactory
    @FindBy(linkText = ("Offers"))
    WebElement offers;

    @FindBy(xpath = ("//p[text()='Fly & Save! Get Amazing Deals on Domestic Flight Bookings.']"))
    WebElement domestic;

    @FindBy(xpath = ("//h2[text()='Great Offers & Amazing Deals']"))
    WebElement banner;

    @FindBy(linkText = ("Holidays"))
    WebElement Holidays;

    @FindBy(xpath = ("//span[text()='Bali Air Inclusive Packages ']/following::span[text()='View Details'][1]"))
    WebElement baliViewDetailsButton;

    @FindBy(xpath = ("//span[text()='Dubai Land Only ']/following::span[text()='View Details'][1]"))
    WebElement dubaiViewDetailsButton;

    @FindBy(xpath = ("//span[text()='Maldives Packages ']/following::span[text()='View Details'][1]"))
    WebElement maldivesViewDetialsButton;

    @FindBy(xpath = ("//span[text()='Singapore Land Only ']/following::span[text()='View Details'][1]"))
    WebElement singaporeViewDetialsButton;

    @FindBy(xpath = ("//span[text()='Mauritius Holiday Packages ']/following::span[text()='View Details'][1]\n"))
    WebElement mauritisViewDetialsButton;

    @FindBy(xpath = ("//span[@id='packDestination']/preceding-sibling::span/span/i/following-sibling::span"))
    WebElement packagePrice;

    @FindBy(xpath = ("//div[@class='float-L pkg-detail col-white']/h1/span"))
    WebElement packageName;




    // Initialize page objects(factory)
    //constructor
    public YatraPage() {
        PageFactory.initElements(driver, this);
    }  //initialize driver->switch to BaseTest Class, this-> current class objects(all above objects)

    // Actions Methods

    public void clickOffersLink() {
        Actions action = new Actions(driver);
        action.moveToElement(offers).click().perform();
    }

    public boolean BannerPage(){
        //Thread.sleep(10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(banner));
        return banner != null && banner.isDisplayed();
    }

    public boolean domestic() {
        domestic.getText();
        return domestic.isDisplayed();
        //isDisplayed returns true or false if the title is present

    } //return statement returns true if it is available otherwise it returns false

    public void captureScreenshot(String screenshotPath) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotPath));
    }

    public void clickHolidaysLink() {

        Actions action = new Actions(driver);
        action.moveToElement(Holidays).click().perform();
        //Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Holidays)).click();
    }

    public void baliViewDetails() {

        Actions action = new Actions(driver);
        action.moveToElement(baliViewDetailsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void baliPackagePrice() {
        //Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                //Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOf(packageName));

                String baliPackageName = packageName.getText();
                String baliPrice = packagePrice.getText();
                System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
                driver.close();
                driver.switchTo().window(mainWindowHandle);
                //Thread.sleep(3000);
                break;
            }
        }

    }

    public void dubaiViewDetials() {
        Actions action = new Actions(driver);
        action.moveToElement(dubaiViewDetailsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void dubaiPackagePrice(){
        //Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                //Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOf(packageName));
                String baliPackageName = packageName.getText();
                String baliPrice = packagePrice.getText();
                System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
                driver.close();
                driver.switchTo().window(mainWindowHandle);
                //Thread.sleep(3000);
                break;
            }
        }

    }

    public void maldivesViewDetails(){

        Actions action = new Actions(driver);
        action.moveToElement(maldivesViewDetialsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void maldivesPackagePrice(){
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                //Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOf(packageName));

                String baliPackageName = packageName.getText();
                String baliPrice = packagePrice.getText();
                System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
                driver.close();
                driver.switchTo().window(mainWindowHandle);
                //Thread.sleep(3000);
                break;
            }
        }

    }

    public void singaporeViewDetails(){

        Actions action = new Actions(driver);
        action.moveToElement(singaporeViewDetialsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void singaporePackagePrice(){
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                //Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOf(packageName));

                String baliPackageName = packageName.getText();
                String baliPrice = packagePrice.getText();
                System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
                driver.close();
                driver.switchTo().window(mainWindowHandle);
                //Thread.sleep(3000);
                break;
            }
        }

    }

    public void mauritisViewDetails(){

        Actions action = new Actions(driver);
        action.moveToElement(mauritisViewDetialsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void mauritisPackagePrice(){
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                //Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOf(packageName));

                String baliPackageName = packageName.getText();
                String baliPrice = packagePrice.getText();
                System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
                driver.close();
                driver.switchTo().window(mainWindowHandle);
                //Thread.sleep(3000);
                break;
            }
        }

    }



}




