package week4.day1.AlertsFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assgmt_Windows {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//First
		driver.findElement(By.id("home")).click();
		String parWindow = driver.getWindowHandle();
		System.out.println("Parent window:"+parWindow);
		Set<String> Windows = driver.getWindowHandles();
		for (String string : Windows) {
			System.out.println("Child windows in HomePage:"+string);
		}
		List<String> listwindows=new ArrayList<String>(Windows);
	    String child = listwindows.get(1);
	    driver.switchTo().window(child);
	    driver.close();
	    driver.switchTo().window(parWindow);
	    
	    //Second
	    driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
	    Set<String> Windows1 = driver.getWindowHandles();
		for (String string1 : Windows1) {
			System.out.println("Child windows in Multiple windows:"+string1);
		}
		List<String> listwindows1=new ArrayList<String>(Windows1);
	     int size = listwindows1.size();
	    System.out.println("Total windows opened in Multiple windows:"+size);
	    
	    //Third
	    driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
	    driver.switchTo().window(listwindows1.get(1));
	    driver.close();
	    driver.switchTo().window(listwindows1.get(2));
	    driver.close();
	    driver.switchTo().window(parWindow);
	    
	    //Fourth
	    driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
	    Thread.sleep(5000);
	    driver.quit();
	   
	    

	}

}
