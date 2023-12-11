package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import util.TestUtil;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;
    FileInputStream file = null;

    public BaseTest() {

        prop = new Properties();
        try {
            file = new FileInputStream("src\\main\\java\\config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initliaze() {

        String browsername = prop.getProperty("browser");


        if (browsername.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("Driver is not started");
        }


            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            //driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load, TimeUnit.SECONDS);
            //driver.manage().timeouts().implicitlyWait(TestUtil.implicity_wait, TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));


        }


    }
