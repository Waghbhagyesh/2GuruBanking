package org.xyz_PracticeTest;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataReadingExcel {

	public static void main(String[] args) {
		//		String FileLoc ="G:\\Eclipse_Workspace_Selenium\\Guru99Banking\\TestData\\TestDataGuruBank.xlsx";
		try{
			FileInputStream fis=new FileInputStream(".\\TestData\\TestDataGuruBank.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			int noOfSheet=wb.getNumberOfSheets();
			System.out.println(noOfSheet);
		}catch(Exception e) {

		}

	}

}
