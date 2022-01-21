package week4.day1.AlertsFrames;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assgmt_ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev19055.service-now.com/login.do?");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Hari@2019");
		driver.findElement(By.id("sysverb_login")).click();
		WebElement filter = driver.findElement(By.id("filter"));
		filter.sendKeys("incident");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text() = 'All'])[2]")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println("Title of Page:"+driver.getTitle());
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[3]/a")).click();
		windowHandles = driver.getWindowHandles();
		windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(0));
		Thread.sleep(3000);
		System.out.println("Title of child page:"+driver.getTitle());
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Testing Short Description");
		String incNo = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident number created:"+incNo);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		WebElement search = driver.findElement(By.xpath("//input[@class = 'form-control']"));
		search.sendKeys(incNo);
		search.sendKeys(Keys.ENTER);

		String searchIncNo = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]")).getText();
		//driver.findElement(By.xpath("//td[@class='vt']/a")).getText();
		System.out.println("Incident number searched:"+searchIncNo);

		if (incNo.equals(searchIncNo) == true) {
			System.out.println("Incident created successfully");
		} else {
			System.out.println("Incident not created");
		}

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/ServiceNow.png");
		FileUtils.copyFile(source, destination);
		
		driver.close();
		
	}

}
