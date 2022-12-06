import java.io.*;
import java.util.*;

public class advent3 {
    public static void main(String[] args) {
        String path = "a3input.txt";

        try {
            File file = new File(path);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  

            String line;  
            int priority = 0;

            ArrayList<Character> priorityChar = new ArrayList<Character>();
            while((line = br.readLine())!=null) {  
                //PART 1
                // String block1 = line.substring(0, (line.length()/2));
                // String block2 = line.substring(line.length()/2);

                // HashSet<Character> set = new HashSet<Character>();
                
                // for(int i = 0; i < block1.length(); i++) {
                //     set.add(block1.charAt(i));
                // }

                // for(int j = 0; j < block2.length(); j++) {
                //     char temp = block2.charAt(j);
                //     if (set.contains(temp)) {
                //         priorityChar.add(temp);
                //         break; 
                //     }
                // }

                //PART 2
                //Idea: if we do the same as above but keep a new hash of matching between set 1 and 2, then compare with set 3; only 1 should match
                String blockA = line;
                String blockB = br.readLine();
                String blockC = br.readLine();

                HashSet<Character> blockASet = new HashSet<Character>();
                HashSet<Character> blockABSet = new HashSet<Character>();
                for (int i = 0; i < blockA.length(); i++) {
                    blockASet.add(blockA.charAt(i));
                }
                for (int j = 0; j < blockB.length(); j++) {
                    char temp = blockB.charAt(j);
                    if (blockASet.contains(temp)) {
                        blockABSet.add(temp);
                    }
                }
                for (int k = 0; k < blockC.length(); k++) {
                    char temp = blockC.charAt(k);
                    if (blockABSet.contains(temp)) {
                        priorityChar.add(temp);
                        break;
                    }
                }
            }
            fr.close();

            //Convert capitals by +32/-32
            for (char c : priorityChar) {
                //If upper case, change to lower and then calculate points; use ascii value
                if (c >= 'A' && c < 'a') {
                    priority += (((int)c + 32) - 70);
                } else {
                    priority += (((int)c - 32) - 64);
                }
            }

            System.out.println(priority); 
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}