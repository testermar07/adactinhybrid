package com.adactin.hotelapp.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://imgur.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[@class='Button upload']")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Choose Photo/Video')]/child::img")).click();
		
		Thread.sleep(5000);
		
		StringSelection stringSelection=new StringSelection("E:\\WebDriver Architecture.png");
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		
		Clipboard clipboard=toolkit.getSystemClipboard();
		
		clipboard.setContents(stringSelection, null);
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(10000);
		
		driver.quit();
		
		
		
		
		
		
	}

}
