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
    }


    @Test
    public void yatraTestCase() throws Exception {

        Reporter.log("Offers Link clicked successfully", true);
        yatraPage.clickOffersLink();

        boolean bannerValue = yatraPage.BannerPage();
        Reporter.log("BannerLogo Validation is passed", true);
        Assert.assertTrue(bannerValue, "Banner is not displayed");
        //calling bannerValue

        yatraPage.BannerPage();
        boolean domesticValue = yatraPage.domestic();
        Reporter.log("BrowserTitle Validation is passed", true);
        Assert.assertTrue(domesticValue);  //calling domesticValue

        yatraPage.clickHolidaysLink();

        yatraPage.baliViewDetails();
        yatraPage.baliPackagePrice();

        yatraPage.dubaiViewDetials();
        yatraPage.dubaiPackagePrice();

        yatraPage.maldivesViewDetails();
        yatraPage.maldivesPackagePrice();

        yatraPage.singaporeViewDetails();
        yatraPage.singaporePackagePrice();

        yatraPage.mauritisViewDetails();
        yatraPage.mauritisPackagePrice();

        Reporter.log("PackageNames with prices passed successfully", true);
        Reporter.log("captured snapshots successfully", true);

    }
    @AfterMethod
    public void teardown() {

        driver.quit();
    }
}
