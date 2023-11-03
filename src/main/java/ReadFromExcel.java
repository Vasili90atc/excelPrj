package excelPrj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	FileInputStream file;
	XSSFWorkbook workbook;
	List <Prefecture> perf;
	List <PrefectureUnit> perfUnit;
	List <Municipality> municip;
	public ReadFromExcel(String fileName) {
		try {
			file = new FileInputStream(new File(fileName));
			workbook = new XSSFWorkbook(file);
			perf = new ArrayList<>();
			perfUnit = new ArrayList<>();
			municip = new ArrayList<>();
		} catch (FileNotFoundException e) {
			file = null;
		} catch (IOException e) {
			file = null;
			e.printStackTrace();
		}
	}

	public void readFromSheet(int num) {
		if (file==null) {
			System.out.println("Sorry an error occured!!");
		}
		else {
			try {
				XSSFSheet sheet = workbook.getSheetAt(num);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) 
				{
					Row row = rowIterator.next();
					//For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();

					while (cellIterator.hasNext()) 
					{
						Cell cell = cellIterator.next();
						//Check the cell type and format accordingly
						switch (cell.getCellType()) 
						{
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
						case BLANK:
							break;
						default:
							throw new IllegalStateException("Unexpected value: " + cell.getCellType());
						}
					}
					System.out.println("");
				}
				file.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void readFromSheetPrefecture() {
		int numRows;
		int numCols;
		numRows=0;
		if (file==null) {
			System.out.println("Sorry an error occured!!");
		}
		else {
			try {
				XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) 
				{
					Row row = rowIterator.next();
					if (numRows==0) {
						numRows++;
						continue;
					}
					numCols=0;
					//For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					Prefecture p1 = new Prefecture();
					while (cellIterator.hasNext()) 
					{
						Cell cell = cellIterator.next();
						
						//Check the cell type and format accordingly
						switch (cell.getCellType()) 
						{
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case STRING:
							//System.out.print(cell.getStringCellValue() + "\t");
							if (numCols==0) {
								p1.setCode(cell.getStringCellValue());
								numCols++;
							}
							else {
								p1.setDescription(cell.getStringCellValue());
								numCols++;
							}
							break;
						case BLANK:
							break;
						default:
							throw new IllegalStateException("Unexpected value: " + cell.getCellType());
						}
					}
					perf.add(p1);
					//System.out.println("");
				}
				file.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List <PrefectureUnit> readFromSheetPrefectureUnit() {
		int numRows;
		int numCols;
		numRows=0;
		if (file==null) {
			System.out.println("Sorry an error occured!!");
		}
		else {
			try {
				XSSFSheet sheet = workbook.getSheetAt(1);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) 
				{
					Row row = rowIterator.next();
					if (numRows==0) {
						numRows++;
						continue;
					}
					numCols=0;
					//For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					PrefectureUnit p1 = new PrefectureUnit();
					while (cellIterator.hasNext()) 
					{
						Cell cell = cellIterator.next();
						
						//Check the cell type and format accordingly
						switch (cell.getCellType()) 
						{
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case STRING:
							//System.out.print(cell.getStringCellValue() + "\t");
							if (numCols==0) {
								p1.setCode(cell.getStringCellValue());
								numCols++;
							}
							else if (numCols==1){
								p1.setDescription(cell.getStringCellValue());
								numCols++;
							}
							else {
								p1.setMasterCode(cell.getStringCellValue());
								numCols++;
							}
							break;
						case BLANK:
							break;
						default:
							throw new IllegalStateException("Unexpected value: " + cell.getCellType());
						}
					}
					perfUnit.add(p1);
					//System.out.println("");
				}
				file.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return perfUnit;
	}
	
	public List <Municipality> readFromSheetMunicipality() {
		int numRows;
		int numCols;
		numRows=0;
		if (file==null) {
			System.out.println("Sorry an error occured!!");
		}
		else {
			try {
				XSSFSheet sheet = workbook.getSheetAt(2);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) 
				{
					Row row = rowIterator.next();
					if (numRows==0) {
						numRows++;
						continue;
					}
					numCols=0;
					//For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					Municipality p1 = new Municipality();
					
					while (cellIterator.hasNext()) 
					{
						Cell cell = cellIterator.next();
						
						//Check the cell type and format accordingly
						switch (cell.getCellType()) 
						{
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case STRING:
							//System.out.print(cell.getStringCellValue() + "\t");
							if (numCols==0) {
								p1.setCode(cell.getStringCellValue());
								numCols++;
							}
							else if (numCols==1){
								p1.setDescription(cell.getStringCellValue());
								numCols++;
							}
							else {
								p1.setMasterCode(cell.getStringCellValue());
								numCols++;
							}
							break;
						case BLANK:
							break;
						default:
							throw new IllegalStateException("Unexpected value: " + cell.getCellType());
						}
					}
					municip.add(p1);
					//System.out.println("");
				}
				file.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return municip;
	}
	
	public void showPrefectures() {
		for (int i=0; i<perf.size(); i++) {
			System.out.println(perf.get(i).getCode()+"\t"+perf.get(i).getDescription());
		}
	}
	
	public void showPrefectureUnits() {
		for (int i=0; i<perfUnit.size(); i++) {
			System.out.println(perfUnit.get(i).getCode()+"\t"+perfUnit.get(i).getDescription()+"\t"+perfUnit.get(i).getMasterCode());
		}
	}
	
	public void closeFile() {
		try {
			workbook.close();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
