package rd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AutoRestartMachines {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Program starts --- restart machine");
		String locOfInputExcel = "C:\\Users\\hp\\git\\selenium-e2e\\selenium-e2e\\test-data\\Machines_to_restart.xlsx";
		FileInputStream fis = new FileInputStream(locOfInputExcel);
		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("Sheet1");
		int noOfRows = s.getLastRowNum();
		HashMap<String, String> machinesInfo = new HashMap<String, String>();
		String machineName = "";
		String userId = "";
		String comments = "";
		DataFormatter formatter = new DataFormatter();
		for (int i = noOfRows - 1; i > 0; i--) {
			machineName = formatter.formatCellValue(s.getRow(i).getCell(1));
			userId = formatter.formatCellValue(s.getRow(i).getCell(2));
			machinesInfo.put(machineName, userId);
			// comments = s.getRow(i).getCell(3).getRawValue();
			System.out.println(machineName);

		}

	}

}
