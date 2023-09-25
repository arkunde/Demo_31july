package Step_Def;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.chrome.ChromeDriver;
import com.asian.utils.Screenshot;
import com.asian.utils.SetupDriver;
import com.pagefactory.PaintStoreFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Stores {
	WebDriver driver= SetupDriver.edgedriver();
	PaintStoreFactory pf;

	
	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		pf=new PaintStoreFactory(driver);
		pf.launchhome();
	}
	@When("user goes to Stores option")
	public void user_goes_to_stores_option() throws InterruptedException, IOException {
		
	    pf.mousestores();
	    Screenshot.Capture(driver, "mouseHover");
	   
	}
	@And("click on the paint stores")
	public void click_on_the_paint_stores() throws InterruptedException {
	   //pf.clickstores();
		pf.clickpaintstores();
	}

	@Then("navigated to the store page sucessfully")
	public void navigated_to_the_store_page_sucessfully() throws InterruptedException {
	   // pf.clickpaintstores();
//		WebElement logoElement = driver.findElement(By.xpath("//img[@title='asian-paint-logo']"));
//	    Assert.assertTrue("Logo is not displayed", logoElement.isDisplayed());              
		WebElement logoElement = pf.logo();
	    Assert.assertTrue("Logo is not displayed", logoElement.isDisplayed());

		
	    driver.close();
	}
//2-------------------------------

	@Given("user is on paint stores page")
	public void user_is_on_paint_stores_page() {
		pf = new PaintStoreFactory(driver);
		pf.launchpaint();
	
	}
	@When("enter the {int}")
	public void enter_the(Integer pincode) throws InterruptedException {
	    pf.enterpincode();

	}
	@And("click on icon")
	public void click_on_icon() {
	    pf.clickicon();
	    
	}
	@Then("user enter sucessfully")
	public void user_enter_sucessfully() throws InterruptedException, IOException {
	   pf.adddisplayed();
	   Thread.sleep(1000);
	   //Screenshot.Capture(driver, "adddetails");
	   WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/div[4]/div/div/div/div[1]/div/div/div/div"));
	   String expectedtext = "address message displayed";
	   String actualtext = element.getText();
	   Assert.assertNotEquals("missmatched", expectedtext, actualtext);
	   
	   Thread.sleep(1000);
	    driver.close();

	}

 //3-------------------------------
    @Given("user is on paint stores page asian")
    public void user_is_on_paint_stores_page_asian() {
		pf = new PaintStoreFactory(driver);
		pf.launchpaint();
	}
	@When("scrolled down and enter the email")
	public void scrolled_down_and_enter_the_email() throws InterruptedException {
	    pf.enteremail();
			
	}
	@And("click on the subscribe")
	public void click_on_the_subscribe() throws InterruptedException, IOException {
	    pf.clicksubscription();
	   //Screenshot.Capture(driver, "msgdisplayed");
	}
	@Then("subscription sucessfull")
	public void subscription_sucessfull() throws InterruptedException, IOException {
	    pf.msgDisplayed();
	    Thread.sleep(2000);
	    Screenshot.Capture(driver, "msgdisplayed");
	    WebElement element=driver.findElement(By.xpath("//p[text()='Congratulations You have subscribed.']"));
	    Assert.assertTrue("Msg is not displayed", element.isDisplayed()); 
	    Thread.sleep(1000);
	    driver.close();
	}
//4-----------------------------

    @Given("user is on paint stores page of asian")
    public void user_is_on_paint_stores_page_of_asian() {
		pf = new PaintStoreFactory(driver);
		pf.launchpaint();
	}
	@When("click on direction icon")
	public void click_on_direction_icon() throws InterruptedException, AWTException {
		pf.directionclick();
	}
	@When("redirect to map page")
	public void redirect_to_map_page() throws  InterruptedException, IOException {
	    pf.redirect();
	    Screenshot.Capture(driver, "MapPage");

	}
	@Then("redirect back to previous page")
	public void redirect_back_to_previous_page() throws InterruptedException {
	   pf.navigateback();
	    String expectedWindow = "91C6457CB0E282DDB6A5FD097B337EF7";
		String actualWindow = driver.getWindowHandle();
		Assert.assertNotEquals("Mismatched", expectedWindow, actualWindow);
	   
		Thread.sleep(1000);
	    driver.close();
	}

//5--------------------------------
	@Given("user is on paint store page")
	public void user_is_on_paint_store_page() {
		pf = new PaintStoreFactory(driver);
		pf.launchpaint();
	}
	@When("user goes to share option")
	public void user_goes_to_share_option() throws InterruptedException {
	    pf.shareclick();
	}
	@And("click on the sms")
	public void click_on_the_sms() {
	    pf.smsclick();
	}
	@And("enter the mobile nomber")
	public void enter_the_mobile_nomber(DataTable mobnum) throws InterruptedException, IOException {
		List<String> cells = mobnum.asList(String.class);
		pf.enternomber(cells.get(0));
		Thread.sleep(1000);
		Screenshot.Capture(driver, "receive the dealer details on SMS");

    }
	@And("click on submit button")
	public void click_on_submit_button() throws InterruptedException {
	    pf.submitbtn();
	}
	@Then("message displayed.")
	public void message_displayed() throws IOException, InterruptedException {
	    pf.isDisplayed();
	    WebElement element=driver.findElement(By.xpath("//*[@id=\"successSMS\"]/span[1]"));
	    String expectedtext = "success message displayed";
		String actualtext = element.getText();
		Assert.assertNotEquals("Mismatched", expectedtext, actualtext);
		
		Thread.sleep(1000);
	    driver.close();
	}
}


