package mooncat_basic_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;



public class Check_Header_and_Footer_Links {

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
	
	
	
	public void HoverToShopByType(String x) {
		
		//Automate the mouse hover and click to the link
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[2]/button"))).build().perform();
        driver.findElement(By.xpath(x)).click();    
		
	}
	
	public void HoverToCollection(String x) {
		
		//Automate the mouse hover and click to the link
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[3]/button"))).build().perform();
        driver.findElement(By.xpath(x)).click();    
		
	}
	
	
	
	
	
	public void VerifyTestCase(String expected_url, String menuName ) {
		
		//Verify Test Case
        String Expected_url_for_whats_new = expected_url;
        String Actual_url_for_whats_new = driver.getCurrentUrl(); 
        
        if(Expected_url_for_whats_new.equals(Actual_url_for_whats_new)) {
        	
        	System.out.println("\n"+ menuName + "->> menu is working fine.\n");
        	
        }
        else {
        	
        	System.out.println("\n"+ menuName + " ^ menu is not working properly !! \n");
        }
        	
		
	}
	
	

	@Test(priority = 1)
	public void CheckHeaderMenu() {
		
			System.out.println("\n--------------------------HEADER SECTION------------------------------------------");
		
		
		 	driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[1]/a")).click();
	        
		 	VerifyTestCase("https://www.mooncat.com/collections/everything", "SHOP ALL");
		 	
		 	
	        
		 	//------------------ Shop By Type Sub-menu ----------------
		 	
		 	HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[1]/ul/li[1]/a");
	        
	        VerifyTestCase("https://www.mooncat.com/collections/whats-new", "SHOP BY TYPE (Whats new)");
	        
	        
	        
	          
	        HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[1]/ul/li[2]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/trending-now", "SHOP BY TYPE (Trending Now)");
					  
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[1]/ul/li[3]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/marie-june", "SHOP BY TYPE (marie-june-rings)");
			
			
			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[1]/ul/li[4]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/summer-faves", "SHOP BY TYPE (summer-faves)");
			
			
			

			//---NAIL LACQUER---//
			
			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[2]/ul/li[1]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/creme", "SHOP BY TYPE (creme)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[2]/ul/li[2]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/creme", "SHOP BY TYPE (creme)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[2]/ul/li[3]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/shimmer", "SHOP BY TYPE (shimmer)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[2]/ul/li[4]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/glitter-flakies", "SHOP BY TYPE (glitter-flakies)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[2]/ul/li[5]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/magnetic", "SHOP BY TYPE (magnetic)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[2]/ul/li[6]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/thermal", "SHOP BY TYPE (thermal)");
			
			
			//----NAIL CARE & MERCH---//

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[3]/ul/li[1]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/top-base-coats", "SHOP BY TYPE (top-base-coats)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[3]/ul/li[2]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/nail-tools", "SHOP BY TYPE (nail-tools)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[2]/ul/li[3]/ul/li[3]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/merch", "SHOP BY TYPE (merch)");
			
			
			//---Collections---//

			HoverToShopByType("//*[@id=\"siteNav\"]/li[3]/ul/li[2]/a");
			
			VerifyTestCase("https://www.mooncat.com/pages/the-powerpuff-girls", "SHOP BY TYPE (the-powerpuff-girls)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[3]/ul/li[3]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/songs-of-sirens", "SHOP BY TYPE (songs-of-sirens)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[3]/ul/li[4]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/seasons-of-persephone", "SHOP BY TYPE (seasons-of-persephone)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[3]/ul/li[5]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/my-inner-apocalypse", "SHOP BY TYPE (my-inner-apocalypse)");
			

			HoverToShopByType("//*[@id=\"siteNav\"]/li[3]/ul/li[6]/a");
			
			VerifyTestCase("https://www.mooncat.com/collections/collection-sets", "SHOP BY TYPE (collection-sets)");
			
			

			
			
			
			//----------------------Collection Sub Menu-----------
			
			
			HoverToCollection("//*[@id=\"siteNav\"]/li[3]/ul/li[7]/ul/li[1]");
			
			VerifyTestCase("https://www.mooncat.com/collections/songs-of-sirens", "COLLECTION (songs-of-sirens)");
			
			
			
			HoverToCollection("//*[@id=\"siteNav\"]/li[3]/ul/li[7]/ul/li[2]");
			
			VerifyTestCase("https://www.mooncat.com/collections/seasons-of-persephone", "COLLECTION (seasons-of-persephone)");
			
			
			
			HoverToCollection("//*[@id=\"siteNav\"]/li[3]/ul/li[7]/ul/li[3]");
			
			VerifyTestCase("https://www.mooncat.com/collections/my-inner-apocalypse", "COLLECTION (my-inner-apocalypse)");
			
		
			HoverToCollection("//*[@id=\"siteNav\"]/li[3]/ul/li[7]/ul/li[4]");
			
			VerifyTestCase("https://www.mooncat.com/collections/midnight-rodeo", "COLLECTION (midnight-rodeo)");
			
		
			
			//----------------- Best Seller Menu -----------------
			
			driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[4]/a")).click();
	        
		 	VerifyTestCase("https://www.mooncat.com/collections/best-sellers", "BEST SELLER ");
		 	
		 	
	
		 	//----------------- LOOKBOOK Menu -----------------
			
			driver.findElement(By.xpath("//*[@id=\"siteNav\"]/li[5]/a")).click();
	        
		 	VerifyTestCase("https://www.mooncat.com/pages/lookbook", "LOOKBOOK ");
		 	
		 	
		 	//----------------- CAT icon --------------
		 	
		 	//Automate the mouse hover and click to the link
	        Actions action = new Actions(driver);
	        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[2]"))).build().perform();
	        driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[2]/div/div/a")).click();
	          
			VerifyTestCase("https://www.mooncat.com/account/login", "CAT icon ");
		 	
		 	
		 	//----------------- Shopping Bag icon -----------------
			
			driver.findElement(By.xpath("//*[@id=\"site-header\"]/ul[2]/li[4]")).click();
	        
		 	VerifyTestCase("https://www.mooncat.com/cart", "Shopping Bag icon ");
		 		
		 				
		}
		
	
	@Test (priority = 2)
	public void CheckFooterMenu() {
		
		System.out.println("\n--------------------------FOOTER SECTION------------------------------------------");
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[1]")).click();
		VerifyTestCase("https://www.mooncat.com/pages/about", "About ");
			
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[2]")).click();
		VerifyTestCase("https://www.mooncat.com/pages/rewards", "Rewards ");
			
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[3]")).click();
		VerifyTestCase("https://www.mooncat.com/pages/contact", "Contact ");
			
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[7]")).click();
		VerifyTestCase("https://www.mooncat.com/pages/terms", "Terms and Privacy ");
			
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[8]")).click();
		VerifyTestCase("https://www.mooncat.com/collections/gift-cards", "Gift Cards ");
			
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-footer\"]/footer/div/div[2]/div[1]/div/div[1]/ul/li[9]")).click();
		VerifyTestCase("https://www.linkedin.com/company/mooncat/", "Careers ");
			
	
		
	}
	
	
	
	@Test(priority = 3)
	public void CheckLandingPageButtons() {
		
		System.out.println("\n--------------------------BUTTONS of Landing Page------------------------------------------");
		
		driver.findElement(By.xpath("//*[@id=\"section__split-hero-slider-template--15967084642464__split_hero_slider\"]/div[2]/div/div[1]/div/a")).click();
		VerifyTestCase("https://www.mooncat.com/collections/whats-new", "SHOP NOW button Hero Section ");
			
		driver.findElement(By.xpath("//*[@id=\"section__about-us-template--15967084642464__about_us\"]/div/a")).click();
		VerifyTestCase("https://www.mooncat.com/pages/about", "OUR STORY button ");
			
		
		driver.findElement(By.xpath("//*[@id=\"section__spotlight-category-template--15967084642464__spotlight_category_block\"]/div/a/div/div/button")).click();
		VerifyTestCase("https://www.mooncat.com/collections/best-sellers", "SHOP NOW<Banner Section>  ");
			
		
		driver.findElement(By.xpath("//*[@id=\"section__split-text-and-image-template--15967084642464__split_text_and_image\"]/div[2]/div/div/div/a")).click();
		VerifyTestCase("https://www.mooncat.com/pages/rewards", "JOIN NOW button ");
			
		
		driver.findElement(By.xpath("//*[@id=\"section__split-text-and-image-template--15967084642464__split_text_and_image\"]/div[1]/a/div/div/button")).click();
		VerifyTestCase("https://www.mooncat.com/collections/everything", "SHOP NOW <Split Banner> ");
		
		
		
		
	}
	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(10000); //wait for 10 seconds before quit
		
		driver.close();
		driver.quit();
	}
}
