package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchData {
	public static String DataProvider(int row,int colum) throws EncryptedDocumentException, IOException {
		String data ="";
		String path = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestExcelFile"+File.separator+"TestPOi.xlsx";
		FileInputStream file = new FileInputStream(path);
		Sheet dSheet= WorkbookFactory.create(file).getSheet("TestDataSheet");
		Cell cell=dSheet.getRow(row).getCell(colum);
		CellType typeCellType=cell.getCellType();
		if (typeCellType==CellType.STRING) {
			data = cell.getStringCellValue();
		}
		else if (typeCellType==CellType.NUMERIC) {
		  double number = cell.getNumericCellValue();
		  data = Double.toString(number);
		}
		else if (typeCellType ==CellType.BLANK) {
			data="";
		}
		return data;
		
	}
}
