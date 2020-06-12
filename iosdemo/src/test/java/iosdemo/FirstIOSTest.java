package iosdemo;

//import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstIOSTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		firstTest();
	}

	public static void firstTest() throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11 Pro Max");
		dc.setCapability(MobileCapabilityType.APP,
				"/Users/brep/Library/Developer/Xcode/DerivedData/AppiumTest-dxscgimacrlwqbclqysjsmopjscu/Build/Products/Debug-iphonesimulator/AppiumTest.app");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		IOSDriver driver = new IOSDriver(url, dc);
		
		List <WebElement> listItems = driver.findElementsByXPath("//XCUIElementTypeStaticText");
		
		Thread.sleep(1000);
		
		System.out.println(listItems.size());
		
		for(WebElement li:listItems) {
			System.out.println(li.getText());
		}
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Click\"]").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Got it.\"]").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Click\"]").click();
		
		Thread.sleep(1000);
		
		driver.findElementByAccessibilityId("I dare you to tell my supervisor!").click();
	}
}
