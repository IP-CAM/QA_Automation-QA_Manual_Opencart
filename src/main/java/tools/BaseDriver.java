package tools;

import com.sun.istack.internal.logging.Logger;
import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static tools.MyProperties.getBrowserName;

public class BaseDriver {
	
	//Warper of all drivers
	public static WebDriver driver;
	private MyProperties prop = new MyProperties();



    @BeforeTest
    public void initializeDriver() throws IOException{
        driver=initialDriver();
    }


	public WebDriver initialDriver() throws IOException{


		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\Documents\\Project\\aqa\\framework\\src\\main\\java\\tools\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			 //write setProperty for driver if the are not situated in the folder windows or system32
			 //System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			 driver = new FirefoxDriver();
		}
		
		else if (browserName.equals("IE"))
		{
		
			driver = new InternetExplorerDriver();
			
		}
		else if (browserName.equals("opera"))
		{
			driver = new OperaDriver();
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;

	}



//
//        @AfterMethod
//    public void tearDown(ITestResult iTestResult) {
//        String testName = String.format("%s.%s", getClass().getSimpleName(), iTestResult.getName());
//
//        log.info("===================================");
//        if (iTestResult.isSuccess()) {
//            log.info(String.format(" %s PASSED ", testName));
//        } else {
//            log.info(String.format(" %s FAILED ", testName));
//            saveSnapshotOnFailure(testName);
//        }
//        log.info("===================================");
//        driver.getDriver().quit();
//    }

	// @AfterMethod
	// public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
	//     if (testResult.getStatus() == ITestResult.FAILURE) {
	//         File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
	//         FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
	//                 + Arrays.toString(testResult.getParameters()) + "-" +  properties.getBrowserName() +   ".jpg"));
	//     }
	// }

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + "-" + prop.getBrowserName() + ".jpg"));
		}
	}


	@AfterTest




    public void tearDown(){
        driver.quit();
        driver=null;
    }

}

	
	        
