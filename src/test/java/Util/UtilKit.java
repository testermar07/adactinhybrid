package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilKit {

	private static String resourcesFolder = "/src/test/resources";

	private static Properties configProprties = new Properties();

	public static WebDriver initTest(String project, String application, String inBrowser) {

		WebDriver driver = null;
	
		UtilKit.loadProperties("MasterTestConfig");

		String browser = getConfigProp("BROWSER");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
			
			
		}
		
		driver.get(getConfigProp("COM.ADACTIN.HOTELAPP_URL"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getConfigProp("IMPLICIT_WAIT"))));
		return driver;

	}

	private static String getConfigProp(String browser) {
		// TODO Auto-generated method stub

		return configProprties.getProperty(browser);
	}

	private static void loadProperties(String propFile) {
		// TODO Auto-generated method stub

		FileInputStream configPropFile = null;

		try {
			configPropFile = new FileInputStream(
					System.getProperty("user.dir") + resourcesFolder + "/" + propFile + ".properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			configProprties.load(configPropFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Object[][] getTestData(String project, String application, String testCase) {

		FileInputStream testF = null;
		try {
			testF = new FileInputStream(
					System.getProperty("user.dir") + "/" + resourcesFolder + "/MasterTestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(testF); // Create the Workbook
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet(application);

		// Instantiate the list of XSSF rows
		ArrayList<XSSFRow> caseList = new ArrayList<XSSFRow>();
		// Get the Sheet in the
		// Workbook
		caseList = UtilKit.findRows(sheet, testCase); // finds the list of rows
														// matching
		// the given test case String

		XSSFRow titlesRow = caseList.get(0); // The first row is the column
												// title, It will be ignored.

		// Allocate memory for the Data array. The -1 us used in both dimensions
		// since the column title row itself is not loaded.
		Object[][] testDataArray = new Object[caseList.size() - 1][(titlesRow.getLastCellNum()) - 1];

		// This loop loads each cell into the test Data array
		for (int i = 0; i < (caseList.size() - 1); i++) {
			XSSFRow currRow = caseList.get(i + 1);
			for (int j = 0; j < (currRow.getLastCellNum()) - 1; j++) {
				
				testDataArray[i][j] = currRow.getCell(j + 1).toString();
			}

		}

		try {
			wb.close(); // Close the workbook

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testDataArray;

	}

	private static ArrayList<XSSFRow> findRows(XSSFSheet sheet, String findStr) {
		ArrayList<XSSFRow> rowList = new ArrayList<XSSFRow>();// Will store the
		// list of rows
		// in the given
		// sheet

		/*
		 * TODO - Make the iterator work latter
		 * 
		 * Iterator<Row> rowIterator = sheet.iterator(); while(rowIterator.hasNext()){
		 * XSSFRow currRow = (XSSFRow) rowIterator.next(); uLog('D',"Checking Row : " +
		 * currRow.toString());
		 * if(currRow.getCell(1).getStringCellValue().equalsIgnoreCase(findStr)) {
		 * 
		 * uLog('I', "Loading Row : " + currRow.toString()); rowList.add(currRow); } }
		 */

		/*
		 * Loop thru every row in the sheet and store in the list the ones that match
		 * the findStr
		 */
		for (int i = 0; i < (sheet.getLastRowNum() + 1); i++) {
			XSSFRow currRow = sheet.getRow(i);
			if (currRow != null) {
				
// Look at the first cell/column in each row, if it matches
// findStr
// then add it to the row list
				if (currRow.getCell(0).getStringCellValue().equalsIgnoreCase(findStr)) {
					
					rowList.add(currRow);
				}
			}

		}

		return rowList;
	}

	private static Object[][] getExcelTestData(String application, String testCase) {
		// TODO Auto-generated method stub
		return null;
	}

}
