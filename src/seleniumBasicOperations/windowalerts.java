package seleniumBasicOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowalerts 
{
	public static void main(String[] args) throws Exception
	{
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.id("newTabBtn")).click();
		
		String parentwindow=driver.getWindowHandle();
		System.out.println("Parent window "+parentwindow);
		Set<String> handles=driver.getWindowHandles();
		Object[] window=handles.toArray();
		
		driver.switchTo().window(window[1].toString());
		String childwindow=driver.getWindowHandle();
		System.out.println("child window "+childwindow);
		String title=driver.getTitle().toLowerCase();
		String exptitle="alert";
		System.out.println(title);
		if(title.contains(exptitle))
		{
			System.out.println("Test pass");	
		}
		else
		{
			System.out.println("Test fail");
		}
		
		driver.findElement(By.id("alertBox")).click();
		//Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmBox")).click();
		Thread.sleep(2000);
		String alerttext=driver.switchTo().alert().getText().toLowerCase();
		System.out.println(alerttext);
		String expalert="invalid";
		if(alerttext.contains(expalert))
		{
			System.out.println("alert opened");
	        driver.switchTo().alert().accept();
		}
		else
		{
			System.out.println("fail");
			driver.switchTo().alert().dismiss();
		}
		String alertname="poornima";
		driver.findElement(By.id("promptBox")).click();
		driver.switchTo().alert().sendKeys(alertname);
		Thread.sleep(5000);
		//String thirdactalert=driver.switchTo().alert().getText().toLowerCase();
		String textbox=" ";
		if(!textbox.contains(alertname))
		{
			System.out.println("Third alert pass");
			driver.switchTo().alert().accept();
			
		}
		else
		{
			System.out.println("Text box is empty");
			driver.switchTo().alert().dismiss();
			
		}
		String popupmsg=driver.findElement(By.id("output")).getText();
		if(popupmsg.contains(alertname))
		{
			System.out.println("Alert name added successfully");
		}
		else
		{
			System.out.println("Alert name not added");
		}
	}

}
