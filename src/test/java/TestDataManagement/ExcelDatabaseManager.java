package TestDataManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/*
Example Database query

SELECT mtn.*
FROM (
    SELECT [patient_key], [rendering_provider_key]
   FROM [claim_detail$]
    WHERE [cpt_hcpcs_proc_cd] IN ('82330', '82374', '82435', '82565', '82947', '84132', '84295', '84520')
 */


public class ExcelDatabaseManager {

    String excelPath = "src/test/java/TestDataManagement/ExcelData/automationExample.xlsx";
    String query = "SQL QUERY GOES HERE";


    //query an excel file

    public  HashMap<Integer,HashMap<String,String>> queryExcel (String sheetName,String query) {
        int x = 0;
        HashMap<Integer,HashMap<String,String>> hmap = new HashMap<Integer,HashMap<String,String>>();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};" +
                            "Dbq="+query+";");


            PreparedStatement s = conn.prepareStatement(query);

            s.execute();
            ResultSet rs = s.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            if (rs!=null) {
                while (rs.next()) {
                    HashMap<String,String> value = new HashMap<String,String>();
                    value.put(rsmd.getColumnName(x), rs.getString(x));
                    hmap.put(x, value);

                }
            }
            s.close();

            conn.close();
        } catch( Exception e ) {
            e.printStackTrace();
            return null;
        }
        return hmap;
    }


    //****** query a database

    public  HashMap<Integer,HashMap<String,String>> queryDB (String dbConString,String query) {
        int x = 0;
        HashMap<Integer,HashMap<String,String>> hmap = new HashMap<Integer,HashMap<String,String>>();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(dbConString+query+";");

            PreparedStatement s = conn.prepareStatement(query);

            s.execute();
            ResultSet rs = s.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            if (rs!=null) {
                while (rs.next()) {
                    HashMap<String,String> value = new HashMap<String,String>();
                    value.put(rsmd.getColumnName(x), rs.getString(x));
                    hmap.put(x, value);

                }
            }
            s.close();

            conn.close();
        } catch( Exception e ) {
            e.printStackTrace();
            return null;
        }
        return hmap;
    }

}
