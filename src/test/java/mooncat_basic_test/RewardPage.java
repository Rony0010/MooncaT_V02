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
	public void Check_Reward_Functionality() {

		//Click on the Reward Link
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[2]/a")).click();
		
		
		//Click on the Signin Button on Reward page
		driver.findElement(By.xpath("//*[@id=\"shopify-section-template--16005566464160__rewards_page_header\"]/div/div[2]/div/a")).click();
		Login();
		
		
		//Click on Shop All Link
		driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[1]/a")).click();
		
		//added a paid item to the cart
		driver.findElement(By.xpath("//*[@id=\"product-grid\"]/li[2]/div/div/product-form/form/button")).click();
		
		//Click on the Reward Link
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[2]/a")).click();
		

		//Click on the Redeem now and Add to cart button
		driver.findElement(By.xpath("//*[@id=\"rewards-redeem\"]/div/div/div/div/div[2]/div/div[1]/div/div[3]/div[2]/div[2]/div/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"rewards-redeem\"]/div/div/div/div/div[2]/div/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"rewards-redeem\"]/div/div/div/div/div[2]/div/div[1]/div/div[3]/div[2]/div[2]/div/div/div[2]/button")).click();
		
		
		
		
		
		
				
	}

	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(3000); //wait for 3 seconds before quit
		
		driver.close();
		driver.quit();
	}
	

}
