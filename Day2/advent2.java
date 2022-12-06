import java.io.*;
import java.util.*;

public class advent2 {
    public static void main(String[] args) {
        String path = "a2input.txt";

        //PART 1
        HashMap<String, Integer> outcomes = new HashMap<String, Integer>();
        outcomes.put("AX", 3);
        outcomes.put("AY", 6);
        outcomes.put("AZ", 0);
        outcomes.put("BX", 0);
        outcomes.put("BY", 3);
        outcomes.put("BZ", 6);
        outcomes.put("CX", 6);
        outcomes.put("CY", 0);
        outcomes.put("CZ", 3);

        //PART 2
        HashMap<String, Integer> outcomePoints = new HashMap<String, Integer>();
        outcomePoints.put("X", 0);
        outcomePoints.put("Y", 3);
        outcomePoints.put("Z", 6);

        try {
            File file = new File(path);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  

            String line;  
            int score = 0;

            while((line = br.readLine())!=null) {  
                String[] input = line.split(" ");
                // PART 1
                // if(input[1].equals("X")) score += 1;
                // else if (input[1].equals("Y")) score += 2;
                // else if (input[1].equals("Z")) score += 3; 
                // score += outcomes.get(line.replaceAll("\\s+",""));
                
                //PART 2
                if (input[0].equals("A") && input[1].equals("X")) score += 3;
                else if (input[0].equals("A") && input[1].equals("Y")) score += 1;
                else if (input[0].equals("A") && input[1].equals("Z")) score += 2;
                else if (input[0].equals("B") && input[1].equals("X")) score += 1;
                else if (input[0].equals("B") && input[1].equals("Y")) score += 2;
                else if (input[0].equals("B") && input[1].equals("Z")) score += 3;
                else if (input[0].equals("C") && input[1].equals("X")) score += 2;
                else if (input[0].equals("C") && input[1].equals("Y")) score += 3;
                else if (input[0].equals("C") && input[1].equals("Z")) score += 1;
                score += outcomePoints.get(input[1]);
            }  
            fr.close();

            System.out.println(score); 
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}