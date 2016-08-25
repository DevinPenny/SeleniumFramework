package TestDataManagement;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelManager {

    public List<List<String>> readFromFile(String fileName) {

        List<List<String>> table = new ArrayList<List<String>>();

        try {
            FileInputStream file = new FileInputStream(new File(fileName));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()){
                List<String> rowData = new ArrayList<String>();

                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        case Cell.CELL_TYPE_STRING:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        }
                    }
                    table.add(rowData);
                }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return table;
    }

}