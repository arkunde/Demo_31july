package com.pagefactory;

	import java.time.Duration;
	import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;


	public class PaintStoreFactory {
			
		WebDriver driver;
	    WebDriverWait wait;
		
//1st step identify elements
		
	@FindBy(xpath="//*[@id=\"headerNav\"]/div[1]/ul/li[4]/a[2]/span[1]")
	WebElement stores;

	@FindBy(xpath="//*[@id=\"STORES\"]/div[2]/div/div/div[1]/ul/li[1]/a")
	WebElement paintstores;	

	@FindBy(id="search-input")
	WebElement searchinput;
	
	//a[@class='ctaText position-relative search-by-pin woosmap-search-by-pin']
	//@FindBy(xpath="//*[@id=\"woosmapPincodeForm\"]/a")
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/form/a/span")
	WebElement icon;	

	@FindBy(xpath="//input[@id='trackemailid']")
	WebElement inputemail;

	//@FindBy(xpath="//button[@class='ctaText track_email_subscribe']")
	@FindBy(xpath="//*[@id=\"footerContent\"]/div[1]/div[1]/form/div/button")
	WebElement clicksubs;

	@FindBy(xpath="//*[@id=\"listing-stores-container\"]/div[1]/div/div[2]/div[2]/div/div[1]/span[1]/p")
	WebElement directionicon;	

	//@FindBy(xpath="//*[@id=\"listing-stores-container\"]/div[1]/div/div[2]/div[2]/div/div[1]/span[2]")
	@FindBy(xpath="//p[text()='Share'][1]")
	WebElement shareclick;	

	@FindBy(xpath="//span[text()='SMS'][1]")
	WebElement sms;	

//	//@FindBy(id="shareMobile"
//	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/form/div[1]/input")
//	WebElement enternomber;
	
	@FindBy(xpath="//*[@id='shareMobile']") 
	WebElement mobenter; 
	
	//@FindBy(xpath="//button[text()='SUBMIT'][1]")
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/form/div[2]/button")
	WebElement submit;
//call constructor
	
	public PaintStoreFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
//call method launchapp
	
	public void launchhome() {
		driver.get("https://www.asianpaints.com/");
	}
	public void launchpaint() {
		driver.get("https://www.asianpaints.com/store-locator.html");
	}
	public WebElement logo() {
		return driver.findElement(By.xpath("//img[@title='asian-paint-logo']"));

	}
	
	public void mousestores() {
//		Thread.sleep(3000);
//	    wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
//	    wait.until(ExpectedConditions.elementToBeClickable(stores));
		Actions act = new Actions(driver);
		//act.moveToElement(stores);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.moveToElement(stores).build().perform();
	}

	public void clickpaintstores() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(500));
	    wait.until(ExpectedConditions.elementToBeClickable(paintstores));
		Actions act = new Actions(driver);
		act.click(paintstores).build().perform();
		
		
	}

	public void  paintstores() throws InterruptedException {
	    System.out.println("dropdown displayed");
	}

	
	public void enterpincode() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    wait.until(ExpectedConditions.elementToBeClickable(searchinput));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		searchinput.clear();
		Thread.sleep(3000);
		searchinput.sendKeys("480334");
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    wait.until(ExpectedConditions.elementToBeClickable(searchinput));
		

	}

	public void clickicon() {
		icon.click();
//		Actions act = new Actions(driver);
//		act.moveToElement(icon).build().perform();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0,300)");
	}

	public void adddisplayed() throws InterruptedException {
		Thread.sleep(2000);
		//driver.close();
	}

	
	public void enteremail()  {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0,800)");
	    wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(inputemail));
	    inputemail.sendKeys("abcd@gmail.com");
	    wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(inputemail));
	}

	public void clicksubscription() throws InterruptedException {
		clicksubs.click();
	//    Thread.sleep(1000);
//		Actions act = new Actions(driver);
//		act.click(clicksubs).build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(clicksubs));
	}

	public void msgDisplayed() throws InterruptedException {
//		 String text= driver.switchTo().alert().getText();
	    System.out.println("congratulations you have subscribed.");

	}

	
	public void directionclick() throws InterruptedException {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    wait.until(ExpectedConditions.elementToBeClickable(icon));
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(2000);
//	    Actions act = new Actions(driver);
//	    act.click(directionicon).build().perform();
	    directionicon.click();
	}

	public void redirect() throws InterruptedException{
		Thread.sleep(3000);
		Actions act = new Actions(driver);
											    
		// String parentHandle= driver.getWindowHandle();
		String parentHandle= driver.getWindowHandle();
		for(String handle: driver.getWindowHandles()) {
		if(!handle.equals(parentHandle)) {
		driver.switchTo().window(handle);
		}
		//else driver.close();
		}
	}

	public void navigateback() throws InterruptedException {
		Thread.sleep(3000);
		// Store the handle of the current window
		String currentWindowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		// Iterate through window handles to find the previous window
		for (String handle : windowHandles) {
		    if (!handle.equals(currentWindowHandle)) {
		        // Switch to the previous window
		        driver.switchTo().window(handle);

		        // If needed, switch back to the original window
		        driver.switchTo().window(currentWindowHandle);
		    }
//		    else driver.close();
//		}
		  String currentWindowHandle1 = driver.getWindowHandle();
	      System.out.println("Current Window Handle: " + currentWindowHandle1);
	}
}

	public void shareclick() throws InterruptedException {
						
		//  act.moveToElement(stores).build().perform();
//			paintstores.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(icon));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(shareclick).build().perform();
		//shareclick.click();
	}

	public void smsclick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    wait.until(ExpectedConditions.elementToBeClickable(icon));
//	    Actions act = new Actions(driver);
//	    act.click(sms).build().perform();
	    sms.click();
	}

	public void enternomber(String mobilenomber) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    wait.until(ExpectedConditions.elementToBeClickable(mobenter));
	    mobenter.sendKeys(mobilenomber);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

	}

	public void submitbtn() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	    wait.until(ExpectedConditions.elementToBeClickable(submit));
//		Actions act = new Actions(driver);
//		act.click(submit).build().perform();
		submit.click();
	}
	public void isDisplayed() {

	    System.out.println("Success message is not displayed.");
		}
	}
	
	
	    






