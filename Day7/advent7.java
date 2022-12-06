import java.io.*;
import java.util.*;

public class advent7 {
    public static void main(String[] args) {
        String path = "a7input.txt";

        try {
            File file = new File(path);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  

            String line;
            
            while((line = br.readLine())!=null) {  

            }
            fr.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
