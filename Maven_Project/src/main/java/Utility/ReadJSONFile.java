package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSONFile {
    public static String readJSON(String path){
        //String filePath="/Users/rahat/Java/Maven_Project/src/main/resource";
        File f= new File(path);

        try{
            FileReader fileReader=new FileReader(f);
            char[] character=new char[(int)f.length()];
            fileReader.read(character);
            return  new String(character);

        }
        catch (IOException e) {
            System.out.println(e.getStackTrace());
            return  null;
        }
    }
}
