package com.asian.utils;

	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.edge.EdgeOptions;

	
public class SetupDriver {

		public static WebDriver driver;
	    public static WebDriver driver2;
	    public static EdgeOptions options;

	 
		public static WebDriver edgedriver() {

			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
		        driver = new EdgeDriver();
		        //driver.get("https://www.asianpaints.com/");
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		        driver.manage().window().maximize();
		        return driver;
		    }
		public static void teardown() {
			driver.close();
		}

	 

	}
