package org.libraries;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CommonLibrary extends FunctionLibrary {
	//RemoteWebDriver driver;
	public static WebDriver driver;

	public CommonLibrary() {
		//setSettingsSheetInfo(getSettingsSheetInfo());

	}

	/*
	 * Get Settings Sheet Information
	 * 
	 * @param return : Settings Sheet Data / Null
	 */
	public HashMap<String, String> getSettingsSheetInfo() {
		HashMap<String, String> settingsSheetData = new HashMap<String, String>();
		try {

			FileInputStream file = new FileInputStream(
					new File(new File(".").getCanonicalPath() + "\\test-data" + "\\Mercury-Settings.xlsx"));
			// Create Workbook instance holding reference to .xlsx file
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet("Settings");
			int noOfRows = sheet.getLastRowNum();
			Row rowWithColumnNames = sheet.getRow(0);
			rowWithColumnNames.getPhysicalNumberOfCells();
			String settingsKey = "";
			String settingsValue = "";

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			for (int m = 0; m <= noOfRows; m++) {
				Row rowCurrent = rowIterator.next();
				if (m <= 0) {
					continue;
				}
				settingsKey = String.valueOf(rowCurrent.getCell(1));
				settingsValue = String.valueOf(rowCurrent.getCell(2));
				settingsSheetData.put(settingsKey, settingsValue);
			}
			file.close();
			setEnv(settingsSheetData.get("ENV_TO_RUN"));
			return settingsSheetData;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/*
	 * Get Test Cases Test Data
	 * 
	 * @param locOfFile : File Location
	 * 
	 * @param return : All Test Cases Data / Null
	 */
	public Map<String, String> getTestCasesTestData(String locOfFile) throws IOException {
		HashMap<String, String> rowData = new HashMap<String, String>();
		locOfFile = new File(".").getCanonicalPath() + "\\test-data\\" + locOfFile;
		try {
			DataFormatter formatter = new DataFormatter();
			FileInputStream file = new FileInputStream(new File(locOfFile));

			// Create Workbook instance holding reference to .xlsx file
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			int noOfRows = sheet.getLastRowNum();
			// System.out.println("no of rows:" + noOfRows);

			Row rowWithColumnNames = sheet.getRow(0);
			int noOfColumns = rowWithColumnNames.getPhysicalNumberOfCells();
			// System.out.println(noOfColumns);
			String testCaseName = "";
			String columnNamesAndValuesOfOneRow = "";

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			// System.out.println(rowIterator

			for (int m = 0; m <= noOfRows; m++) {
				// System.out.println("Iteration number : " + m);
				Row rowCurrent = rowIterator.next();
				if (m == 0) {
					continue;
				}
				testCaseName = String.valueOf(rowCurrent.getCell(0));
				// System.out.println("test case name " + testCaseName);

				for (int p = 0; p < noOfColumns; p++) {
					// formatter.formatCellValue(rowWithColumnNames.getCell(p))=="" &&
					// Igonre the columns without any column name in test case excel file
					if (formatter.formatCellValue(rowWithColumnNames.getCell(p)) == "") {
						continue;
					}
					columnNamesAndValuesOfOneRow = columnNamesAndValuesOfOneRow
							+ formatter.formatCellValue((rowWithColumnNames.getCell(p))).trim() + ":"
							+ formatter.formatCellValue((rowCurrent.getCell(p))).trim() + ";";

				}
				rowData.put(testCaseName, columnNamesAndValuesOfOneRow);
				columnNamesAndValuesOfOneRow = "";

			}
			file.close();

			// Sorting the test case ids which are present in
			// Hashmap(allTestCasesDataBeforeSort)
			Map<String, String> allTestCasesData = new TreeMap<String, String>(rowData);

			// System.out.println("After Sorting:");
			Iterator<?> iterator = allTestCasesData.entrySet().iterator();
			while (iterator.hasNext()) {
				iterator.next();
			}

			return allTestCasesData;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/*
	 * Get Each Test Case Test Data
	 * 
	 * @param ex : Excel Sheet
	 * 
	 * @param sheetName : Excel sheet Name
	 * 
	 * @param currentRowNumber : Excel Sheet Row Number
	 * 
	 * @param testDataFileName : Excel Sheet test Data File Name
	 * 
	 * @param return : each Test Case Data / Null
	 */
	public HashMap<String, String> getTesData(String filePath, String sheetName, String testCaseId) throws IOException {
		int currentRowNumber = 0;
		filePath = new File(".").getCanonicalPath() + "\\test-data\\" + filePath;
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet(sheetName);

		XSSFRow rowWithColumnNames = null;
		rowWithColumnNames = s.getRow(0);
		HashMap<String, String> eachTestCaseData = new HashMap<String, String>();

		for (int i = 0; i < s.getRow(0).getLastCellNum() - 1; i++) {
			if (s.getRow(i).getCell(0).toString().equalsIgnoreCase(testCaseId)) {
				currentRowNumber = i;
				break;
			}
		}

		XSSFRow rowCurrent = null;
		rowCurrent = s.getRow(currentRowNumber);// ExcelSheet.getRow(sheetName, currentRowNumber,filePath);

		for (int p = 0; p < rowWithColumnNames.getLastCellNum(); p++) {
			// Ignore the columns without any column name in test case excel file
			if (formatter.formatCellValue(rowWithColumnNames.getCell(p)) == "") {
				continue;
			}
			String RowValue;
			/*
			 * int CellType=rowCurrent.getCell(p).getCellType(); if(CellType==2){
			 * RowValue=rowCurrent.getCell(p).getRawValue().trim(); } else{
			 * RowValue=formatter.formatCellValue((rowCurrent.getCell(p))).trim(); }
			 */

			RowValue = formatter.formatCellValue((rowCurrent.getCell(p))).trim();

			eachTestCaseData.put(formatter.formatCellValue((rowWithColumnNames.getCell(p))).trim(), RowValue);
			// System.out.println(eachTestCaseData);
		}

		return eachTestCaseData;

	}

	/*
	 * Launch Browser
	 * 
	 * @param url : browsing URL
	 * 
	 * @param desc : Description of the activity
	 * 
	 * @param browserName : NAme of Browser(chrome, mozilla....)
	 */
	public void launchBrowser(String url, String browserName) throws MalformedURLException {
		browserName = "chrome";
		// url
		// ="http://newtours.demoaut.com/mercuryregister.php?osCsid=7417375d30ceb6b3c4f0de5fa6ce5d46";
		// url = settingsSheetInfo.get("URL"+"ENV_TO_RUN");

		System.out.println("kkkkkkkkkkkkkk" + browserName);
		if (browserName.equalsIgnoreCase("firefox")) {
			System.out.println(".\\browserDrivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);

			super.setWdDriver(new FirefoxDriver());
			super.getWdDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} else if (browserName.equalsIgnoreCase("chrome")) {

			WebDriver driver;
			System.out.println(" test m1 grid one");
			String URL = "http://www.DemoQA.com";
			String Node = "http://192.168.43.60:4444/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver",
					"D:\\Material\\Selenium\\softwares\\chromedriver_win32\\chromedriver.exe");

			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\Users\\hp\\git\\mavenGithubJenkins2\\kk\\browserDrivers\\chromedriver.exe"
			 * ); DesiredCapabilities capablities = DesiredCapabilities.chrome();
			 * capablities.setCapability("applicationCacheEnabled", true); ChromeOptions
			 * options = new ChromeOptions(); options.addArguments("--start-maximized");
			 * options.addArguments("--enable-application-cache"); //String
			 * chromeProfilePath = this.settingsSheetInfo.get("CHROME_PROFILE");
			 * //options.addArguments("user-data-dir="+chromeProfilePath);
			 * super.setWdDriver(new ChromeDriver( options));
			 */

			super.getWdDriver().manage().deleteAllCookies();
			super.getWdDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browserName.equalsIgnoreCase("iexplore")) {

			System.setProperty("webdriver.ie.driver", ".\\browserDrivers\\IEDriverServer.exe");
			super.setWdDriver(new InternetExplorerDriver());
			// Get Browser name and version.
			// Get OS name.
		} else {
			System.out.println(super.getWdDriver() + " is not a supported browser");
		}

		/*
		 * // super.getWdDriver().manage().window().maximize(); Capabilities caps =
		 * ((RemoteWebDriver) super.getWdDriver()).getCapabilities(); String
		 * browserName1 = caps.getBrowserName(); String browserVersion =
		 * caps.getVersion();
		 * 
		 * String os = System.getProperty("os.name").toLowerCase();
		 * //System.out.println("operating system: " + os);
		 * super.addStep(super.getTest_Step_Number(),"Test environment: Browser '" +
		 * browserName1 + "' of version '" + browserVersion +
		 * "' on OS '"+os+"'",LogStatus.INFO,false);
		 * //super.getWdDriver().manage().deleteAllCookies();
		 * //super.getWdDriver().get(url); super.getWdDriver().navigate().to(url);
		 */

		// FunctionLibrary.setWaitForObject(new WebDriverWait(this.super.getWdDriver(),
		// 60));

		// this.driver = new RemoteWebDriver(new URL(Node), cap);
		// driver.get(URL);

		System.out.println("ppppppppppppppppp" + driver.getTitle());

	}

	/*
	 * Get String Between Two Strings
	 * 
	 * @Param mainString : Main String
	 * 
	 * @Param beforePartOfRequiredValue : Before Part Of Required Value
	 * 
	 * @Param nextPartOfRequiredValue : Next Part Of Required Value
	 * 
	 * @Param return : Required Part Of String
	 */
	public String getStringBetweenTwoStrings(String mainString, String beforePartOfRequiredValue,
			String nextPartOfRequiredValue) {
		// String x = "Please ensure amount is not less than the minimum replenish
		// amount $6000(SBL-EXL-00151)";
		int startingPosition = mainString.indexOf(beforePartOfRequiredValue);
		int endingPosition = mainString.indexOf(nextPartOfRequiredValue);
		System.out.println();
		System.out.println();
		String requiredPartOfSttring = mainString.substring(startingPosition + beforePartOfRequiredValue.length(),
				endingPosition);
		return requiredPartOfSttring;
	}

	
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		
		
	}
	public void launchApp() {
		this.initDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
		
	}
	
}
