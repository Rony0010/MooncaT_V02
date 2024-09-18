package mooncat_basic_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;



public class Currency_Converter_test {

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
	
	
	
	@Test(priority = 1)
	public void USD_to_CAD_Converter() throws InterruptedException {
		
		
		//click on the Product
		driver.findElement(By.xpath("//*[@id=\"Slide-template--15967084642464__featured_collection-1\"]/div/div/div[3]/div[1]/h3/a")).click();
		//Thread.sleep(3000);
		
		//get the USD Price
		String usdPrice =  driver.findElement(By.xpath("//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/div[2]/div/div[1]/span[2]/span")).getText();
		Thread.sleep(2000);
		
		
		//click on currency menu
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]/span")).click();
		
		Thread.sleep(5000);
		
		//change the currency to CAD
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[2]")).click();
		
		//get the price with currency notation
		String cadPrice =  driver.findElement(By.xpath("//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/div[2]/div/div[1]/span[2]")).getText();
		System.out.println("\nProduct price in $USD : " +usdPrice);
		System.out.println("\n\nProduct price in $CAD : " +cadPrice);
		
		//the word to search for
		String expectedText = "CAD";
		
		// Check if the currency converter working
        if (cadPrice.contains(expectedText)) {
            System.out.println("\n >> $USD to $CAD is working properly !! \n");
        } else {
            System.out.println("\n $USD to $CAD is not working properly !! \n");
        }		
		
	}
	
	

	
	@Test(priority = 2)
	public void USD_to_GBP_Converter() throws InterruptedException {
		
		//click on the mooncat logo
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/a")).click();
		Thread.sleep(2000);
		
		//click on the Product
		driver.findElement(By.xpath("//*[@id=\"Slide-template--15967084642464__featured_collection-1\"]/div/div/div[3]/div[1]/h3/a")).click();
		//Thread.sleep(3000);
		
		
		//click on currency menu
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]")).click();
		Thread.sleep(5000);
		

		//change the currency to USD
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[1]")).click();
		Thread.sleep(3000);
		
		//click on currency menu
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]")).click();
		Thread.sleep(2000);
				
		
		//change the currency to GBP
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[3]")).click();
		Thread.sleep(2000);
		
		//get the price with currency notation
		String gbpPrice =  driver.findElement(By.xpath("//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/div[2]/div/div[1]/span[2]")).getText();
		//System.out.println("\nProduct price in USD : " +usdPrice);
		System.out.println("\nProduct price in £GBP  : " +gbpPrice);
		
		//the word to search for
		String expectedText = "GBP";
		
		// Check if the currency converter working
        if (gbpPrice.contains(expectedText)) {
            System.out.println("\n >> $USD to £GBP is working properly !! \n");
        } else {
            System.out.println("\n $USD to £GBP is not working properly !! \n");
        }		
		
	}
	


	
	@Test(priority = 3)
	public void USD_to_EUR_Converter() throws InterruptedException {
		
		//click on the mooncat logo
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/a")).click();
		Thread.sleep(2000);
		
		//click on the Product
		driver.findElement(By.xpath("//*[@id=\"Slide-template--15967084642464__featured_collection-1\"]/div/div/div[3]/div[1]/h3/a")).click();
		//Thread.sleep(3000);
		
		
		//click on currency menu
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]")).click();
		Thread.sleep(5000);
		

		//change the currency to USD
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[1]")).click();
		Thread.sleep(3000);
		
		//click on currency menu
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]")).click();
		Thread.sleep(2000);
				
		
		//change the currency to EUR
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[4]")).click();
		Thread.sleep(2000);
		
		//get the price with currency notation
		String gbpPrice =  driver.findElement(By.xpath("//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/div[2]/div/div[1]/span[2]")).getText();
		System.out.println("\nProduct price in €EUR  : " +gbpPrice);
		
		//the word to search for
		String expectedText = "EUR";
		
		// Check if the currency converter working
        if (gbpPrice.contains(expectedText)) {
            System.out.println("\n >> $USD to €EUR is working properly !! \n");
        } else {
            System.out.println("\n $USD to €EUR is not working properly !! \n");
        }		
		
	}
	
		
	
	
	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(10000); //wait for 10 seconds before quit
		
		driver.close();
		driver.quit();
	}
}
