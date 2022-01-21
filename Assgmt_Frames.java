package week4.day1.AlertsFrames;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assgmt_Frames {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame1");
		WebElement element = driver.findElement(By.xpath("//b[@id='topic']//following-sibling::input"));
		element.sendKeys(Keys.ENTER);
		element.sendKeys("Learn Selenium");
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		WebElement element1 = driver.findElement(By.xpath("//select[@id='animals']"));
		Select dropdown = new Select(element1);
		dropdown.selectByVisibleText("Avatar");
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/FrameAvatar.png");
		FileUtils.copyFile(source, destination);

	}

}
