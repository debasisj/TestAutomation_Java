package com.dbschenker.framework.utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtil {

    private static Sheet wrksheet;
    private static Workbook wrkbook =null;
    private static Hashtable dict= new Hashtable();
    //Create a Constructor
    public ExcelUtil(String excelSheetPath, String sheetName) throws BiffException, IOException
    {
        //Initialize
        wrkbook = Workbook.getWorkbook(new File(excelSheetPath));
        //For Demo purpose the excel sheet path is hardcoded, but not recommended :)
        wrksheet = wrkbook.getSheet(sheetName);
        ColumnDictionary();
    }

    //Returns the Number of Rows
    public static int RowCount()
    {
        return wrksheet.getRows();
    }

    //Returns the Cell value by taking row and Column values as argument
    private static String ReadCell(int column,int row)
    {
        return wrksheet.getCell(column,row).getContents();
    }

    /*
    method overloading
         */
    public static String ReadCell(String columnName, int rowNum){
        return ReadCell(GetCell(columnName),rowNum);
    }

    //Create Column Dictionary to hold all the Column Names
    private static void ColumnDictionary()
    {
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        for(int col=0;col < wrksheet.getColumns();col++)
        {
            dict.put(ReadCell(col,0), col);
        }
    }

    //Read Column Names
    private static int GetCell(String colName)
    {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);

        }
    }
}
