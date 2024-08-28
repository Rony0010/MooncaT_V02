package mooncat_basic_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {

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
	
	
	@Test
	public void CheckAddToCartButton() throws InterruptedException {
		
		
		 driver.findElement(By.xpath("//*[@id=\"Slide-template--15967084642464__featured_collection-2\"]/div/div/div[3]/div[1]/h3/a")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//*[@id=\"product-form-template--15967085297824__main\"]/div/button/span/text()")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//*[@id=\"Quantity-template--15967085297824__main\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"Quantity-template--15967085297824__main\"]")).sendKeys("3");
		 driver.findElement(By.xpath("//*[@id=\"cart-icon-bubble\"]/svg")).click();
		 
		 Thread.sleep(10000);
		 
		 //Click on Cart icon
		 driver.findElement(By.xpath("//*[@id=\"cart-notification-button\"]")).click();
		 
		 
		 
		 String itemQuantity =  driver.findElement(By.xpath("//input[@class=\"quantity__input\"][@type=\"number\"]")).getAttribute("value");
		 
		 
		 //Verify Test Case
	        String itemQtn = "3";
	        String ActualQtn = itemQuantity; 
	        
	        if(itemQtn.equals(ActualQtn)) {
	        	
	        	System.out.println("\n \n----------------------------------------\n");
	        	System.out.println("Item Quantity Matching and Test Case have passed !! \n\n----------------------------------------\n");
	        	
	        }
	        else {
	        	
	        	System.out.println("\n \n Not Matching !!");
	        }		
		 
				
		}
		

	
	
	

	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(10000); //wait for 10 seconds before quit
		
		driver.close();
		driver.quit();
	}
	

	
	
	
	
}
