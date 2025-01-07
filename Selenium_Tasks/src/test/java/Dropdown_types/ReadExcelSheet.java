package Dropdown_types;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelSheet {
	
	public static List<String> readExcel(String path, int sheetNO) throws BiffException, IOException {

		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = Workbook.getWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetNO);
		List<String> exe = new ArrayList<String>();
		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns; j++) {

				Cell cell = sheet.getCell(j, i);
				String contents = cell.getContents();

				exe.add(contents);
			}

		}
		return exe;
	}

}
