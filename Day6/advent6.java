import java.io.*;
import java.util.*;

public class advent6 {
    public static void main(String[] args) {
        String path = "a6input.txt";

        try {
            File file = new File(path);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  

            String line;
            
            while((line = br.readLine())!=null) {  
                // Idea sliding window with a hash to make sure that the characters are unique
                // Option 1: Iterate through substring and hashset
                // Option 2: Iterate through hashset and count how many keys until 14 unique and then add and remove as we move the window
                // Part 1 sets p2 = 4
                // Part 2 sets p2 = 14 
                int p1 = 0, p2 = 14, max = line.length();
                while (p1 < max && p2 < max) {
                    if (checkUnique(line.substring(p1, p2)) == false) {
                        p1++;
                        p2++;
                    } else {
                        System.out.println(p2);
                        break;
                    }
                }   
            }
            fr.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static boolean checkUnique(String sub) {
        HashSet<Character> map = new HashSet<Character>();
        for (char c : sub.toCharArray()) {
            if (map.contains(c)) {
                return false;
            } else {
                map.add(c);
            }
        }
        return true;
    }
}
