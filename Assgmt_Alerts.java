package week4.day1.AlertsFrames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assgmt_Alerts {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text() = 'Alert Box']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		
		driver.findElement(By.xpath("//button[text() = 'Confirm Box']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[text() = 'Prompt Box']")).click();
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Test");
		Thread.sleep(2000);
		alert2.accept();
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		String text1 = driver.findElement(By.xpath("//div[@class='swal-text']")).getText();
		System.out.println(text1);

		driver.close();
		
	}

}
