package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	
	By emailId = By.id("identifierId");
	By nextButtonEmailId = By.id("identifierNext");
	By passwordName = By.name("password");
	By nextButtonPassId = By.id("passwordNext");
	By searchButtonNamisibleTextClass = By.className("sfYUmb");



	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	public WebElement getEmail(){
		return driver.findElement(emailId);
	}
	
	public WebElement clickNextEmail(){
		return driver.findElement(nextButtonEmailId);
	} 	
	
	public WebElement getPassword(){
		return driver.findElement(passwordName);
	}
	
	public WebElement clickNextPass(){
		return driver.findElement(nextButtonPassId);
	}
	public WebElement assertVisibleText(){
		return driver.findElement(searchButtonNamisibleTextClass);
	}


}