package august2022.August2022;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class SeleniumDemo {
    private Properties prop;
    private String filename;
    private int sheetIndex;

    private String firstname, lastname, email, password;

    WebDriver driver = new ChromeDriver();

    // Default constructor
    SeleniumDemo() {
        prop = new Properties();
        filename = "selenium_demo.xlsx";
        sheetIndex = 0;
    }

    public void initProperties() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver.get(prop.getProperty("url"));

        try {
            FileInputStream fis = new FileInputStream(filename);
            XSSFWorkbook wkbk = new XSSFWorkbook(fis);
            XSSFSheet sheet = wkbk.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) { // in this case (one row) write once to class members
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();
                Cell fnCell = cellIterator.next();
                firstname = fnCell.getStringCellValue();
                Cell lnCell = cellIterator.next();
                lastname = lnCell.getStringCellValue();
                Cell eCell = cellIterator.next();
                email = eCell.getStringCellValue();
                Cell pCell = cellIterator.next();
                password = pCell.getStringCellValue();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
