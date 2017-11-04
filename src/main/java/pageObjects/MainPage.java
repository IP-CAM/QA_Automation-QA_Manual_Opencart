package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

	public WebDriver driver;

	private static String URL = "https://google.com.ua";
	By signin = By.id("gb_70");


	public MainPage(WebDriver driver){
		this.driver=driver;
	}

	public WebElement getLogin(){
		return driver.findElement(signin);
	}
	
		
	
	}