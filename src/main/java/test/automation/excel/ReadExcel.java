package test.automation.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadExcel {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("excelFiles/test.xlsx");
        LinkedList<Employee> employees = new LinkedList<>();

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {

                if (row.getRowNum() == 0)
                    continue;
                Employee employee = new Employee();

                for (Cell cell : row) {

                    switch (cell.getColumnIndex()) {
                        case 0:
                            employee.setEmployeeId((long) Double.parseDouble(cell.toString()));
                            break;

                        case 1:
                            employee.setName(cell.getStringCellValue());
                            break;

                        case 2:
                            employee.setSurname(cell.getStringCellValue());
                            break;

                        case 3:
                            employee.setAge((int) Double.parseDouble(cell.toString()));
                            break;

                        case 4:
                            employee.setSingle(cell.getBooleanCellValue());
                            break;

                        case 5:
                            employee.setBirthday(cell.getDateCellValue());
                            break;

                        default:
                            System.out.println("The cell \"" + sheet.getRow(0).getCell(cell.getColumnIndex()) + "\" is not mapped");
                    }
                }
                employees.add(employee);
            }
        }
        employees.forEach(employee -> {
            System.out.println(employee.toString());
        });
    }
}
