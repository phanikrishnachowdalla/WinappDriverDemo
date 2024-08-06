package com.mytests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class NotePadTests {

	
	public static WindowsDriver driver = null;
	
	
	
	@BeforeClass
	public void setUp() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("devicename", "WindowsPC");
		
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
		setUp();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();	
	}
	
	@Test
	public void checkHelpAboutNowTest() {
		
		driver.findElementByName("Help").click();
		driver.findElementByName("About Notepad").click();
		driver.findElementByName("OK").click();	
	}
	
	@Test
	public void enterTextIntoNotepad() {
		
		driver.findElementByName("Text Editor").sendKeys("Text Enter is good!!!");
		driver.findElementByName("Texteditor").clear();
	}
	
	@Test
	public void editAndClickOnDateTime() {
		driver.findElementByName("Edit").click();
		driver.findElementByName("Time/Date").click();
		driver.findElementByName("Text Editor").clear();
	}
	
	
	
}
