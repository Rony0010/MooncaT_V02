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
	
	/*public void clickOnCurrencyMenu() {
		
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]")).click();
		
	}*/
	
	public void changeToUSD() {
	
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[1]")).click();
		
		System.out.println("changeToUSD");
	
	}
	
	public void verifyCurrencyConverter(String testFromCurrencyName, String testToCurrencyName, String changeCurrencyPath, String displayPricePath) {

		//click on Currency Menu
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[3]")).click();

		//change the currency
		String changeCurrency = changeCurrencyPath; 
		driver.findElement(By.xpath(changeCurrencyPath)).click();
		
		//get the full price with currency notation
		WebElement displayPriceWithSymbool = driver.findElement(By.xpath(displayPricePath));

		
		//get the text of the element
		String PriceWithSymbool = displayPriceWithSymbool.getText();
		
		//the word to search for
		String expectedText = testToCurrencyName;
		
		// Check if the currency converter working for USD to CAD
        if (PriceWithSymbool.contains(expectedText)) {
            System.out.println(testFromCurrencyName + " to " + testToCurrencyName +  " working properly !! \n");
        } else {
            System.out.println(testFromCurrencyName + " to " + testToCurrencyName +  " not working properly !! \n");
        }
		
	}
	
	@Test
	public void Check_Currency_Converter() throws InterruptedException {
		
		
		//click on the Product
		driver.findElement(By.xpath("//*[@id=\"Slide-template--15967084642464__featured_collection-1\"]/div/div/div[3]/div[1]/h3/a")).click();
		
		//clickOnCurrencyMenu();
		
		verifyCurrencyConverter("$USD", "$CAD", "//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[2]", "//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/div[2]/div/div[1]/span[2]/span");
		
		//Thread.sleep(3000);
		
		changeToUSD();
		verifyCurrencyConverter("$USD", "£GBP", "//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[3]", "//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/div[2]/div/div[1]/span[2]/span");
		
		
		changeToUSD();
		verifyCurrencyConverter("$USD", "€EUR", "//*[@id=\"site-header\"]/ul[2]/li[3]/div/ul/li[4]", "//*[@id=\"ProductInfo-template--15967085297824__main\"]/div[1]/div[2]/div/div[1]/span[2]/span");
		
		
		
	}
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(10000); //wait for 10 seconds before quit
		
		driver.close();
		driver.quit();
	}
}
