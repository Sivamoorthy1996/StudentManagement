package org.tyys.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains reusable method of excel file 
 * @author Sivasubramaniam.M
 *
 */
public final class ExcelUtility {
	private Workbook workbook;
	/**
	 * This method is used to initialize the excel file
	 * @param FilePath
	 */
	public void initializeExcelFile(String FilePath) {
		FileInputStream fis=null;
		try {
		      fis=new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	   try {
		 workbook = WorkbookFactory.create(fis);
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   
	}
	
	/**
	 * This method is used to get the data from excel file
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 */
	public String getDataFromExcelFile(String SheetName,int RowNum,int CellNum) {
	Sheet sheet = workbook.getSheet(SheetName);
	return new DataFormatter().formatCellValue(sheet.getRow(RowNum).getCell(CellNum));
				
	}
	/**
	 * This method is used to set the data into the excel file
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @param status
	 */
	public void setDataIntoExcelFile(String SheetName,int RowNum,int CellNum,String status) {
		workbook.getSheet(SheetName).getRow(RowNum).createCell(CellNum).setCellValue(status);
	}
	/**
	 * This method is used to save the data in the excel
	 * @param FilePath
	 */
	public void saveOutputIntoExcel(String FilePath) {
		FileOutputStream fos=null;
		try {
		 fos=new FileOutputStream(FilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to close the workbook
	 */
	public void workbookClose() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
