
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
// import java.io.FileWriter;
// import java.io.IOException;
import java.io.*;
import java.io.FileInputStream;

// import java.io.File;



public class test1 {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING = null;
    // public static String TEST_XML_STRING =
    //  "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

    public static void main(String[] args) throws IOException {
        
        
            File file = new File(args[0]);
            FileInputStream fin = new FileInputStream(file);
            byte[] xmlData = new byte[(int) file.length()];
            
            fin.read(xmlData);
            fin.close();
            TEST_XML_STRING = new String(xmlData, "UTF-8");
            // System.out.println(TEST_XML_STRING);
            
        // }catch (JSONException je) {
        //     System.out.println(je.toString());
        // }
        try{
            

            
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }
}
