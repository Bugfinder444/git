package selenium;
import java.util.List;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	public static void main(String[] args) throws InterruptedException{
		
		int blogsCount=0;
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Fleek IT solutions");
		driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
		

		driver.findElement(By.xpath("//h3[contains(text(),'Fleek IT Solutions - T')]")).click();
		driver.findElement(By.xpath("//i[contains(@class,\"menu_icon\")]/following-sibling::span[text()=\"Blogs\"]")).click();
		
		
		for(int i=0;i<9;i++)
		{	
			List<WebElement> listBlogs=driver.findElements(By.xpath("//div[@class='post_image']"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@class='next']")).click();
			Thread.sleep(2000);
			int size =listBlogs.size();
			blogsCount=blogsCount+size;
		}
		System.out.println("No. of Blogs: "+blogsCount);
		Thread.sleep(2000);
		driver.quit();
	}	
}
	

