package utilities;

import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {
//    public static
    @DataProvider(name = "data-provider-users")
    public Object[][] getDataObject(){
        return getDataFromCSV(getData("DDTFile"));
    }
    public static List<String> readCSV(String csvFile){
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

    public static Object[][] getDataFromCSV(String filePath) {
        Object[][] data = new Object[6][2];
        List<String> csvData = readCSV(filePath);
        for (int i = 0; i < csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

}
