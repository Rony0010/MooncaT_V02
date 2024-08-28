package mooncat_basic_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Get_All_Links {

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
	public void Print_All_Links() {
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		
		int totalLinks = list.size();
		
		System.out.println("\n---------------------------------------------\nTotal Number of Links : " + totalLinks +"\n---------------------------------------------\n\n");
		
		for(WebElement li : list) {
			System.out.println(li.getText() +" ->>> "+ li.getAttribute("href") +"\n");
		}
		
		
	}
	


	@Test
	public void Check_All_Image() {
		
		List<WebElement> list = driver.findElements(By.tagName("img"));
		
		int totalLinks = list.size();
		
		System.out.println("\n---------------------------------------------\nTotal Number of Images : " + totalLinks +"\n---------------------------------------------\n\n");
		
		for(WebElement li : list) {
			System.out.println(li.getText() +" ->>> "+ li.getAttribute("src")+ " ->> " + li.getAttribute("alt") +"\n");
		}
		
		
	}
	

	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(3000); //wait for 10 seconds before quit
		
		driver.close();
		driver.quit();
	}
	
	
}
