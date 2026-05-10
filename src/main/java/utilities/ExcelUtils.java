package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Object[][] readExcel(String path,String sheetname) {
		Object [][]data=null;
		try {
			FileInputStream fis =new FileInputStream(path);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet =wb.getSheet(sheetname);
			int row=sheet.getPhysicalNumberOfRows();
			int col=sheet.getRow(0).getPhysicalNumberOfCells();
			data=new Object[row-1][col];
			for(int i=1;i<row;i++) {
				for(int j=0;j<col;j++) {
					data[i-1][j]=sheet.getRow(i).getCell(j).toString();
				}
			}
			
			
		} catch (Exception e) {
			
		}
		return data;
	}

}
