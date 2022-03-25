package seleniumBasicOperations;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandler 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.id("newWindowBtn")).click();
		String currentwindow=driver.getWindowHandle();
		System.out.println("Current window - "+currentwindow);
		Set<String> allwindows= driver.getWindowHandles();
		//for(String handles:allwindows)
		//{
		//	System.out.println(handles);
		//}
		Object[] windows=allwindows.toArray();
		
		int count=windows.length;
		for(int i=0;i<count;i++)
		{
		String window=windows[i].toString();
		System.out.println("Window"+i+" = " +window);
		}
		driver.switchTo().window(windows[1].toString());
		String newwindow=driver.getWindowHandle();

		System.out.println("second window "+newwindow);
		
		driver.findElement(By.id("firstName")).sendKeys("amith");
		driver.findElement(By.id("lastName")).sendKeys("demo");
		driver.findElement(By.id("malerb")).click();
		WebElement echkbox= driver.findElement(By.id("englishchbx"));
		echkbox.click();
		
			System.out.println(echkbox.isSelected());
		driver.findElement(By.id("email")).sendKeys("amith.demo@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc124");
		driver.findElement(By.id("registerbtn")).click();
		String regsuccess=driver.findElement(By.id("msg")).getText().toLowerCase();
		if(regsuccess.equalsIgnoreCase("registration is successful"))
		{
			System.out.println("Successfully registered");
		}
		else
		{
			System.out.println("Registration failed");
		}
		driver.findElement(By.linkText("Click here to navigate to the home page")).click();
		driver.close();
		
		driver.switchTo().window(currentwindow);
		
		String currentwindowurl=driver.getCurrentUrl();
		System.out.println("current window url = "+currentwindowurl );
		driver.close();
	}

}
