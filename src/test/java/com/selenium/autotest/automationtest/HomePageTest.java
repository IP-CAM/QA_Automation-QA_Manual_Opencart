package com.selenium.autotest.automationtest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import tools.BaseDriver;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class HomePageTest extends BaseDriver {

	//private static Logger log = Logger.getLogger(Loggre.class.getName());

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException{

		//BasicConfigurator.configure();

		//		driver.get(prop.getProperty("url"));
		driver.get("https://google.com.ua");
        MainPage l=new MainPage(driver);
		l.getLogin().click();
		LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.clickNextEmail().click();
		lp.getPassword().sendKeys(Password);
		lp.clickNextPass().click();
		Assert.assertEquals(lp.assertVisibleText().getText(), "Добро пожаловать!7");
		//Assert.assertTrue(lp.assertVisibleText().isDisplayed());
	}




	@DataProvider
	public Object[][] getData(){

		Object[][] data=new Object[2][2];
		data[0][0]="vadym.stroiu@gmail.com";
		data[0][1]="incorectPassword";

		data[1][0]="vadym.stroiu@gmail.com";
		data[1][1]="incorectpassword2";

		return data;
	}




}
