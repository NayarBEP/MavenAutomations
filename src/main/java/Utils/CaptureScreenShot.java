package Utils;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class CaptureScreenShot {
    public void captureScreenShot(WebDriver driver, String screenShotName){
        try{
            TakesScreenshot ts = (TakesScreenshot)driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.getFileUtils().copyFile( src, new File("./src/main/java/Screenshots/"+screenShotName+".jpg"));
            System.out.println("Screenshot taken");
        }catch(Exception e){
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }
}
