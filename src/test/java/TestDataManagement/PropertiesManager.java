package TestDataManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//the purpose of this class is to grab data from a properties file that can be used for testing

public class PropertiesManager {

    public String TestNameField = "";
    public String ExecutionStatus = "";
    public String Parameter1 = "";
    public String Parameter2 = "";

    public void GetData(){
        Properties data = new Properties();
        InputStream input = null;

        try{
            input = new FileInputStream("src/test/java/TestDataManagement/executeList.properties");
            data.load(input);

            TestNameField = data.get("TestField").toString();
            ExecutionStatus = data.get("ExecuteStatus").toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
