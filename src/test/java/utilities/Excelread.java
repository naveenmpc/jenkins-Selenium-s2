package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelread {
	XSSFWorkbook file;
	XSSFSheet s;
public String readExcel(String path, String sheetName, int r, int c) throws IOException {
		FileInputStream fin = new FileInputStream(path);
		file = new XSSFWorkbook(fin);
		s = file.getSheet("Sheet1");
		String data = s.getRow(r).getCell(c).getStringCellValue();
		file.close();
		return data;
	}
	
	public int getLastRow(String path, String sheetName) throws IOException {
		FileInputStream fin = new FileInputStream(path);
		file = new XSSFWorkbook(fin);
		s = file.getSheet("Sheet1");
		int LastRow = s.getLastRowNum();
		return LastRow;
	}
	
	public static void main(String args[]) throws IOException {
		Excelread e = new Excelread();int LastRow = e.getLastRow("C:\\Users\\mnave\\Downloads\\Testdata.xlsx\\", "Sheet1");
      for(int i=0;i<=LastRow;i++) {
          String Username = e.readExcel("C:\\Users\\mnave\\Downloads\\Testdata.xlsx\\", "Sheet1", i, 0);
          String Password = e.readExcel("C:\\Users\\mnave\\Downloads\\Testdata.xlsx\\", "Sheet1", i, 1);
			System.out.print("Username "+i+" "+Username+" ");
			System.out.print("Password "+i+" "+Password+" ");
			System.out.println(" ");
		}
		
	}

}
