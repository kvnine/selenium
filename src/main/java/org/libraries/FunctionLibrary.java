package org.libraries;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({ "unused" })
public class FunctionLibrary {

	private ExtentTest ExtTest_Instance;
	private int Test_Step_Number;
	private String Report_Base_Path;
	private String Report_Suite_Path;
	private String Report_Suite_HTML_Path;
	private String Report_Suite_HTMLs_Path;
	private String Report_Suite_SS_Path;
	private String Report_Suite_SS_F_Path;

	private String SS_Folder = null;
	private Boolean Error_Flag;
	private File objDirecotry;
	private String desc;
	String path;
	private ExtentReports ExtendReport_Instance;

	public ExtentReports getExtendReport_Instance() {
		return ExtendReport_Instance;
	}

	public void setExtendReport_Instance(ExtentReports extendReport_Instance) {
		ExtendReport_Instance = extendReport_Instance;
	}

	public ExtentTest getExtTest_Instance() {
		return ExtTest_Instance;
	}

	public void setExtTest_Instance(ExtentTest extTest_Instance) {
		ExtTest_Instance = extTest_Instance;
	}

	public int getTest_Step_Number() {
		return Test_Step_Number;
	}

	public void setTest_Step_Number(int test_Step_Number) {
		Test_Step_Number = test_Step_Number;
	}

	public String getReport_Base_Path() {
		return Report_Base_Path;
	}

	public void setReport_Base_Path(String report_Base_Path) {
		Report_Base_Path = report_Base_Path;
	}

	public String getReport_Suite_Path() {
		return Report_Suite_Path;
	}

	public void setReport_Suite_Path(String report_Suite_Path) {
		Report_Suite_Path = report_Suite_Path;
	}

	public String getReport_Suite_HTML_Path() {
		return Report_Suite_HTML_Path;
	}

	public void setReport_Suite_HTML_Path(String report_Suite_HTML_Path) {
		Report_Suite_HTML_Path = report_Suite_HTML_Path;
	}

	public String getReport_Suite_HTMLs_Path() {
		return Report_Suite_HTMLs_Path;
	}

	public void setReport_Suite_HTMLs_Path(String report_Suite_HTMLs_Path) {
		Report_Suite_HTMLs_Path = report_Suite_HTMLs_Path;
	}

	public String getReport_Suite_SS_Path() {
		return Report_Suite_SS_Path;
	}

	public void setReport_Suite_SS_Path(String report_Suite_SS_Path) {
		Report_Suite_SS_Path = report_Suite_SS_Path;
	}

	public String getReport_Suite_SS_F_Path() {
		return Report_Suite_SS_F_Path;
	}

	public void setReport_Suite_SS_F_Path(String report_Suite_SS_F_Path) {
		Report_Suite_SS_F_Path = report_Suite_SS_F_Path;
	}

	public String getSS_Folder() {
		return SS_Folder;
	}

	public void setSS_Folder(String sS_Folder) {
		SS_Folder = sS_Folder;
	}

	private WebElement Browser_Element;
	private List<WebElement> Browser_Elements;
	private List<WebElement> Browser_Elements_For_Div;
	private Actions Element_Action;

	private WebDriverWait Wait_For_Ajax;
	private File Screen_Shot;
	private String browser = "firefox";
	static FunctionLibrary Function_Library_Instance;

	public WebElement getBrowser_Element() {
		return Browser_Element;
	}

	public void setBrowser_Element(WebElement browser_Element) {
		Browser_Element = browser_Element;
	}

	public List<WebElement> getBrowser_Elements() {
		return Browser_Elements;
	}

	public void setBrowser_Elements(List<WebElement> browser_Elements) {
		Browser_Elements = browser_Elements;
	}

	public List<WebElement> getBrowser_Elements_For_Div() {
		return Browser_Elements_For_Div;
	}

	public void setBrowser_Elements_For_Div(List<WebElement> browser_Elements_For_Div) {
		Browser_Elements_For_Div = browser_Elements_For_Div;
	}

	public Actions getElement_Action() {
		return Element_Action;
	}

	public void setElement_Action(Actions element_Action) {
		Element_Action = element_Action;
	}

	public WebDriverWait getWaitForObject() {
		return waitForObject;
	}

	public void setWaitForObject(WebDriverWait waitForObject) {
		this.waitForObject = waitForObject;
	}

	public WebDriverWait getWait_For_Ajax() {
		return Wait_For_Ajax;
	}

	public void setWait_For_Ajax(WebDriverWait wait_For_Ajax) {
		Wait_For_Ajax = wait_For_Ajax;
	}

	public File getScreen_Shot() {
		return Screen_Shot;
	}

	public void setScreen_Shot(File screen_Shot) {
		Screen_Shot = screen_Shot;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	private String newBrowser = "";
	private String oldBrowser = "";
	private String LoginMessage = "";
	private String stringHelperToGenerateUniquePlateNumberStartingLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Random rand = new Random();
	private Set<String> identifiers = new HashSet<String>();
	private HashMap<String, String> settingsSheetInfo;
	private String env;
	private HashMap<String, String> dataObj;
	private HashMap<String, String> dataObj1;

	private String previousTestCaseBrowser;
	private String sblLoginStatus = "NotSuccess";
	private String sblLogoutStatus;
	private boolean isClosedAllBrowsers = true;
	private String testDataFileName = "";
	private String testDataSheetName = "";
	private String testExecutionReportName = "FLCSS_SWUNT_AutomatedTestReport";
	private String[] Devicereqs = new String[500];
	private int DeviceArrayIndex = 0;
	private CommonLibrary commonInstance;
	private WebDriver wdDriver;

	private WebDriverWait wait;
	private WebDriverWait waitForObject;

	public String getNewBrowser() {
		return newBrowser;
	}

	public void setNewBrowser(String newBrowser) {
		this.newBrowser = newBrowser;
	}

	public String getOldBrowser() {
		return oldBrowser;
	}

	public void setOldBrowser(String oldBrowser) {
		this.oldBrowser = oldBrowser;
	}

	public String getLoginMessage() {
		return LoginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		LoginMessage = loginMessage;
	}

	public String getStringHelperToGenerateUniquePlateNumberStartingLetters() {
		return stringHelperToGenerateUniquePlateNumberStartingLetters;
	}

	public void setStringHelperToGenerateUniquePlateNumberStartingLetters(
			String stringHelperToGenerateUniquePlateNumberStartingLetters) {
		this.stringHelperToGenerateUniquePlateNumberStartingLetters = stringHelperToGenerateUniquePlateNumberStartingLetters;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public Set<String> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(Set<String> identifiers) {
		this.identifiers = identifiers;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public HashMap<String, String> getDataObj() {
		return dataObj;
	}

	public void setDataObj(HashMap<String, String> dataObj) {
		this.dataObj = dataObj;
	}

	public HashMap<String, String> getDataObj1() {
		return dataObj1;
	}

	public void setDataObj1(HashMap<String, String> dataObj1) {
		this.dataObj1 = dataObj1;
	}

	public String getPreviousTestCaseBrowser() {
		return previousTestCaseBrowser;
	}

	public void setPreviousTestCaseBrowser(String previousTestCaseBrowser) {
		this.previousTestCaseBrowser = previousTestCaseBrowser;
	}

	public String getSblLoginStatus() {
		return sblLoginStatus;
	}

	public void setSblLoginStatus(String sblLoginStatus) {
		this.sblLoginStatus = sblLoginStatus;
	}

	public String getSblLogoutStatus() {
		return sblLogoutStatus;
	}

	public void setSblLogoutStatus(String sblLogoutStatus) {
		this.sblLogoutStatus = sblLogoutStatus;
	}

	public boolean isClosedAllBrowsers() {
		return isClosedAllBrowsers;
	}

	public void setClosedAllBrowsers(boolean isClosedAllBrowsers) {
		this.isClosedAllBrowsers = isClosedAllBrowsers;
	}

	public String getTestDataFileName() {
		return testDataFileName;
	}

	public void setTestDataFileName(String testDataFileName) {
		this.testDataFileName = testDataFileName;
	}

	public String getTestDataSheetName() {
		return testDataSheetName;
	}

	public void setTestDataSheetName(String testDataSheetName) {
		this.testDataSheetName = testDataSheetName;
	}

	public String getTestExecutionReportName() {
		return testExecutionReportName;
	}

	public void setTestExecutionReportName(String testExecutionReportName) {
		this.testExecutionReportName = testExecutionReportName;
	}

	public String[] getDevicereqs() {
		return Devicereqs;
	}

	public void setDevicereqs(String[] devicereqs) {
		Devicereqs = devicereqs;
	}

	public int getDeviceArrayIndex() {
		return DeviceArrayIndex;
	}

	public void setDeviceArrayIndex(int deviceArrayIndex) {
		DeviceArrayIndex = deviceArrayIndex;
	}

	public CommonLibrary getCommonInstance() {
		return commonInstance;
	}

	public void setCommonInstance(CommonLibrary commonInstance) {
		this.commonInstance = commonInstance;
	}

	public synchronized WebDriver getWdDriver() {
		return wdDriver;
	}

	public synchronized void setWdDriver(WebDriver wdDriver) {
		this.wdDriver = wdDriver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	public void setSettingsSheetInfo(HashMap<String, String> settingsSheetInfo) {
		this.settingsSheetInfo = settingsSheetInfo;
	}

	public FunctionLibrary() {

	}

	/*
	 * Get the web element
	 * 
	 * @param Str_Property : Identify the web element by using this property of the
	 * object
	 * 
	 * @return web element
	 */
	public WebElement getElement(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		setBrowser_Element(waitForElementIsReady(driver, xpath));
		return getBrowser_Element();
	}

	/*
	 * Get the web element
	 * 
	 * @param Str_Property : Identify the web element by using this property of the
	 * object
	 * 
	 * @return web element
	 */
	public WebElement waitForElementIsReady(WebDriver driver, String xpath) {
		// this.setWaitForObject(new WebDriverWait(this.getWdDriver(), 60));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebDriverWait wait1 = new WebDriverWait(driver, 5);

		int i;
		WebElement element = driver.findElement(By.xpath(xpath));
		for (i = 0; i <= 12; i++) {

			try {
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

				if (element.isEnabled()) {
					break;
				} else {
					return element;
				}

			}

			catch (InvalidElementStateException e1) {
				System.out.println("Invalid element state exception got it  for object" + ".Giving another try");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (StaleElementReferenceException e1) {

				System.out.println("Stale element exception got it  for object: " + ".Giving another try");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// this.getWdDriver().navigate().refresh();
			} catch (WebDriverException e2) {
				System.out.println("WebDriver exception got it  for object: " + ".Giving another try");
			}

		}

		// Wait_For_Div();
		return element;
	}

	public void quitBrowser() {
		this.getWdDriver().quit();
	}

	/*
	 * Make flag Error_Flag to true
	 */
	public void Exception_Content() {
		setBrowser_Element(null);
		// Function_Library.Close_All_Active_Browser();
		// Report_Library.End_Test();
	}

	/*
	 * Set text in text box
	 * 
	 * @param Str_Property : Identify the web element by using this property of the
	 * object
	 * 
	 * @param Text_Val : Pass the value to the text box
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @return web element
	 */
	public void setText(WebDriver driver, String xpath, String Text_Val, String Desc) {
		if (waitForElementIsReady(driver, xpath) == null) {
			this.addStep(this.getTest_Step_Number(), Desc + ": " + Text_Val, LogStatus.FAIL, true);
			Exception_Content();
		} else {
			try {
				WebElement element = driver.findElement(By.xpath(xpath));
				if (!element.getAttribute("value").startsWith(Text_Val)) {
					// element.clear();
					element.sendKeys(Text_Val);
					element.sendKeys(Keys.TAB);
					this.addStep(this.getTest_Step_Number(), Desc + ": " + Text_Val, LogStatus.INFO, false);
				} else {
					element.sendKeys(Keys.TAB);
				}

			} catch (InvalidElementStateException ee) {
				ee.printStackTrace();
				Exception_Content();
			}
		}

	}

	/*
	 * Get text from text box
	 * 
	 * @param Text_Property : Identify the web element by using this property of the
	 * object
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @return : Text box value will be return as String
	 */
	public String getText(WebDriver driver, String xpath, String Desc) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String Text_Val = null;
		if (element == null) {
			if (Desc != "") {
				this.addStep(this.getTest_Step_Number(), Desc, LogStatus.FAIL, true);
				Exception_Content();
			}
		} else {
			Text_Val = element.getAttribute("value");

		}

		return Text_Val;
	}

	/*
	 * Verify the Text Box Value
	 * 
	 * @param Text_Property : Identify the web element by using this property of the
	 * object
	 * 
	 * @param Expected_Value : get the value from given text box
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @param screenShot : Screenshot required(Yes or No)
	 */

	public void verifyTextBoxValue(WebDriver driver, String xpath, String Expected_Value, String Desc,
			boolean screenShot) {
		WebElement element = driver.findElement(By.xpath(xpath));

		if (element == null) {
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc , LogStatus.FAIL,
				// true);Exception_Content();
			}
		} else {

			String Actual_Text_Val = element.getAttribute("value");
			if (Actual_Text_Val.equalsIgnoreCase(Expected_Value)) {
				if (Desc != "") {
					this.addStep(this.getTest_Step_Number(),
							Desc + ": Actual Value :" + Actual_Text_Val + ", Expected Value : " + Expected_Value,
							LogStatus.PASS, screenShot);
				}
			} else {
				if (Desc != "") {
					this.addStep(this.getTest_Step_Number(),
							Desc + ": Actual Value :" + Actual_Text_Val + ", Expected Value : " + Expected_Value,
							LogStatus.FAIL, true);
					Exception_Content();
				}
			}

		}
		// }
	}

	/*
	 * Verify the Text Box Value
	 * 
	 * @param Text_Property : Identify the web element by using this property of the
	 * object
	 * 
	 * @param Expected_Value : get the value from given text box and replace empty
	 * space with $ symbol
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @param screenShot : Screenshot required(Yes or No)
	 */
	public void verifyTextBoxValueWithDollars(WebDriver driver, String xpath, String Expected_Value, String Desc,
			boolean screenShot) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element == null) {
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc , LogStatus.FAIL,
				// true);Exception_Content();
			}
		} else {

			String Actual_Text_Val = element.getAttribute("value");
			Expected_Value = Expected_Value.replace("$", "").replace(",", "");
			Actual_Text_Val = Actual_Text_Val.replace("$", "").replace(",", "").replace("(", "").replace(")", "");
			if (Double.valueOf(Actual_Text_Val).equals(Double.valueOf(Expected_Value))) {
				if (Desc != "") {
					this.addStep(this.getTest_Step_Number(),
							Desc + ": Actual Value :" + Actual_Text_Val + ", Expected Value : " + Expected_Value,
							LogStatus.PASS, screenShot);
				}
			} else {
				if (Desc != "") {
					this.addStep(this.getTest_Step_Number(),
							Desc + ": Actual Value :" + Actual_Text_Val + ", Expected Value : " + Expected_Value,
							LogStatus.FAIL, true);
					Exception_Content();
				}
			}

		}
		// }
	}

	/*
	 * Select the dropdown value
	 * 
	 * @param DropDownList_Property : Identify the web element by using this
	 * property of the object
	 * 
	 * @param DropDownList_Val : value which has to select in dropdown
	 * 
	 * @param Desc : Description of the activity
	 */
	public void selectDropDownList(WebDriver driver, String xpath, String DropDownList_Val, String Desc) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element == null) {
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc +":
				// "+DropDownList_Val, LogStatus.FAIL, true);Exception_Content();
			}
		} else {
			Select DropDownList = new Select(element);
			DropDownList.selectByVisibleText(DropDownList_Val);
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc+":
				// "+DropDownList_Val, LogStatus.PASS, false);
			}
		}
		// }
	}

	/*
	 * Select the dropdown value
	 * 
	 * @param DropDownList_Property : Identify the web element by using this
	 * property of the object
	 * 
	 * @param DropDownList_Val : value which has to select in dropdown
	 * 
	 * @param Desc : Description of the activity
	 */
	public void selectDropDownListByValue(WebDriver driver, String xpath, String DropDownList_Val, String Desc) {
		WebElement element = driver.findElement(By.xpath(xpath));

		if (element == null) {
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc +":
				// "+DropDownList_Val, LogStatus.FAIL, true);Exception_Content();
			}
		} else {
			Select DropDownList = new Select(element);
			DropDownList.selectByValue(DropDownList_Val);
			// Ajax_Wait();
			// waitForAjax(1500);
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc+":
				// "+DropDownList_Val, LogStatus.PASS, false);
			}
		}
		// }
	}

	/*
	 * Select the dropdown value
	 * 
	 * @param DropDownList_Property : Identify the web element by using this
	 * property of the object
	 * 
	 * @param DropDownList_Option_Index :Index which has to select in dropdown
	 * 
	 * @param Desc : Description of the activity
	 */
	public void selectDropDownListByIndex(WebDriver driver, String xpath, String DropDownList_Option_Index, String Desc)
			throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element == null) {
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc +":
				// "+DropDownList_Option_Index, LogStatus.FAIL, true);Exception_Content();
			}
		} else {
			Select DropDownList = new Select(element);
			DropDownList.selectByIndex(Integer.parseInt(DropDownList_Option_Index));
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc+":
				// "+DropDownList_Option_Index, LogStatus.PASS, false);
			}
		}
		// }
	}

	/*
	 * Verify the dropdown value
	 * 
	 * @param DropDownList_Property : Identify the web element by using this
	 * property of the object
	 * 
	 * @param Expected_Option : value which has to check in dropdown
	 * 
	 * @param Desc : Description of the activity
	 */
	public void verifyDropDownListSelectedOption(WebDriver driver, String xpath, String Expected_Option, String Desc)
			throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));

		String Actual_Option;

		if (element == null) {
			// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc +":
			// "+Expected_Option, LogStatus.FAIL, true);Exception_Content();
		} else {
			Select DropDownList = new Select(element);
			Actual_Option = DropDownList.getFirstSelectedOption().getText();
			if (Actual_Option.equalsIgnoreCase(Expected_Option)) {
				if (Desc != "") {
					// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc+": Expected
					// Option:"+Expected_Option+", Actual Option: "+Actual_Option, LogStatus.PASS,
					// true);
				}
			} else {
				if (Desc != "") {
					// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc+": Expected
					// Option:"+Expected_Option+", Actual Option: "+Actual_Option, LogStatus.FAIL,
					// true);Exception_Content();
				}
			}
		}
		// }
	}

	/*
	 * Verify the dropdown value
	 * 
	 * @param DropDownList_Property : Identify the web element by using this
	 * property of the object
	 * 
	 * @param Expected_Option : value which has to check in dropdown
	 * 
	 * @param Desc : Description of the activity
	 */
	public void verifyDropDownListOptionsNotExist(WebDriver driver, String xpath, String Expected_Options, String Desc)
			throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (!Expected_Options.matches("NA")) {
			// Thread.sleep(500);
			String Final_OutPut = "";
			List<WebElement> Actual_Option_List;
			String[] Expected_Option_List;

			if (element == null) {
				if (Desc != "") {
					// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc +":
					// "+Expected_Options, LogStatus.FAIL, true);Exception_Content();
				}
			} else {
				Select DropDownList = new Select(element);
				Actual_Option_List = DropDownList.getOptions();
				Expected_Option_List = Expected_Options.split(";");
				int i;
				int j;
				int Exist;
				for (i = 0; i < Expected_Option_List.length; i++) {
					Exist = 0;
					for (j = 0; j < Actual_Option_List.size(); j++) {
						if (Expected_Option_List[i].toString().equalsIgnoreCase(Actual_Option_List.get(j).getText())) {
							Exist = Exist + 1;
							break;
						}
					}
					if (Exist > 0) {
						Final_OutPut = Final_OutPut + Expected_Option_List[i].toString();
					}

				}
				if (Final_OutPut.contains("")) {
					if (Desc != "") {
						this.addStep(this.getTest_Step_Number(),
								Desc + ": Expected Option " + Expected_Options + " is not present. " + Final_OutPut,
								LogStatus.PASS, true);
					}
				} else {
					if (Desc != "") {
						this.addStep(this.getTest_Step_Number(),
								Desc + ": Expected Option " + Expected_Options + "is  present" + Final_OutPut,
								LogStatus.FAIL, true);
						Exception_Content();
					}
				}
			}
		}
	}

	/*
	 * select the check box
	 * 
	 * @param CheckBox_Pro : Identify the web element by using this property of the
	 * object
	 * 
	 * @param CheckBox_Val : check box value(yes or no)
	 * 
	 * @param Desc : Description of the activity
	 */

	public void setCheckBox(WebDriver driver, String xpath, String CheckBox_Val, String Desc) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (!CheckBox_Val.toString().matches("NA")) {
			String IsChecked;

			getWaitForObject().until(ExpectedConditions.visibilityOf(element));
			getWaitForObject().until(ExpectedConditions.elementToBeClickable(element));
			if (element == null) {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc, LogStatus.FAIL,
				// true);Exception_Content();
			} else {
				IsChecked = element.getAttribute("value");
				if (CheckBox_Val.equals("Yes")) {

					if (IsChecked != "true") {
						element.click();
					}
				} else if (CheckBox_Val.matches("No")) {
					if (IsChecked != "true") {
						//// Element_Action.click(CheckBox).build().perform();
						element.click();
					}
				}

				else if (CheckBox_Val.matches("Yes")) {
					if (IsChecked == null) {
						element.click();
					}
				}

			}
		}
	}

	/*
	 * Click on object
	 * 
	 * @param Object_Name_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param Event : event to click on selected object
	 * 
	 * @param Desc : Description of the activity
	 */

	public void clickObject(WebDriver driver, String xpath, String Event, String Desc) {
		WebElement element = driver.findElement(By.xpath(xpath));
		getWaitForObject().until(ExpectedConditions.visibilityOf(element));
		getWaitForObject().until(ExpectedConditions.elementToBeClickable(element));
		try {
			if (element == null) {
				if (Desc != "") {
					this.addStep(this.getTest_Step_Number(), Desc, LogStatus.FAIL, true);
					// Exception_Content();
				}
			} else {
				highLightElement(getWdDriver(), element);

				try {
					element.click();
				} catch (WebDriverException e) {

					new Actions(this.getWdDriver()).moveToElement(element).perform();
					new Actions(this.getWdDriver()).click().perform();

				}
				if (Desc != "") {
					// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc, LogStatus.PASS,
					// false);
				}
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {

			if (element == null) {
				if (Desc != "") {
					this.addStep(this.getTest_Step_Number(), "Expected:" + Desc, LogStatus.FAIL, true);
					// Exception_Content();
				}
			} else {
				element.click();
				// Wait_For_Div();
				if (Desc != "") {
					// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc, LogStatus.PASS,
					// false);
				}
			}
		}

		// }
	}

	/*
	 * Double Click on object
	 * 
	 * @param Object_Name_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param Event : event to Double click on selected object
	 * 
	 * @param Desc : Description of the activity
	 */
	public void DblclickObject(WebDriver driver, String xpath, String Event, String Desc) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		/*
		 * if(!Event.matches("NA")) {
		 */
		/*
		 * WebElement Object = null; Object = getElement(Object_Name_Pro);
		 */
		if (element == null) {
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc, LogStatus.FAIL,
				// true);Exception_Content();
			}
		} else {
			getElement_Action().doubleClick(element).build().perform();
			if (Desc != "") {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc, LogStatus.PASS,
				// false);
			}
		}
		// }
	}

	/*
	 * Capture a screenshot
	 * 
	 * @param ScreenShot_Location : selecting location to store screenShot
	 * 
	 * @return location
	 */
	public String captureScreenShot(String ScreenShot_Location) {
		setScreen_Shot(((TakesScreenshot) getWdDriver()).getScreenshotAs(OutputType.FILE));
		getScreen_Shot().renameTo(new File(ScreenShot_Location));

		return ScreenShot_Location;
	}

	/*
	 * get time stamp
	 * 
	 * @return time stamp
	 */
	public String getTimeStamp() {
		Long l = Calendar.getInstance().getTimeInMillis();
		return l.toString();
	}

	/*
	 * get Row Count
	 * 
	 * @return number of rows in selected table
	 */
	public int getWebTableRowCount(WebElement Table_Element) throws Exception {
		return Table_Element.findElements(By.tagName("tr")).size();
	}

	/*
	 * get Column Count
	 * 
	 * @return number of Columns in selected table
	 */
	public int getWebTableColumnCount(WebElement Table_Element) throws Exception {
		return Table_Element.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td")).size();
	}

	/*
	 * verify Web Table Data Not Exist
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param ExpectedText : text which has to verify in a table
	 * 
	 * @param Desc : Description of the activity
	 */
	@SuppressWarnings("null")
	public void verifyWebTableDataNotExist(WebDriver driver, String xpath, String ExpectedText, String Desc)
			throws Exception {
		if (!ExpectedText.matches("NA")) {
			int Row;
			int Column;
			int iterate;
			int iterate1;
			Boolean ExistFlg = false;
			WebElement Element = null;
			// Element = getElement(WebElement_Pro);
			Row = Element.findElements(By.tagName("tr")).size();
			Column = Element.findElements(By.tagName("th")).size();// Element.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td")).size();
			for (iterate = 0; iterate < Row; iterate++) {
				for (iterate1 = 0; iterate1 < Column; iterate1++) {
					if (ExpectedText.equalsIgnoreCase(Element.findElements(By.tagName("td")).get(iterate1).getText())) {
						highLightElement(getWdDriver(), Element.findElements(By.tagName("td")).get(iterate1));
						ExistFlg = true;
						break;
					}
				}
				if (ExistFlg) {
					break;
				}
			}

			if (!ExistFlg) {
				if (Desc != "") {
					// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc + " : "+
					// ExpectedText, LogStatus.PASS, true);
				}
			} else {
				if (Desc != "") {
					// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc + " : "+
					// ExpectedText, LogStatus.FAIL, true);Exception_Content();
				}
			}
		}
	}

	/*
	 * verify Web Element
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @return true/false
	 */
	public boolean verifyWebElementExist(WebDriver driver, String xpath, String Desc) {
		WebElement element = driver.findElement(By.xpath(xpath));
		boolean isExist = false;

		// Thread.sleep(1000);
		List<WebElement> Elements = null;
		WebElement Element = null;
		// String Actual_Property = element.substring(6);
		if (waitForElementIsReady(driver, xpath) == null) {
			if (Desc != "") {

				this.addStep(this.getTest_Step_Number(), Desc + "Elememnt is not present: " + element, LogStatus.FAIL,
						true);
				// Exception_Content();
			}
		} else {
			if (waitForElementIsReady(driver, xpath).isDisplayed()) {
				isExist = true;
				// this.addStep(this.getTest_Step_Number(), Desc+"Element : "+WebElement_Pro,
				// LogStatus.PASS, true);
			}
		}

		// }
		return isExist;
	}

	/*
	 * verify Web Element
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param Event: get event to be perform(Enable/disable)
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @return true/false
	 */
	public boolean verifWebElementEnabled(WebDriver driver, String xpath, String Event, String Desc) {
		if (!Event.matches("NA")) {
			try {
				Thread.sleep(500);

			} catch (Exception e) {

			}

			// Wait_For_Div();
			WebElement Element = null;
			// Element = getElement(WebElement_Pro);
			if (Element == null) {
				if (Desc != "") {
					//// ReportLibrary.Add_Step(//ReportLibrary.Test_Step_Number, Desc,
					//// LogStatus.FAIL, true);Exception_Content();
				}
			} else {
				if (Element.isEnabled()) {
					if (Desc != "") {
						return true;
						//// ReportLibrary.Add_Step(//ReportLibrary.Test_Step_Number, Desc,
						//// LogStatus.PASS, true);
					}
				} else {
					if (Desc != "") {
						return true;
						//// ReportLibrary.Add_Step(//ReportLibrary.Test_Step_Number, Desc,
						//// LogStatus.FAIL, true);Exception_Content();
					}
				}
			}
		}
		return false;
	}

	/*
	 * High-Light Element
	 * 
	 * @param driver : slected driver details
	 * 
	 * @param element : Identify the web element by using this property of the
	 * object
	 */
	public void highLightElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					element);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// ConfigurationLibrary.Sound_Beep();
				System.out.println(e.getMessage());
			}

			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
		} catch (WebDriverException e) {
			// ConfigurationLibrary.Sound_Beep();
		}
	}

	/*
	 * Click Web Table Data
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param ExpectedText: get text to perform event
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @return true/false
	 */
	@SuppressWarnings("null")
	public void clickWebTableData(WebDriver driver, String xpath, String ExpectedText, String Desc) throws Exception {
		if (!ExpectedText.matches("NA")) {
			int Row;
			int Column;
			int iterate;
			int iterate1;
			WebElement Element = null;
			WebElement Actual_Element = null;
			// Element = getElement(WebElement_Pro);
			List<WebElement> element2 = Element.findElements(By.tagName("tr"));
			Row = element2.size();
			System.out.println(Row);
			// Row = Element.findElements(By.tagName("tr")).size();
			Column = Element.findElements(By.tagName("td")).size();
			System.out.println(Row);
			// Element.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td")).size();
			/*
			 * List<WebElement> rows=Element.findElements(By.tagName("tr"));
			 * 
			 * for(int rnum=0;rnum<rows.size();rnum++) { List<WebElement>
			 * columns=rows.get(rnum).findElements(By.tagName("td"));
			 * System.out.println("Number of columns:"+columns.size()); for(int
			 * cnum=0;cnum<columns.size();cnum++) {
			 * System.out.println(columns.get(cnum).getText()); } }
			 */

			for (iterate = 0; iterate < Row; iterate++) {
				for (iterate1 = 0; iterate1 < Column; iterate1++) {
					Actual_Element = Element.findElements(By.tagName("td")).get(iterate1);
					if (Actual_Element.isEnabled()) {
						if (ExpectedText
								.equalsIgnoreCase(Element.findElements(By.tagName("td")).get(iterate1).getText())) {
							highLightElement(getWdDriver(), Element.findElements(By.tagName("td")).get(iterate1));

							Actual_Element.click();
							break;
						}
					}
				}
			}
			Thread.sleep(2000);
		}
	}

	/*
	 * Scroll Down
	 * 
	 * @param element : Identify the web element by using this property of the
	 * object
	 * 
	 * @param Desc : Description of the activity
	 */
	public void scrollDown(String Event, String Desc) {
		if (!Event.matches("NA")) {
			((JavascriptExecutor) getWdDriver()).executeScript("scroll(0,250);");
		}

	}

	/*
	 * Scroll Up
	 * 
	 * @param element : Identify the web element by using this property of the
	 * object
	 * 
	 * @param Desc : Description of the activity
	 */
	public void scrollUp(String Event, String Desc) {
		if (!Event.matches("NA")) {
			JavascriptExecutor JsE = (JavascriptExecutor) getWdDriver();
			JsE.executeScript("window.scrollBy(0,-250)", "");
		}
	}

	/*
	 * get Row Count
	 * 
	 * @param Table_Element : Identify the web element by using this property of the
	 * object
	 * 
	 * @Param Event:
	 * 
	 * @return number of rows in selected table
	 */
	public int getWebTableRowCount(WebDriver driver, String xpath, String Event, String Webtablename) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		int row_cnt = 0;
		if (!Event.matches("NA")) {
			// WebElement Element = getElement(Table_Element);
			row_cnt = element.findElements(By.tagName("tr")).size();
			if (row_cnt > 0) {
				// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, "the row count for the
				// webtable "+ Webtablename + " is : "+ row_cnt, LogStatus.PASS, true);
			}

		}
		return row_cnt;
	}

	/*
	 * Scroll Down
	 * 
	 * @param Text_Property : Identify the web element by using this property of the
	 * object
	 * 
	 * @param Desc : Description of the activity
	 */
	public void scrollDowntoElement(WebDriver driver, String xpath, String Desc) throws InterruptedException {
		WebElement elemnt = waitForElementIsReady(driver, xpath);
		((JavascriptExecutor) this.getWdDriver()).executeScript("arguments[0].scrollIntoView(true);", elemnt);

	}

	/*
	 * Scroll Up
	 * 
	 * @param Text_Property : Identify the web element by using this property of the
	 * object
	 * 
	 * @param Desc : Description of the activity
	 */
	public void scrollUptoElement(WebDriver driver, String xpath, String Desc) throws InterruptedException {
		WebElement elemnt = waitForElementIsReady(driver, xpath);
		((JavascriptExecutor) this.getWdDriver()).executeScript("arguments[0].scrollIntoView(false);", elemnt);

	}

	// Forming 5 digit random number and returning same
	public int randomNumberWithFiveDigit() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	/*
	 * Get web Cell Data
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param rowNumber : Row number where has to get data
	 * 
	 * @param columnNumber : Column number where has to get data
	 * 
	 * @param Desc : Description of the activity
	 */
	public String getWebTableCellData(WebDriver driver, String xpath, int rowNumber, int columnNumber, String Desc) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String cellValue = "";
		Boolean verifyStatus = false;

		WebElement rowElement = null;
		WebElement actualCellElement = null;
		// String text = repalceStrings(ExpectedText);
		// WebElement //Element = getElement(WebElement_Pro);
		rowElement = element.findElements(By.tagName("tr")).get(rowNumber);
		actualCellElement = rowElement.findElements(By.tagName("td")).get(columnNumber);

		if (actualCellElement != null) {

			// highLightElement(getWdDriver(),actualCellElement);
			cellValue = actualCellElement.getText();

			/*
			 * ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc + " : "+
			 * ExpectedText + ".<br>" +"Actual is: " +actualCellElement.getText(),
			 * LogStatus.PASS, true);
			 */

		} else {
			this.addStep(this.getTest_Step_Number(), "Web table cell is not found with row " + "number " + rowNumber
					+ " and column number " + columnNumber, LogStatus.FAIL, true);
		}

		// }

		return cellValue;

	}

	/*
	 * verify web Cell Data
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param rowNumber : Row number where has to get data
	 * 
	 * @param columnNumber : Column number where has to get data
	 * 
	 * @param ExpectedText : The text which has to verify
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @param takeScreenShot : get the screen(true or false)
	 */
	public boolean verifyWebTableCellData(WebDriver driver, String xpath, int rowNumber, int columnNumber,
			String ExpectedText, String Desc, Boolean takeScreenShot) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Boolean verifyStatus = false;
		if (!ExpectedText.matches("NA")) {

			WebElement rowElement = null;
			WebElement actualCellElement = null;
			// String text = repalceStrings(ExpectedText);
			String text = ExpectedText;
			// WebElement //Element = getElement(WebElement_Pro);
			rowElement = element.findElements(By.tagName("tr")).get(rowNumber);
			actualCellElement = rowElement.findElements(By.tagName("td")).get(columnNumber);
			String cellValue;

			if (actualCellElement != null) {
				if (actualCellElement.getText().toUpperCase().contains(text.toUpperCase())) {

					highLightElement(getWdDriver(), actualCellElement);
					verifyStatus = true;
					this.addStep(this.getTest_Step_Number(),
							Desc + " : " + ExpectedText + ".<br>" + "Actual is: " + actualCellElement.getText(),
							LogStatus.PASS, takeScreenShot);

				} else {
					this.addStep(this.getTest_Step_Number(),
							Desc + " : " + ExpectedText + ".<br>" + "Actual is: " + actualCellElement.getText(),
							LogStatus.FAIL, true);
					Exception_Content();

				}

			} else {
				this.addStep(this.getTest_Step_Number(), "Web table cell is not found with row " + "number " + rowNumber
						+ " and column number " + columnNumber, LogStatus.FAIL, takeScreenShot);
			}

		}

		return verifyStatus;

	}

	/*
	 * get row number using web Cell Data
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param rowText : The text which has to verify
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @param rowNumber : Row number
	 */
	public int getRowNumberFromWebTable(WebDriver driver, String xpath, String rowText, String Desc) {
		WebElement element = driver.findElement(By.xpath(xpath));
		int rowNumber = 0;
		Boolean rowFoundWithText = false;

		WebElement rowElement = null;
		WebElement actualCellElement = null;
		// String text = repalceStrings(ExpectedText);
		// WebElement //Element = getElement(WebElement_Pro);
		int noOfRows = element.findElements(By.tagName("tr")).size();
		// no of columns in the first row
		int noOfColumns = element.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).size();
		if (element != null) {

			for (int iterator = 0; iterator < noOfRows; iterator++) {
				rowElement = element.findElements(By.tagName("tr")).get(iterator);

				for (int iterator1 = 0; iterator1 < noOfColumns; iterator1++) {
					actualCellElement = rowElement.findElements(By.tagName("td")).get(iterator1);
					if (actualCellElement.getText().toUpperCase().contains(rowText.toUpperCase())) {
						rowNumber = iterator;
						rowFoundWithText = true;
						break;

					}
				}
				if (rowFoundWithText) {
					break;
				}
			}

			// }

		}
		return rowNumber;

	}

	/*
	 * Wait For Object If Not Present Then Click Previous Element To Make This
	 * Object Visible
	 * 
	 * @param propOfCurrentElement : Identify the current web element by using this
	 * property of the object
	 * 
	 * @param propOfPreviousElement :propertyof web element by using this property
	 * of the object
	 * 
	 * @param secsWaitForOneInterval : time intervals
	 * 
	 * @param totalSecsToWait : total seconds to wait
	 */
	public void waitForObjectIfNotPresentThenClickPreviousEleToMakeThisObjVisible(String propOfCurrentElement,
			String propOfPreviousElement, int secsWaitForOneInterval, int totalSecsToWait) {
		this.getWdDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// wait object is for the current element
		WebDriverWait wait = new WebDriverWait(this.getWdDriver(), secsWaitForOneInterval);
		// wait1 object is for the previous element
		// WebDriverWait wait1 = new WebDriverWait(this.getWdDriver(),60);
		int iterations = totalSecsToWait / secsWaitForOneInterval;

		if (propOfCurrentElement.startsWith("xpath")) {
			propOfCurrentElement = propOfCurrentElement.split("xpath=")[1];
		}
		if (propOfPreviousElement.startsWith("xpath")) {
			propOfPreviousElement = propOfPreviousElement.split("xpath=")[1];
		}
		boolean isCurrentElementFound = false;
		for (int i = 0; i <= iterations; i++)
			try {
				try {
					System.out.println(DateTime.now() + " looking for object " + propOfCurrentElement);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propOfCurrentElement)));
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propOfCurrentElement)));
					System.out.println("found element in try " + i);
					isCurrentElementFound = true;
					break;
				} catch (TimeoutException e) {
					try {
						// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propOfPreviousElement)));
						this.getWdDriver().findElement(By.xpath(propOfPreviousElement)).click();

						System.out.println(
								"current object not found. so clicking prevous element after timeout exception "
										+ propOfPreviousElement);
					} catch (InvalidElementStateException e1) {/*
																 * ReportLibrary.Add_Step(ReportLibrary.
																 * Test_Step_Number,"Object is not found: "+
																 * xpathPreviousObjProp , LogStatus.FAIL, true); break;
																 */
					} catch (WebDriverException e2) {/*
														 * ReportLibrary.Add_Step(ReportLibrary.
														 * Test_Step_Number,"Object is not found: "+
														 * xpathPreviousObjProp , LogStatus.FAIL, true); break;
														 */

					} catch (NoSuchElementException e2) {/*
															 * ReportLibrary.Add_Step(ReportLibrary.
															 * Test_Step_Number,"Object is not found: "+
															 * xpathPreviousObjProp , LogStatus.FAIL, true); break;
															 */

					}

					// continue;
				} catch (Exception e) {

					// FunctionLibrary.clickObject(propOfPreviousElement,"","Click object");
					System.out.print("exception block  is executed");
				}
				// this.getWdDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			} catch (Exception e) {
				this.getWdDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}
		// this.getWdDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.getWdDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		if (!isCurrentElementFound) {
			this.addStep(this.getTest_Step_Number(), "Elment is not found " + propOfCurrentElement, LogStatus.FAIL,
					true);
		}
	}

	/*
	 * Get Dropdown List Count
	 * 
	 * @param DropDownList_Property : Identify the web element by using this
	 * property of the object
	 * 
	 * @param return : total elemts present in dropdown
	 */
	public int getDropdownListCount(WebDriver driver, String xpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		/*
		 * WebElement Element = null; Element = getElement(DropDownList_Property);
		 */

		Select DropDownList = new Select(element);

		List<WebElement> elementCount = DropDownList.getOptions();
		// System.out.println("Number of items: " + elementCount.size());
		return elementCount.size();
	}

	/*
	 * Wait For Object If Not Present Then Click Previous Element To Make This
	 * Object Visible
	 * 
	 * @param propOfCurrentElement : Identify the current web element by using this
	 * property of the object
	 * 
	 * @param propOfPreviousElement :propertyof web element by using this property
	 * of the object
	 * 
	 * @param secsWaitForOneInterval : time intervals
	 * 
	 * @param totalSecsToWait : total seconds to wait
	 */
	public void waitForObjectIfNotPresentThenClickPreviousEleToMakeThisObjVisibleWebapp(String propOfCurrentElement,
			String propOfPreviousElement, int secsWaitForOneInterval, int totalSecsToWait) {
		WebDriverWait wait1 = new WebDriverWait(this.getWdDriver(), secsWaitForOneInterval);
		int iterations = totalSecsToWait / secsWaitForOneInterval;
		// wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propOfCurrentElement.split("xpath=")[1])));
		for (int i = 0; i <= iterations; i++) {
			try {
				System.out.println(DateTime.now() + "for object " + propOfCurrentElement);
				// wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propOfCurrentElement.split("xpath=")[1])));
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propOfCurrentElement)));
				System.out.println("found element in try " + i);
				break;
				/*
				 * if(this.getWdDriver().findElement(By.xpath(propOfCurrentElement.split(
				 * "xpath=")[1].toString())).isDisplayed()) { System.out.println("hello");
				 * break; }
				 */
			} catch (TimeoutException e) {
				System.out.println("object not found. then clicking prevous element with timeout exception");
				try {
					this.getWdDriver().findElement(By.xpath(propOfPreviousElement)).click();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());

				}
				// FunctionLibrary.clickObject(propOfPreviousElement, "", "Click object");
				// FunctionLibrary.clickObject(propOfCurrentElement,"","Click object");

				// continue;
			} catch (Exception e) {

				// FunctionLibrary.clickObject(propOfPreviousElement,"","Click object");
				System.out.print("exception block  is executed");
			}
		}

	}

	/*
	 * Drop Down List Selected Option
	 * 
	 * @param DropDownList_Property : Identify the current web element by using this
	 * property of the object
	 * 
	 * @param return : selected dropdown value
	 * 
	 * @param Desc : Description of the activity
	 */
	public String dropDownListSelectedOption(WebDriver driver, String xpath, String Desc) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		String Actual_Option = "";

		/*
		 * WebElement Element = null; Element = getElement(DropDownList_Property);
		 */
		if (element == null) {
			// ReportLibrary.Add_Step(ReportLibrary.Test_Step_Number, Desc +":
			// "+Expected_Option, LogStatus.FAIL, true);Exception_Content();
		} else {
			Select DropDownList = new Select(element);
			Actual_Option = DropDownList.getFirstSelectedOption().getText();

			return Actual_Option;
		}
		// }
		return Actual_Option;
	}

	/*
	 * Get Function Instance
	 * 
	 * @param return : Function Instance
	 */
	public FunctionLibrary Get_Function_Instance() {
		if (Function_Library_Instance == null) {
			return Function_Library_Instance = new FunctionLibrary();

		} else {
			return Function_Library_Instance;
		}
	}

	// close all active web driver sessions/browsers
	public void closeAllActiveBrowser() {
		if (!this.isClosedAllBrowsers()) {
			this.getWdDriver().manage().deleteAllCookies();
			try {
				this.setSblLoginStatus("");

				this.setOldBrowser("");
				Set<String> BrowserList = null;
				Iterator<String> IteratorList = null;
				int Browser_Cnt = 0;
				int i;
				BrowserList = getWdDriver().getWindowHandles();
				Browser_Cnt = BrowserList.size();
				IteratorList = BrowserList.iterator();
				String[] WinList = new String[Browser_Cnt];
				for (i = 0; i < Browser_Cnt; i++) {
					WinList[i] = IteratorList.next();

				}
				for (i = Browser_Cnt - 1; i >= 0; i--) {
					// getWdDriver().switchTo().window(WinList[i]).manage().timeouts().implicitlyWait(30,
					// TimeUnit.SECONDS);
					getWdDriver().switchTo().window(WinList[i]).manage().timeouts().implicitlyWait(60,
							TimeUnit.SECONDS);
					// this.addStep(this.getTest_Step_Number(), "Closed the browser",
					// LogStatus.INFO, false);
					getWdDriver().quit();

				}
			} catch (Exception e) {

			}
			this.setClosedAllBrowsers(true);
		}
	}

	// Get current date @param return : Date
	public String Get_Current_Date() {
		DateTime currentDate = new DateTime();
		String D = String.valueOf(currentDate.getDayOfMonth());
		String M = String.valueOf(currentDate.getMonthOfYear());
		String Y = String.valueOf(currentDate.getYear());
		String Date123 = D + "." + M + "." + Y;
		return Date123;
	}

	/*
	 * verify Web Element
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param Event: get event to be perform(Enable/disable)
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @return number of rows
	 */
	public boolean Verify_WebElement_Enabled(WebDriver driver, String xpath, String Event, String Desc) {
		if (!Event.matches("NA")) {
			try {
				Thread.sleep(500);

			} catch (Exception e) {

			}

			WebElement Element = null;
			// Element = getElement(WebElement_Pro);
			if (Element == null) {
				if (Desc != "") {
					//// ReportLibrary.Add_Step(//ReportLibrary.Test_Step_Number, Desc,
					//// LogStatus.FAIL, true);Exception_Content();
				}
			} else {
				if (Element.isEnabled()) {
					if (Desc != "") {
						return true;
						//// ReportLibrary.Add_Step(//ReportLibrary.Test_Step_Number, Desc,
						//// LogStatus.PASS, true);
					}
				} else {
					if (Desc != "") {
						return true;
						//// ReportLibrary.Add_Step(//ReportLibrary.Test_Step_Number, Desc,
						//// LogStatus.FAIL, true);Exception_Content();
					}
				}
			}
		}
		return false;
	}

	/*
	 * Get row number with two text(two string data)
	 * 
	 * @param WebElement_Pro : Identify the web element by using this property of
	 * the object
	 * 
	 * @param rowText1: string data 1
	 * 
	 * @param Quantity: string data 2
	 * 
	 * @param Desc : Description of the activity
	 * 
	 * @return true/false
	 */
	public int getRowNumberFromWebTableByTwoText(WebDriver driver, String xpath, String rowText1, String Quantity,
			String Desc) {
		int rowNumber = 0;
		Boolean rowFoundWithText = false;

		// int i=0;
		WebElement rowElement = null;
		WebElement actualCellElement = null;
		WebElement element = driver.findElement(By.xpath(xpath));
		// String text = repalceStrings(ExpectedText);
		// WebElement //Element = getElement(WebElement_Pro);
		int noOfRows = element.findElements(By.tagName("tr")).size();
		// no of columns in the first row
		int noOfColumns = element.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).size();
		if (element != null) {

			for (int iterator = 1; iterator < noOfRows; iterator++) {
				rowElement = element.findElements(By.tagName("tr")).get(iterator);

				for (int iterator1 = 1; iterator1 < noOfColumns; iterator1++) {
					actualCellElement = rowElement.findElements(By.tagName("td")).get(iterator1);
					if (actualCellElement.getText().toUpperCase().contains(rowText1.toUpperCase())) {

						for (int i = 0; i < noOfColumns; i++) {
							actualCellElement = rowElement.findElements(By.tagName("td")).get(i);
							if (actualCellElement.getText().toUpperCase().contains(Quantity.toUpperCase())) {
								rowNumber = iterator;
								rowFoundWithText = true;
								break;
							}
						}

					}
				}
				if (rowFoundWithText) {
					break;
				}
			}

		}

		// }
		return rowNumber;

	}

	public void waitForObjectIfNotPresentThenClickPreviousEleToMakeThisObjVisibleforCase(String propOfCurrentElement,
			String propOfPreviousElement, int secsWaitForOneInterval, int totalSecsToWait) {
		this.getWdDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// wait object is for the current element
		WebDriverWait wait = new WebDriverWait(this.getWdDriver(), secsWaitForOneInterval);
		// wait1 object is for the previous element
		// WebDriverWait wait1 = new WebDriverWait(this.getWdDriver(),60);
		int iterations = totalSecsToWait / secsWaitForOneInterval;

		if (propOfCurrentElement.startsWith("xpath")) {
			propOfCurrentElement = propOfCurrentElement.split("xpath=")[1];
		}
		if (propOfPreviousElement.startsWith("xpath")) {
			propOfPreviousElement = propOfPreviousElement.split("xpath=")[1];
		}

		for (int i = 0; i <= iterations; i++)
			try {
				try {
					System.out.println(DateTime.now() + " looking for object " + propOfCurrentElement);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propOfCurrentElement)));
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propOfCurrentElement)));
					System.out.println("found element in try " + i);
					break;
				} catch (TimeoutException e) {
					try {
						// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propOfPreviousElement)));
						this.getWdDriver().findElement(By.xpath(propOfPreviousElement)).click();

						System.out.println(
								"current object not found. so clicking prevous element after timeout exception "
										+ propOfPreviousElement);
					} catch (InvalidElementStateException e1) {/*
																 * ReportLibrary.Add_Step(ReportLibrary.
																 * Test_Step_Number,"Object is not found: "+
																 * xpathPreviousObjProp , LogStatus.FAIL, true); break;
																 */
					} catch (WebDriverException e2) {/*
														 * ReportLibrary.Add_Step(ReportLibrary.
														 * Test_Step_Number,"Object is not found: "+
														 * xpathPreviousObjProp , LogStatus.FAIL, true); break;
														 */

					} catch (NoSuchElementException e2) {/*
															 * ReportLibrary.Add_Step(ReportLibrary.
															 * Test_Step_Number,"Object is not found: "+
															 * xpathPreviousObjProp , LogStatus.FAIL, true); break;
															 */

					}

					// continue;
				} catch (Exception e) {

					// FunctionLibrary.clickObject(propOfPreviousElement,"","Click object");
					System.out.print("exception block  is executed");
				}
				// this.getWdDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			} catch (Exception e) {
				this.getWdDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}
		// this.getWdDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.getWdDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	/*
	 * extend report instance
	 * 
	 * @param Test_Name : Name Of Test
	 * 
	 * @param return : Extend Report Instance
	 */
	@SuppressWarnings("deprecation")
	public ExtentReports getExtends(String Test_Name) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd hh.mm.ss.S aa");
			String formattedDate = dateFormat.format(new Date()).toString();
			String dateTimeStamp = formattedDate.replace("-", "").replace(" ", "_").replace(".", "_");

			if (getExtendReport_Instance() == null) {

				Report_Base_Path = this.getPath() + "\\Report";
				this.checkCreateDirectory(Report_Base_Path);
				Report_Suite_Path = Report_Base_Path + "\\Suite";
				this.checkCreateDirectory(Report_Suite_Path);
				Report_Suite_HTML_Path = Report_Suite_Path + "\\Suite_HTML";
				this.checkCreateDirectory(Report_Suite_HTML_Path);
				Report_Suite_HTMLs_Path = Report_Suite_HTML_Path + "\\" + dateTimeStamp + "_" + dateTimeStamp;
				Report_Suite_SS_F_Path = Report_Suite_Path + "\\Suite_SS\\Screenshots\\";
				this.checkCreateDirectory(Report_Suite_Path + "\\Suite_SS\\");
				this.checkCreateDirectory(Report_Suite_SS_F_Path);
				ExtendReport_Instance = new ExtentReports(Report_Suite_HTMLs_Path + ".html", true);
				ExtendReport_Instance.addSystemInfo("Chrome", "54.0.0").addSystemInfo("Selenium Version", "3.0.1");
				ExtendReport_Instance.assignProject("Author:Venkat");
				ExtendReport_Instance.config().documentTitle("TEST AUTOMATION REPORT").reportName("UNIFIED PARTNER")
						.reportHeadline("MANAGEMENT TEST AUTOMATION ANALYSIS");
				Error_Flag = false;
			} else {
				return ExtendReport_Instance;
			}

		} catch (Exception e) {

		}
		return ExtendReport_Instance;
	}

	/*
	 * extend report start
	 * 
	 * @param Test_Name : Name Of Test
	 * 
	 * @param Test_Description : Description of the activity
	 * 
	 * @param return : Extend Report Instance
	 */
	public ExtentTest startReport(String Test_Name, String Test_Description) {
		// CommonLibrary.settingsSheetInfo = CommonLibrary.getSettingsSheetInfo();
		// if (ExtTest_Instance == null)
		// {
		// SS_Folder = Report_Suite_SS_Path+"/" +
		// Function_Library.Get_Function_Instance()
		// .Get_TimeStamp();
		Test_Step_Number = 1;
		ExtTest_Instance = getExtends(Test_Name).startTest(Test_Name, Test_Description);
		// }
		return ExtTest_Instance;
	}

	public ExtentTest getReport() {
		return this.ExtTest_Instance;
	}

	/*
	 * Add Step
	 * 
	 * @param Step : Step Number
	 * 
	 * @param Test_Description : Description of the activity
	 * 
	 * @param Status : Log Status
	 * 
	 * @param ScreenShot : Screen Shot(true or False)
	 */
	public void addStep(int Step, String Description, LogStatus Status, boolean ScreenShot) {
		// ScreenShot=false;
		desc = Description;
		String StepName = "Step " + Step;
		if (ScreenShot)// !CommonLibrary.isClosedAllBrowsers)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd hh.mm.ss.S aa");
			String formattedDate = dateFormat.format(new Date()).toString();
			String dateTimeStamp = formattedDate.replace("-", "").replace(" ", "_").replace(".", "_");

			// For KNE Execution-Delete after
			// String path = Report_Suite_SS_F_Path + "//Suite_SS_"
			// +Function_Library.Get_Function_Instance().Get_TimeStamp()+".png";
			System.out.println(Report_Suite_SS_F_Path);
			String screenshotId = dateTimeStamp;
			String path = Report_Suite_SS_F_Path + screenshotId + ".png";

			System.out.println(path);

			this.captureScreenShot(path);
			path = "../Suite_SS/Screenshots/" + screenshotId + ".png";
			System.out.println(Description);

			getReport().log(Status, StepName, Description + getReport().addScreenCapture(path));

		} else {
			System.out.println(Description);
			getReport().log(Status, StepName, Description);
		}
		Test_Step_Number = Test_Step_Number + 1;
		ExtendReport_Instance.flush();
	}

	/* End Test */
	public void endTest() {
		/*
		 * if(Report_Library.Error_Flag) {
		 * Report_Library.Add_Step(Report_Library.Test_Step_Number, "Fail" ,
		 * LogStatus.FAIL,false) ; }
		 */

		Test_Step_Number = 1;
		ExtendReport_Instance.endTest(ExtTest_Instance);

	}

	/*
	 * End the report
	 */
	public void endReport() {

		ExtendReport_Instance.flush();

		try {

			File gb_objDirecotry = new File(".");
			String Project_path = gb_objDirecotry.getCanonicalPath();
			FileWriter writer = new FileWriter(Project_path + "/Result_path.txt");
			writer.write("");
			String path = Report_Suite_HTMLs_Path.toString();
			String path2;
			path2 = path.substring(62);
			System.out.println(path2);
			writer.write(path2);
			writer.close();

			TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * check directory path
	 * 
	 * @param Path : directory path
	 */
	public void checkCreateDirectory(String Path) {
		File f = new File(Path);
		if (!f.exists()) {
			f.mkdir();
		}
	}

	/*
	 * get directory path
	 * 
	 * @param return : diretory path
	 */
	public String getPath() {
		String Bpath = "";
		try {

			objDirecotry = new File(".");
			Bpath = objDirecotry.getCanonicalPath();
		} catch (Exception e) {

		}
		return Bpath;
	}

	public HashMap<String, String> getSettingsSheetInfo() {
		return settingsSheetInfo;
	}

}
