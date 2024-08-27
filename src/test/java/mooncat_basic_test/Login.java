package mooncat_basic_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class Login {

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
	
	
	
	public void NavigateToLoginPage() {
			
		//Automate the mouse hover and click to the link
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[2]"))).build().perform();
        driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[2]/div/div/a")).click();
          
			
		}
	
	
	public void ClickOnLoginButton() {
		
		
		//NavigateToLoginPage();
		//Click on the login button
        driver.findElement(By.xpath("//*[@id=\"LoginButton\"]")).submit();
          
			
		}
	
	public void ClickOnLogoutButton() {
			
			
		 driver.findElement(By.xpath("//*[@id=\"customer_logout_link\"]")).click();
	          
				
		}
		
	
	@Test (priority = 1)
	public void CreateNewAccount() throws InterruptedException {
		
		NavigateToLoginPage();
		
		//Clicked on Create Account Link      
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/a")).click();
		
		//Input informations to create account
        driver.findElement(By.xpath("//*[@id=\"RegisterForm-FirstName\"]")).sendKeys("Rana");
        driver.findElement(By.xpath("//*[@id=\"RegisterForm-LastName\"]")).sendKeys("Khan");
        driver.findElement(By.xpath("//*[@id=\"RegisterForm-email\"]")).sendKeys("rana@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"RegisterForm-password\"]")).sendKeys("12345"); 
      
        driver.findElement(By.xpath("//*[@id=\"RegisterButton\"]")).submit();
        
    	System.out.println("\n \nNew Account has been created !!!\n\n");
        Thread.sleep(3000); //wait for 3 seconds
        
        NavigateToLoginPage();
        
        //Input correct email and password
        driver.findElement(By.xpath("//*[@id=\"CustomerEmail\"]")).sendKeys("rana@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"CustomerPassword\"]")).sendKeys("12345");
        
        ClickOnLoginButton();
        
        //Verify Test Case
        String Expected_url = "https://www.mooncat.com/account";
        String Actual_url = driver.getCurrentUrl(); 
        //System.out.println(Actual_url);
        
        if(Expected_url.equals(Actual_url)) {
        	
        	System.out.println("\n \nCreate New Account Test Passed !!!\n\n");
        	
        }
        else {
        	
        	System.out.println("\n \nCreate New Account Test Failure !!");
        }
        
        Thread.sleep(3000); //wait for 3 seconds
        
        ClickOnLogoutButton();
		
		
		}
		
	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(10000); //wait for 10 seconds before quit
		
		driver.close();
		driver.quit();
	} 
}
