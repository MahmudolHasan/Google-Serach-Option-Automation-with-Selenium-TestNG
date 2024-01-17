import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;


public class QuPs {

    By loc_listBox = By.xpath ("//ul[@role='listbox'][1]//li/descendant::div[@class='wM6W7d' and @role='presentation']");

    By loc_searchBox = By.xpath ("//textarea[@name='q' and @type='search']");
    private WebDriver driver;

    @Test
    public void _test_ () throws IOException, InterruptedException {
        String day;
        List<String> suggestions = new ArrayList<> ();
        String filePath = "src/test/resources/Excel.xlsx";

        //Taking Data According to Date
        Workbook workbook = getWorkbook (filePath);
        day = getCurrentDay ();
        Sheet sheet = getSheet (workbook, day);

        // Opening Browser
        driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();
        driver.get ("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (10));
        int _long = sheet.getRow (sheet.getFirstRowNum ()).getFirstCellNum ();
        int _short = _long + 1;


        for (int i = sheet.getFirstRowNum () + 1; i <= sheet.getLastRowNum (); i++) {

            //Finding the Keywords
            Row row = sheet.getRow (i);
            String key = row.getCell (row.getFirstCellNum () + 1).getStringCellValue ();

            //Search in Google with the keyword
            type (loc_searchBox, key);
            Thread.sleep (1000);

            //Finding the longest and shortest option for each keyword
            List<WebElement> options = driver.findElements (loc_listBox);
            for (WebElement ele : options) {
                wait.until (ExpectedConditions.visibilityOf (ele));
                suggestions.add (ele.getText ());
            }
            // // Finding the longest option
            String longest = suggestions.stream ().
                    max (Comparator.comparingInt (String::length)).orElse(null);

            // // Finding the shortest option
            String smallest = suggestions.stream ().
                    min (Comparator.comparingInt (String::length)).orElse(null);

            // // Writing in the Excel File
            Cell cell = row.createCell (_long);
            cell.setCellValue (longest);
            cell = row.createCell (_short);
            cell.setCellValue (smallest);

            // // Clear the suggestions list
            suggestions.clear ();
        }

        FileOutputStream out = new FileOutputStream (filePath);
        workbook.write (out);

        // Close resources
        out.close ();
        driver.close ();
    }

    //Send Input to input field
    private void type (By loc, String input) {
        driver.findElement (loc).clear ();
        driver.findElement (loc).sendKeys (input);
    }

    private Workbook getWorkbook (String path) throws IOException {
        Workbook workbook;
        FileInputStream fileInputStream = new FileInputStream (
                path);
        workbook = WorkbookFactory.create (fileInputStream);
        return workbook;
    }

    private Sheet getSheet (Workbook workbook, String sheetName) {
        Sheet sheet;
        sheet = workbook.getSheet (sheetName);
        return sheet;
    }

    private String getCurrentDay () {
        Calendar calendar = Calendar.getInstance ();
        Date date = calendar.getTime ();
        return (new SimpleDateFormat ("EEEE", Locale.ENGLISH).format (date.getTime ()));
    }


}