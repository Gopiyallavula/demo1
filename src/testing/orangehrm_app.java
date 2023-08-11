package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class orangehrm_app {
public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
	
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
			{
				
				System.out.println("is displayed");
				
			}else
			{
			
				System.out.println("is not displayed");
				
			}
				driver.findElement(By.linkText("PIM")).click();
				driver.findElement(By.linkText("Add Employee")).click();
				driver.findElement(By.id("firstName")).sendKeys("anu");
				driver.findElement(By.id("lastName")).sendKeys("y");
				String empid =driver.findElement(By.id("employeeId")).getAttribute("value");
				driver.findElement(By.id("btnSave")).click();
				
				driver.findElement(By.linkText("Employee List")).click();
				driver.findElement(By.id("empsearch_id")).sendKeys(empid);
				driver.findElement(By.id("searchBtn")).click();
				
				
			WebElement emptable;
			emptable = driver.findElement(By.id("search-results"));
			List<WebElement> rows = emptable.findElements(By.tagName("tr"));
			
			for(int i=1;i<rows.size();i++)
			{
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
				if(cols.get(1).getText().equals(empid))
				{
					System.out.println("emp registration is pass");
				}else
				{
					System.out.print("emp registration is fail");
				}
			}
			
			driver.findElement(By.partialLinkText("Welcome")).click();
			driver.findElement(By.linkText("Logout")).click();
		
			driver.findElement(By.id("txtUsername")).sendKeys("abc");
			driver.findElement(By.id("txtPassword")).sendKeys("xyz");
			driver.findElement(By.id("btnLogin")).click();
			
			boolean errmsg;
			if(errmsg = driver.findElement(By.id("spanMessage")).isDisplayed())
			{
				
				System.out.println("errmsg displayed");
			}else
			{
				System.out.println("errmsg not displayed");
			}
			
		}
}	
				

	

		
