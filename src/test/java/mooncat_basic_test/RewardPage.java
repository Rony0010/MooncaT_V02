package mooncat_basic_test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RewardPage {


	public String baseURL = "https://www.mooncat.com/";
	public WebDriver driver;
	
	@BeforeTest
	public void Setup() {
		
		//Driver initialization
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        //Navigate to the project website
        driver.get(baseURL);  
		
	}
	

	public void Login() {
		
		driver.findElement(By.xpath("//*[@id=\"CustomerEmail\"]")).sendKeys("exdevqa@kineticbrands.com");
        driver.findElement(By.xpath("//*[@id=\"CustomerPassword\"]")).sendKeys("12345678");
   
		//Click on the login button
        driver.findElement(By.xpath("//*[@id=\"LoginButton\"]")).submit();
          
			
		}
	
	
	
	@Test
	public void Check_Reward_Functionality() throws InterruptedException {

		//Click on Shop All Link
		//driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[1]/a")).click();
				
		//added a paid item to the cart
		driver.findElement(By.xpath("//*[@id=\"Slide-template--15967084642464__featured_collection-2\"]/div/div/div[3]/div[1]/h3/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"product-form-template--15967085297824__main\"]/div/button/span")).click();
        
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[4]")).click();
		Thread.sleep(2000);


		
		//Click on the Reward Link
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[2]/a")).click();
		
		
		//Click on the Signin Button on Reward page
		driver.findElement(By.xpath("//*[@id=\"shopify-section-template--16005566464160__rewards_page_header\"]/div/div[2]/div/a")).click();
		Login();
		
		
		/*
		//Click on the Reward Link
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[2]/a")).click();
		*/

		//Click on the Redeem now and Add to cart button
		driver.findElement(By.xpath("//*[@id=\"rewards-redeem\"]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/div/div[3]/button/span")).click();
		System.out.println("Clicked on GetReward button");
		

		
		driver.findElement(By.xpath("//*[@id=\"rewards-redeem\"]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/button/span")).click();
		System.out.println("Clicked on YesAddToCart button");
		

		
		driver.findElement(By.xpath("//*[@id=\"rewards-redeem\"]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/button/span")).click();
		System.out.println("Clicked on ViewCart button");
		
		
		System.out.println("Test has been Passed");
		
		
		
		
				
	}

	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(3000); //wait for 3 seconds before quit
		
		driver.close();
		driver.quit();
	}
	

}
