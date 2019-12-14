package rd;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.ExpandedIcon;

import java.util.List;

public class landPrices1 {
    public static void main(String [] args)
    {
        System.out.println("Ap land prices");
        System.setProperty("webdriver.gecko.driver",".\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("http://registration.ap.gov.in/UnitRateMV.do?method=getDistrictList&uType=U");
//        driver.findElement(By.xpath("//*[@name='RateType' and @value='U']")).click();;
//        driver.findElement(By.xpath("//*[@name='RateType' and @value='R']")).click();;
//        driver.findElement(By.xpath("//*[@name='RateType' and @value='U']")).click();;
        driver.findElement(By.xpath("//*[@name='RateType' and @value='R']")).click();;
//        driver.findElement(By.xpath("//*[@name='RateType' and @value='U']")).click();;
      //  for(int villageIterator=1;villageIterator<=20;villageIterator++) {
//            WebElement agriRadioBtn = driver.findElement(By.xpath("//*[@name='RateType' and @value='R']"));//));
//            agriRadioBtn.click();

            WebElement districtElement = driver.findElement(By.id("districtCode"));
            Select districtSelectElement = new Select(districtElement);
            int noOfDistricts =districtSelectElement.getOptions().size()-1;
            for(int distCounter =1;distCounter<=noOfDistricts;distCounter++)
            {
            	districtSelectElement.selectByIndex(distCounter);
            	String districtName =  districtSelectElement.getOptions().get(distCounter).getText();
                System.out.println("DISTRICT----------->" + districtName);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                WebElement mandalElement = driver.findElement(By.name("mandalCode"));
                Select mandalSelectElement = new Select(mandalElement);
                int noOfMandals = mandalSelectElement.getOptions().size()-1;
                for(int mandalCounter =1;mandalCounter<=noOfMandals;mandalCounter++)
                {
                
                mandalSelectElement.selectByIndex(mandalCounter);
            	String mandalName =  mandalSelectElement.getOptions().get(mandalCounter).getText();
                System.out.println("MANDAL----------->" + mandalName);
                
                
                
//                mandalSelectElement.selectByVisibleText("ONGOLE");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                WebElement villageElement = driver.findElement(By.name("villageCode"));
                Select villageSelectElement = new Select(villageElement);
                int noOfVillages = villageSelectElement.getOptions().size()-1;
                for(int villageCounter =1;villageCounter<=noOfVillages;villageCounter++)
                {
                if(villageCounter>1)
                		{
                	//driver.navigate().refresh();
                	  WebDriverWait wait = new WebDriverWait(driver, 60);
                  
                	try {
                		System.out.println(123);
						//Thread.sleep(3000);
                		wait.until(ExpectedConditions.elementToBeClickable(By.id("rate2")));
//                  	wait.until(ExpectedConditions.element
                       
//                        driver.findElement(By.xpath("//*[@name='RateType' and @value='U']")).click();;
                        driver.findElement(By.id("rate2")).click();;
//                        driver.findElement(By.xpath("//*[@name='RateType' and @value='U']")).click();;
//                        driver.findElement(By.xpath("//*[@name='RateType' and @value='R']")).click();;
                        
//                  	agriRadioBtn.click();
					} catch (StaleElementReferenceException e) {
						driver.navigate().refresh();
						System.out.println(4444);

                		wait.until(ExpectedConditions.elementToBeClickable(By.id("rate2")));//("//*[@name='RateType' and @value='R']")));
//				        driver.findElement(By.xpath("//*[@name='RateType' and @value='U']")).click();;
				        driver.findElement(By.id("rate2")).click();;
//				        driver.findElement(By.xpath("//*[@name='RateType' and @value='U']")).click();;
//				        driver.findElement(By.xpath("//*[@name='RateType' and @value='R']")).click();;
//                  	wait.until(ExpectedConditions.element
//                  	agriRadioBtn.click();
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//                	driver.findElement(By.xpath("//*[@name='RateType' and @value='R']")
                	System.out.println("dddddd " + villageCounter);
                	
                	try {
                		System.out.println(3323);
                		wait.until(ExpectedConditions.elementToBeSelected(By.id("districtCode")));
                		districtSelectElement.selectByVisibleText(districtName);

                		wait.until(ExpectedConditions.elementToBeSelected(By.id("mandalCode")));
                    	mandalSelectElement.selectByVisibleText(mandalName);
                    	
                	}catch(StaleElementReferenceException e)
                	{
                		System.out.println(9999);
                		wait.until(ExpectedConditions.elementToBeSelected(By.id("districtCode")));
                		districtSelectElement.selectByVisibleText(districtName);

                		wait.until(ExpectedConditions.elementToBeSelected(By.id("mandalCode")));
                    	mandalSelectElement.selectByVisibleText(mandalName);
                	}
                		} else
                		{

                            villageSelectElement.selectByIndex(villageCounter);	
                		}
            	String villageName =  villageSelectElement.getOptions().get(villageCounter).getText();
                System.out.println("VILLAGE----------->" + villageName);

                
                
                
                //                villageSelectElement.selectByIndex(villageIterator);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("----------------------->    " + villageSelectElement.getFirstSelectedOption().getText()+
    "<-----------------------");
                WebElement submitBtn = driver.findElement(By.name("submit"));
                submitBtn.click();

                WebElement pricesTbl = driver.findElement(By.id("Table8"));

                List<WebElement> allRows = pricesTbl.findElements(By.tagName("tr"));

                int iterator = 0;
                for (WebElement eachRow : allRows) {
                    iterator++;
                    if (iterator >= 4) {
                        if (iterator != allRows.size()) {
                            List<WebElement> allCells =     eachRow.findElements(By.tagName("td"));
                            int i = 0;
                            for (WebElement eachCell : allCells) {

                                if (i == 0) {

                                		System.out.print(rightPadding(eachCell.getText(), 5));
                                } else {

                                		System.out.print(rightPadding(eachCell.getText(), 22));
                                }
                                i++;

                            }
                            i = 0;
                        }
                    }
                    System.out.println("");
                }iterator=0;
                System.out.println("");
                WebElement backBtn =
                		driver.findElement(By.xpath("//input[@value='Back']"));
                backBtn.click();
                }
                }

            }
            
        }

    

    public static String rightPadding(String str, int num) {
        return String.format("%1$-" + num + "s", str);
    }
}
