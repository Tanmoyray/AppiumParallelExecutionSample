package com.appium.driveu.bookingflow;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;



public class DriveUAppTest {
	public AndroidDriver<MobileElement>driver;

	public static DesiredCapabilities cap;

	
	@BeforeTest(alwaysRun = true)
	@Parameters({ "port", "device", "platform_name", "platform_version" })

	public void setUp(String port, String device, String platform_name, String platform_version) throws IOException, InterruptedException {

		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);

		cap.setCapability(MobileCapabilityType.APP, "/Users/tanmoyray/Documents/AndroidApk/Hybrid/com.instagram.android_v8.2.0-30992021_Android-4.1.apk");
		//cap.setCapability("app_package", "com.instagram.android");
		//cap.setCapability("app_activity", "com.instagram.android.activity.MainTabActivity");	

		URL url = new URL("http://localhost:"+port+"/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			

	}

	/*@Test
	public void waitTill() throws InterruptedException {
		Thread.sleep(20000);
	}*/
	
	@Test
	public void Signup() throws InterruptedException{
		
		LoginPage login= new LoginPage(driver);
		
		login.clkSignup.click();
		Thread.sleep(1500);
		Assert.assertEquals(true, true);
		login.clkcntcode.click();
		Thread.sleep(1500);
		Assert.assertEquals(true, true);
		login.typsearch.sendKeys("India");
		Thread.sleep(1500);
		Assert.assertEquals(true, true);
		login.selectIndia.click();
		Thread.sleep(1500);
		login.phone_field.sendKeys("9876543210");
		Thread.sleep(1500);
		Assert.assertEquals(true, true);
		login.next_button.click();
		Thread.sleep(15000);
		Assert.assertEquals(true, true);
	}

	@AfterMethod
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();

	}



}

