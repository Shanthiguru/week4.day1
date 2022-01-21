package week4.day1.AlertsFrames;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assgmt_MergeContact {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text() = 'Merge Contacts']")).click();
		
		//Widget of From
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> wins = driver.getWindowHandles();
		List<String> frWin = new ArrayList(wins);
		driver.switchTo().window(frWin.get(1));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement fromContact = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		System.out.println("First Contact:"+fromContact.getText());
		fromContact.click();
		driver.switchTo().window(frWin.get(0));
		
		//Widget of To
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> wins1 = driver.getWindowHandles();
		List<String> toWin = new ArrayList(wins1);
		driver.switchTo().window(toWin.get(1));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement toContact = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[2]"));
		System.out.println("Second Contact:"+toContact.getText());
		toContact.click();
		driver.switchTo().window(toWin.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Title of Screen:"+driver.getTitle());
		driver.close();

	}

}
