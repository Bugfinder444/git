package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment_1 {
	
public static void main(String[] args) throws InterruptedException{
		
		int blogsCount=0;
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Fleek It Solutions");
		element.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//h3[contains(text(),'Fleek IT Solutions - T')]")).click();
		driver.findElement(By.xpath("//i[contains(@class,\"menu_icon\")]/following-sibling::span[text()=\"Blogs\"]")).click();
		String nextButton = driver.findElement(By.xpath("//a[@href='https://www.fleekitsolutions.com/software-testing-latest-trends/page/9/']")).getAttribute("href");
		
		String totalPage=nextButton.replaceAll("[^0-9]","");
		int lastPage = Integer.parseInt(totalPage);
	
		for(int i=0;i<lastPage;i++)
		{	
			Thread.sleep(2000);
			List<WebElement> listBlogs=driver.findElements(By.xpath("//div[@class='post_image']"));
			Thread.sleep(2000);

			int count =listBlogs.size();
			blogsCount=blogsCount+count;
			
			driver.findElement(By.xpath("//li[@class='next']")).click();
		}
		System.out.println("No. of Blogs: "+blogsCount);
		Thread.sleep(2000);
		driver.quit();	
	}
}
