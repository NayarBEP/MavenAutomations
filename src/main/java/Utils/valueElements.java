package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class valueElements {
    public static void FindElements(WebDriver driver){
        Elements elem = new Elements();
        WebElement UserName = driver.findElement(elem.UserName);
        WebElement Name = driver.findElement(elem.Name);
        //WebElement LastName = driver.findElement(elem.LastName);
        WebElement Email = driver.findElement(elem.Email);
        WebElement REmail = driver.findElement(elem.REmail);
        WebElement Pass = driver.findElement(elem.Pass);
        WebElement RPass = driver.findElement(elem.RPass);
        //WebElement BDay = driver.findElement(elem.BDay);
        //WebElement BMonth = driver.findElement(elem.BMonth);
        //WebElement BYear = driver.findElement(elem.BYear);
        WebElement Button = driver.findElement(elem.Button);


        UserName.sendKeys("NayarBEP13342");
        Name.sendKeys("Brayan Estrada Posada");
        Email.sendKeys("brayanestradaposada@gmail.com");
        REmail.sendKeys("brayanestradaposada@gmail.com");
        Pass.sendKeys("3013439323");
        RPass.sendKeys("3013439323");
        Button.click();
    }
}
