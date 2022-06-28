package org.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public void fill(WebElement webElement, String text) {
		((WebElement) webElement).sendKeys(text);
	}
	
	public void btnClick(WebElement lognBtn) {
		((WebElement) lognBtn).click();
	}
	public void pageTitle() {

		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	public void windowsMaximize() {
		driver.manage().window().maximize();
	}
	private void applyWaitToAllElement() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	private void takeSnap() {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Lenovo\\eclipse-workspace\\PomTest\\Screenshots");
	}
	
}
