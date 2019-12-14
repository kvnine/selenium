package rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class landPrices3 {
    public static void main(String [] args)
    {
        System.out.println("Ap land prices");
        System.setProperty("webdriver.gecko.driver",".\\browserDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("http://registration.ap.gov.in/UnitRateMV.do?method=getDistrictList&uType=U");

        fn(driver);
     


    }

    public static String rightPadding(String str, int num) {
        return String.format("%1$-" + num + "s", str);
    }
    public static void fn(WebDriver driver) {
    	   for(int villageIterator=1;villageIterator<=20;villageIterator++) {
               WebElement agriRadioBtn = driver.findElement(By.xpath("(//*[@name='RateType'])[2]"));
               agriRadioBtn.click();

               WebElement districtElement = driver.findElement(By.name("districtCode"));
               Select districtSelectElement = new Select(districtElement);
               System.out.println(districtSelectElement.getOptions());
               districtSelectElement.selectByVisibleText("PRAKASAM");

               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               WebElement mandalElement = driver.findElement(By.name("mandalCode"));
               Select mandalSelectElement = new Select(mandalElement);
               mandalSelectElement.selectByVisibleText("ONGOLE");

               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }


               WebElement villageElement = driver.findElement(By.name("villageCode"));
               Select villageSelectElement = new Select(villageElement);
               villageSelectElement.selectByIndex(villageIterator);
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
                           List<WebElement> allCells =
   eachRow.findElements(By.tagName("td"));
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
