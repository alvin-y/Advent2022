import java.io.*;
import java.util.*;

public class advent1 {
    public static void main(String[] args) {
        String path = "a1input.txt";

        List<Integer> elves = new ArrayList<Integer>();

        try {
            File file = new File(path);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  

            String line;  
            int sum = 0;
            while((line = br.readLine())!=null) {  
                if (line.equals("")) {
                    elves.add(sum);
                    sum = 0;
                } else { 
                    sum += Integer.parseInt(line);
                }
            }  
            fr.close();    //closes the stream and release the resources  
        } catch (Exception e) {
            System.err.println(e);
        }

        Collections.sort(elves);
        //Part 1
        System.out.println(elves.get(elves.size() - 1));

        //Part 2
        System.out.println(elves.get(elves.size() - 1) + elves.get(elves.size() - 2) + elves.get(elves.size() - 3));
    }
}