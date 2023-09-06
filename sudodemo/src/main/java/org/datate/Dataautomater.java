package org.datate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataautomater {
	
	//public static String[][] main(String[] args) throws IOException  {
		@DataProvider (name="testfile")
		public  String[][] readdata() throws IOException  {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\sudodemo\\Excel\\datafile.xlsx");
		FileInputStream fis = new  FileInputStream(f);
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = wbook.getSheet("sheet1");
		int noofrow=sheet.getLastRowNum();
		XSSFRow cells =sheet.getRow(0);
		int noofcells = cells.getLastCellNum();
		
		String getdata[][] = new String[noofrow][noofcells];
		for(int i=1;i<=noofrow;i++) {
			for(int j=0;j<noofcells;j++) {
				DataFormatter df = new DataFormatter();
				getdata[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
				//System.out.println(getdata[i-1][j]);
			}
		}
		return getdata;
		}
	}


