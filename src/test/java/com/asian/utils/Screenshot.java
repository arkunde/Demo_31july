package com.asian.utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Screenshot {

   public static void Capture(WebDriver driver, String service) throws IOException {

       File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(src, new File("./Screenshot/"+timestamp()+"  " + ".png"));



   }



   private static String timestamp() {
       return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
   }



}
