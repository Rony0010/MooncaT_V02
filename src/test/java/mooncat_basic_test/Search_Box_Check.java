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

public class Search_Box_Check {

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
	public void Check_Search_Box_Functionality() {
		
		
		//Click on the Search-icon
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[1]")).click();
		
		//Type the value on the Search-box-input field
		driver.findElement(By.xpath("//*[@id=\"Search-In-Modal-1\"]")).sendKeys("moonflower");
		
		driver.findElement(By.xpath("//*[@id=\"Search-In-Modal-1\"]")).sendKeys(Keys.ENTER);
		
	
		System.out.println("Clicked on View all");
		
		
		//Check the product is added to the wishlist page or not
	    String AddedProduct = driver.findElement(By.xpath("//*[@id=\"product-grid\"]/li[1]/div/div/div[3]/div[1]/h3/a")).getText();
		
		
		
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class = 'card__information']/h3[@class = 'card__heading h5 product-card__title']"));
		
		int total_items = list.size();
		
		System.out.println("\n---------------------------------------------\nTotal Number of Products : " + total_items +"\n---------------------------------------------\n");
		
		for(WebElement li : list) {
			System.out.println("-->" + li.getText()+ "\n");
		}
		
		

		 //Verify Test Case
	        String ExpectedProduct = "MOONFLOWER";
	        String ActualProduct = AddedProduct ; 
	        
	        if(ExpectedProduct.equals(ActualProduct)) {
	        	
	        	System.out.println("\n \n--------------------------------------------------------------------\n");
	        	System.out.println("Search Box functionality is working properly and Test Case have passed !!! \n\n---------------------------------------------------------------------\n\n\n\n");
	        	
	        }
	        else {
	        	
	        	System.out.println("\n \n Not Matching !!");
	        }		
		 
 
		
	}

	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(3000); //wait for 3 seconds before quit
		
		driver.close();
		driver.quit();
	}
	
	
}
