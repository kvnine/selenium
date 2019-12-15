//package rd;
//
//import org.joda.time.DateTime;
//import org.junit.internal.runners.model.EachTestNotifier;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//
//
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//
//public class landPrices2 {
//	//public static PrintWriter out;
//	public static Writer output;
//	public static String dynamicNumber;
//	
//    public static void main(String [] args) throws InterruptedException, IOException
//    {
//    	DateTime date = new DateTime();
//    	dynamicNumber = date.getYear()+date.getMonthOfYear()+date.getDayOfMonth()+"_"+date.getHourOfDay()+"_"+ date.getMinuteOfHour();
//
//    	//output = new BufferedWriter(new FileWriter("landRecords2.txt", true));  //clears file every time
//
////    	out = new PrintWriter("landRecords.txt");
//
//        System.out.println("Ap land prices");
//        System.setProperty("webdriver.chrome.driver",".\\browserDrivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//        driver.get("http://registration.ap.gov.in/UnitRateMV.do?method=getDistrictList&uType=U");
//
//        WebElement agriRadioBtn = driver.findElement(By.xpath("(//*[@name='RateType'])[2]"));
//        agriRadioBtn.click();
//
//
//        WebElement districtElement = driver.findElement(By.id("districtCode"));
//        Select districtSelectElement = new Select(districtElement);
//        int noOfDistricts =districtSelectElement.getOptions().size()-1;
//
//        for(int distCounter =9;distCounter<=noOfDistricts-1;distCounter++)
//        {
//        	if(distCounter>1)
//        	{
//        		  agriRadioBtn = driver.findElement(By.xpath("(//*[@name='RateType'])[2]"));
//        	        agriRadioBtn.click();
//
//        	        districtElement = driver.findElement(By.id("districtCode"));
//        	         districtSelectElement = new Select(districtElement);
//        	        	String districtName =  districtSelectElement.getOptions().get(distCounter).getText();
//        	            System.out.println("DISTRICT----------->" + districtName);
//
//                 	districtSelectElement.selectByVisibleText(districtName);
//
//        	}
//        	else {
//        	districtSelectElement.selectByIndex(distCounter);
//        	}
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        	String districtName =  districtSelectElement.getOptions().get(distCounter).getText();
//            System.out.println("DISTRICT----------->" + districtName);
//
//            WebElement mandalElement = driver.findElement(By.name("mandalCode"));
//            Select mandalSelectElement = new Select(mandalElement);
//            int noOfMandals = mandalSelectElement.getOptions().size()-1;
//            for(int mandalCounter =5;mandalCounter<=noOfMandals-1;mandalCounter++)
//            {
//
//            	if(mandalCounter>1)
//            	{
//
//            		  agriRadioBtn = driver.findElement(By.xpath("(//*[@name='RateType'])[2]"));
//            	        agriRadioBtn.click();
//
//
//            	         districtElement = driver.findElement(By.id("districtCode"));
//            	         districtSelectElement = new Select(districtElement);
//            	         //System.out.println("dddddddddd" + districtName);
//                    	districtSelectElement.selectByVisibleText(districtName);
//
//                    	
//                    	Thread.sleep(3000);
//
//                        mandalElement = driver.findElement(By.id("mandalCode"));
//                        mandalSelectElement = new Select(mandalElement);
//                        
//
//                    	Thread.sleep(3000);
//
//                    	String mandalName =  mandalSelectElement.getOptions().get(mandalCounter).getText();
//            	        mandalSelectElement.selectByVisibleText(mandalName);
//            	}
//            	else
//            	{
//            		mandalSelectElement.selectByIndex(mandalCounter);
//            		Thread.sleep(3000);
//            	}
//        	String mandalName =  mandalSelectElement.getOptions().get(mandalCounter).getText();
//            System.out.println("MANDAL----------->" + mandalName);
//                  
//            
//            
//            
//            
//            
//        fn(driver, districtName, mandalName);
//            }
//            }
//
//
//    }
//
//    public static String rightPadding(String str, int num) {
//        return String.format("%1$-" + num + "s", str);
//    }
//    public static void fn(WebDriver driver, String dN, String mN) throws IOException {
//    	WebElement villageElement = driver.findElement(By.id("villageCode"));
//        Select villageSelectElement = new Select(villageElement);
//        int noOfVillages = villageSelectElement.getOptions().size()-1;
//        
//
//
//               
//               for(int villageIterator=1;villageIterator<=noOfVillages-1;villageIterator++) {
//            	   
//            	   if(villageIterator>1)
//            	   {
//            		   
//	            	   
//	            	   WebElement agriRadioBtn = driver.findElement(By.xpath("(//*[@name='RateType'])[2]"));
//	                   agriRadioBtn.click();
//	
//	                   WebElement districtElement = driver.findElement(By.id("districtCode"));
//	                   Select districtSelectElement = new Select(districtElement);
//	                   //System.out.println(districtSelectElement.getOptions());
//	                   districtSelectElement.selectByVisibleText(dN);
//	
//	                   try {
//	                       Thread.sleep(3000);
//	                   } catch (InterruptedException e) {
//	                       e.printStackTrace();
//	                   }
//	
//	                   WebElement mandalElement = driver.findElement(By.id("mandalCode"));
//	                   Select mandalSelectElement = new Select(mandalElement);
//	                   mandalSelectElement.selectByVisibleText(mN);
//	
//	                   try {
//	                       Thread.sleep(3000);
//	                   } catch (InterruptedException e) {
//	                       e.printStackTrace();
//	                   }
//
//            	   }
//            	   
//                   villageElement = driver.findElement(By.id("villageCode"));
//                    villageSelectElement = new Select(villageElement);
//                   noOfVillages = villageSelectElement.getOptions().size()-1;
//                   
//                   String villageName = villageSelectElement.getOptions().get(villageIterator).getText();
//            	   System.out.println(4444+villageName);
//               villageSelectElement.selectByVisibleText(villageName);
//               try {
//                   Thread.sleep(3000);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               System.out.println("----------------------->    " + villageName +    "<-----------------------");
//               WebElement submitBtn = driver.findElement(By.name("submit"));
//               submitBtn.click();
//
//               WebElement pricesTbl = driver.findElement(By.id("Table8"));
//
//               List<WebElement> allRows = pricesTbl.findElements(By.tagName("tr"));
//
//               int iterator = 0;
//
//               String lineToBeOutPut = "";
//               int rowCount = allRows.size();
//               for (int jj = 0; jj<=rowCount-3;jj++) {
//            	   WebElement as = allRows.get(jj);
//
//                   iterator++;
//                   if (iterator >= 4) {
//                       if (iterator != allRows.size()) {
//                           List<WebElement> allCells =    as.findElements(By.tagName("td"));
//                           int i = 0;
//                           int noOfCells = allCells.size();
//                           for (int s =0;s<noOfCells; s++) {
//                        	  WebElement ee = allCells.get(s);
//                               if (i == 0) {
//
////   System.out.print(rightPadding(eachCell.getText(), 5));
////   System.out.print(rightPadding(dN, 20));
////   System.out.print(rightPadding(mN, 20));
////   System.out.print(rightPadding(villageName, 20));
//    lineToBeOutPut = rightPadding(ee.getText(), 5) + rightPadding(dN, 20)  + rightPadding(mN, 20) + rightPadding(villageName, 20);
//                               } else {
//
//                            	   lineToBeOutPut = lineToBeOutPut + rightPadding(ee.getText(), 32);
//                               }
//                               i++;
//
//                           }
//                           System.out.println(lineToBeOutPut);
////                         out.println(lineToBeOutPut);
//                         //output.write(lineToBeOutPut);
//                           
//                           try(FileWriter fw = new FileWriter("landRecords"+ dynamicNumber+ ".txt", true);
//                        		    BufferedWriter bw = new BufferedWriter(fw);
//                        		    PrintWriter out = new PrintWriter(bw))
//                        		{
//                        		    out.println(lineToBeOutPut);
//                        		    //more code
//                        		   // out.println("more text");
//                        		    //more code
//                        		} catch (IOException e) {
//                        		    //exception handling left as an exercise for the reader
//                        		}    
//                           i = 0;
//                       }
//                   }
//                   //System.out.println("");
//                   //lineToBeOutPut = lineToBeOutPut  + "\n";
//                
////                   output.close();
//               }
//               
//               iterator=0;
//               System.out.println("");
//               
//               WebElement backBtn =
//   driver.findElement(By.xpath("//input[@value='Back']"));
//               backBtn.click();
//           }
//    }
//}
