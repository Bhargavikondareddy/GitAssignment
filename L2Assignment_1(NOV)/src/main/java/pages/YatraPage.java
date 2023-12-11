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

import static jdk.javadoc.doclet.Reporter.*;

public class YatraPage extends BaseTest {

    /******************************** XPATH *************************************/
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

    /******************************** Generic Methods *************************************/
    public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./src/main/java/Snapshots/" + fileName + ""));
    }

    public void switchToChildWindow() {
        String mainWindowHandle = driver.getWindowHandle(); // Store the current window handle
        Set<String> windowHandles = driver.getWindowHandles(); // Get all window handles
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle); // Switch to the pop-up window
                break;
            }
        }
    }

    public void switchToParentWindow() {
        Set<String> windowHandles = driver.getWindowHandles(); // Get all window handles
        for (String handle : windowHandles) {
            driver.switchTo().window(handle); // Switch to the pop-up window
            break;
        }
    }

    // Initialize page objects(factory)
    //constructor
    public YatraPage() {
        PageFactory.initElements(driver, this);
    }  //initialize driver->switch to BaseTest Class, this-> current class objects(all above objects)

    // Actions Methods

    public void clickOffersLink() throws IOException {
        takeScreenshot(driver, "Img1.png");
        Actions action = new Actions(driver);
        action.moveToElement(offers).click().build().perform();
        takeScreenshot(driver, "Img2.png");
    }

    public boolean BannerPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(banner));
        return banner != null && banner.isDisplayed();
    }

    public boolean domestic() {
        return domestic.isDisplayed();
        //isDisplayed returns true or false if the title is present

    } //return statement returns true if it is available otherwise it returns false

    public void clickHolidaysLink() throws IOException {
        Actions action = new Actions(driver);
        action.moveToElement(Holidays).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Holidays)).click();
        takeScreenshot(driver, "Img3.png");
    }

    public void baliViewDetails() {
        Actions action = new Actions(driver);
        action.moveToElement(baliViewDetailsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }


    public void baliPackagePrice() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToChildWindow();
        wait.until(ExpectedConditions.visibilityOf(packageName));
        String baliPackageName = packageName.getText();
        String baliPrice = packagePrice.getText();
        System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
        takeScreenshot(driver, "Img4.png");
        driver.close();
        switchToParentWindow();

    }

    public void dubaiViewDetials() {
        Actions action = new Actions(driver);
        action.moveToElement(dubaiViewDetailsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void dubaiPackagePrice() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToChildWindow();
        wait.until(ExpectedConditions.visibilityOf(packageName));
        String baliPackageName = packageName.getText();
        String baliPrice = packagePrice.getText();
        System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
        takeScreenshot(driver, "Img5.png");
        driver.close();
        switchToParentWindow();
    }


    public void maldivesViewDetails() {
        Actions action = new Actions(driver);
        action.moveToElement(maldivesViewDetialsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void maldivesPackagePrice() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToChildWindow();
        wait.until(ExpectedConditions.visibilityOf(packageName));
        String baliPackageName = packageName.getText();
        String baliPrice = packagePrice.getText();
        System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
        takeScreenshot(driver, "Img6.png");
        driver.close();
        switchToParentWindow();

    }

    public void singaporeViewDetails() {
        Actions action = new Actions(driver);
        action.moveToElement(singaporeViewDetialsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void singaporePackagePrice() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToChildWindow();
        wait.until(ExpectedConditions.visibilityOf(packageName));
        String baliPackageName = packageName.getText();
        String baliPrice = packagePrice.getText();
        System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
        takeScreenshot(driver, "Img7.png");
        driver.close();
        switchToParentWindow();

    }


    public void mauritisViewDetails() {
        Actions action = new Actions(driver);
        action.moveToElement(mauritisViewDetialsButton).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void mauritisPackagePrice() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToChildWindow();
        wait.until(ExpectedConditions.visibilityOf(packageName));
        String baliPackageName = packageName.getText();
        String baliPrice = packagePrice.getText();
        System.out.println("PackageName is: " + baliPackageName + " | " + "PackagePrice is: " + baliPrice);
        takeScreenshot(driver, "Img8.png");
        driver.close();
        switchToParentWindow();
    }
}





