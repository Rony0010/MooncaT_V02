package mooncat_basic_test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckWishList {

	
	public String baseURL = "https://www.mooncat.com/";
	public WebDriver driver;
	@BeforeTest
	public void Setup() {
		
		//Driver initialization
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        //Implicit wait to load all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //Navigate to the project website
        driver.get(baseURL);  
		
	}
	

	
	public void NavigateToLoginPage() {
			
		//Automate the mouse hover and click to the link
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[2]"))).build().perform();
        driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[2]/div/div/a")).click();
          
			
		}
	
	
	
	
	public void Login() {
		
		driver.findElement(By.xpath("//*[@id=\"CustomerEmail\"]")).sendKeys("exdevqa@kineticbrands.com");
        driver.findElement(By.xpath("//*[@id=\"CustomerPassword\"]")).sendKeys("12345678");
   
		//Click on the login button
        driver.findElement(By.xpath("//*[@id=\"LoginButton\"]")).submit();
          
			
		}
	
	
	

	@Test
	public void CheckWishlistButton() throws InterruptedException {
		
		 NavigateToLoginPage();
		 Login();
		 
		 //Clicked on the Mooncat logo to navigate to the welcome page
		 driver.findElement(By.xpath("//*[@id=\"site-header\"]/a/img")).click();
		 
		 driver.findElement(By.xpath("//*[@id=\"Slide-template--15967084642464__featured_collection-2\"]/div/div/div[3]/div[1]/h3/a")).click();
		 //Thread.sleep(5000);
		
		 //get the product name
		 String productName =  driver.findElement(By.xpath("//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/h1")).getText();
		 System.out.println("Checking Product: "+ productName);
		 
		 
		//clicked on the wishlist-heart icon
		 driver.findElement(By.xpath("//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[2]/span")).click();
		 
		 
		 //Automate the mouse hover and click to the link
	     Actions action = new Actions(driver);
	     action.moveToElement(driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[2]"))).build().perform();
	     driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[2]/div/div/a[2]")).click();
	     
	     System.out.println("# Navigate to wishlist page");
	     
	     
	     //Check the product is added to the wishlist page or not
	     //String AddedProduct = driver.findElement(By.xpath("//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/h1")).getText();
			
	     	
	     List<WebElement> list = driver.findElements(By.xpath("//div[@class = 'card__information']/h3[@class = 'card__heading h5 product-card__title']"));
			
			int totalLinks = list.size();
			
			System.out.println("\n---------------------------------------------\nTotal Number of Products : " + totalLinks +"\n---------------------------------------------\n\n");
			
			for(WebElement li : list) {
				System.out.println("-->" + li.getText()+ "\n");
			}
			
			
		 

			 //Verify Test Case
		        String ExpectedProduct = "LACQUER SET";
		        String ActualProduct = productName; ; 
		        
		        if(ExpectedProduct.equals(ActualProduct)) {
		        	
		        	System.out.println("\n \n--------------------------------------------------------------------\n");
		        	System.out.println("Wishlist-icon is working Properly !!! \n\n---------------------------------------------------------------------\n");
		        	
		        }
		        else {
		        	
		        	System.out.println("\n \n Not Matching !!");
		        }		
			 
			
		 
		 
	}
	
	
	
	

	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(5000); //wait for 10 seconds before quit
		
		driver.close();
		driver.quit();
	}
	
	
	
	
}
