package PageObjects;

import ConfigDriver.Driver;
import Utils.CaptureScreenShot;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.*;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.testng.Assert.*;

public class MainTest {

    public static WebDriver driver = null;

    public void setUp(){
        driver = Driver.Chrome();
    }

    public void setUpDown(){
        Boolean result = Driver.Close();
        System.out.println(result);
    }

    @Test
    public void main() {
        setUp();
        driver.get("https://www.google.com/");
        System.out.println("Completed");
        setUpDown();

    }

    @Test(priority = 0)
    public void dataExcelPull() throws IOException {
        File file = new File("/Users/brayanposada/IdeaProjects/TestingActions/src/Docs/UsersData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        String dato1 = sheet.getRow(1).getCell(2).getStringCellValue();
        System.out.println(dato1);
    }

    @Test(priority = 1)
    public void dataExcelPush() throws IOException {
        File file = new File("/Users/brayanposada/IdeaProjects/TestingActions/src/Docs/UsersData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(1);
        if(cell == null)
            cell = row.createCell(1);

        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue("Claudia");
        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos);
        fos.close();

    }

    @Test(priority=2)
    public void VerifyFacebookTitle(){
        File path = new File("/Users/brayanposada/Documents/phantomjs-2.1.1-macosx/bin/phantomjs");
        System.setProperty("phantomjs.binary.path",path.getAbsolutePath());
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        CaptureScreenShot cap = new CaptureScreenShot();
        cap.captureScreenShot(driver, "PhantomJsDriverExample2");
    }

}