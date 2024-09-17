package mooncat_basic_test;

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
	
	@Test
	public void Check_Currency_Converter() {
		
		driver.findElement(By.xpath("//*[@id=\"Slide-template--15967084642464__featured_collection-1\"]/div/div/div[3]/div[1]/h3")).click();
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]")).click();
		WebElement changeTextElement = driver.findElement(By.xpath("//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/div[2]/div/div[1]/span[2]/span"));
		
		//get the text of the element
		String fullCadPrice = changeTextElement.getText();
		
		//the word to search for
		String expectedText = "CAD";
		
		// Check if the currency converter working for USD to CAD
        if (fullCadPrice.contains(expectedText)) {
            System.out.println("The Currency Covert for CAD working properly !!");
        } else {
            System.out.println("The Currency Converter is not working perfectly !!");
        }
		
	}
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(10000); //wait for 10 seconds before quit
		
		driver.close();
		driver.quit();
	}
}
