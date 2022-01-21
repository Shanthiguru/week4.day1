package week4.day1.AlertsFrames;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assgmt_LeafGroundFrames {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
		File source = clickButton.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/Clickbutton.png");
		FileUtils.copyFile(source, destination);

		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int count = frames.size();

		System.out.println("Total Frames:"+count);
		

	}

}
