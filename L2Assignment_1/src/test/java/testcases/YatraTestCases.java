package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.YatraPage;

import java.io.IOException;
import java.time.Duration;



public class YatraTestCases extends BaseTest {
    YatraPage yatraPage;


    // Calling Parent class(BaseTest class)Constructor
    public YatraTestCases() {
        super();

    }


    @BeforeMethod
    public void launchBrowser() {
        initliaze();  //Initializing from BaseTest Class,before initialization it will call super class constructor
        yatraPage = new YatraPage();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Example usage: wait for an element to be visible
        // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Offers")));
    }


    @Test(priority = 1)
    public void selectOffers() {
        Reporter.log("Offers Link clicked successfully", true);
        yatraPage.clickOffersLink();
    }


    @Test(priority = 2)
    public void validateBanner(){
        yatraPage.clickOffersLink();
        boolean bannerValue = yatraPage.BannerPage();
        Reporter.log("BannerLogo Validation is passed", true);
        Assert.assertTrue(bannerValue, "Banner is not displayed");  //calling bannerValue
    }

    @Test(priority = 3)
    public void validateDomestic(){
        yatraPage.clickOffersLink();
        yatraPage.BannerPage();
        boolean domesticValue = yatraPage.domestic();
        Reporter.log("BrowserTitle Validation is passed", true);
        Assert.assertTrue(domesticValue);  //calling domesticValue

    }

    @Test(priority = 4)
    public void captureScreenshot() throws IOException{
        String screenshotPath = "C:\\Users\\BhargaviK\\Intelli J-Maven\\L2Assignment_1\\src\\main\\java\\snapshot\\image0.png";
        yatraPage.captureScreenshot(screenshotPath);
        Reporter.log("Screenshot captured successfully");
    }

    @Test(priority = 5)
    public void getHolidayPackagesWithPrices() throws Exception {

        yatraPage.clickOffersLink();
        yatraPage.clickHolidaysLink();
        String screenshotPath = "C:\\Users\\BhargaviK\\Intelli J-Maven\\L2Assignment_1\\src\\main\\java\\snapshot\\image1.png";
        yatraPage.captureScreenshot(screenshotPath);

        yatraPage.baliViewDetails();
        String screenshotPath0 = "C:\\Users\\BhargaviK\\Intelli J-Maven\\L2Assignment_1\\src\\main\\java\\snapshot\\image2.png";
        yatraPage.captureScreenshot(screenshotPath0);
        yatraPage.baliPackagePrice();

        yatraPage.dubaiViewDetials();
        String screenshotPath1 = "C:\\Users\\BhargaviK\\Intelli J-Maven\\L2Assignment_1\\src\\main\\java\\snapshot\\image3.png";
        yatraPage.captureScreenshot(screenshotPath1);
        yatraPage.dubaiPackagePrice();

        yatraPage.maldivesViewDetails();
        String screenshotPath2 = "C:\\Users\\BhargaviK\\Intelli J-Maven\\L2Assignment_1\\src\\main\\java\\snapshot\\image4.png";
        yatraPage.captureScreenshot(screenshotPath2);
        yatraPage.maldivesPackagePrice();

        yatraPage.singaporeViewDetails();
        String screenshotPath3 = "C:\\Users\\BhargaviK\\Intelli J-Maven\\L2Assignment_1\\src\\main\\java\\snapshot\\image5.png";
        yatraPage.captureScreenshot(screenshotPath3);
        yatraPage.singaporePackagePrice();

        yatraPage.mauritisViewDetails();
        String screenshotPath4 = "C:\\Users\\BhargaviK\\Intelli J-Maven\\L2Assignment_1\\src\\main\\java\\snapshot\\image6.png";
        yatraPage.captureScreenshot(screenshotPath4);
        yatraPage.mauritisPackagePrice();

        Reporter.log("PackageNames with prices passed successfully", true);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
