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
            String filePath = "home/";
            
            HashMap<String, Integer> directorySizes = new HashMap<String, Integer>();
            //Changing the root directory to home/ so we can use this hashmap method
            directorySizes.put("home/", 0);

            while((line = br.readLine())!=null) {
                String[] filePathSplit = filePath.split("/");
                String[] lineSplit = line.split(" ");

                if (lineSplit[0].equals("$")) { // if command
                    if (lineSplit[1].equals("cd")) { //Check for cd
                        if (lineSplit[2].equals("..")) { //If go back, just remove the last added path
                            filePath = "";
                            for (int i = 0; i < filePathSplit.length - 1; i++) {
                                filePath += filePathSplit[i] + "/";
                            }
                        } else { //If go in
                            if (lineSplit[2].equals("/")) {
                                filePath = "home/";
                            } else {
                                filePath += (lineSplit[2] + "/"); //Add to path key
                                if(!directorySizes.containsKey(filePath)) { //Create map entry if doesn't already exist
                                    directorySizes.put(filePath, 0);
                                }
                            }
                        }
                    }
                } else { // if directory or file
                    if (lineSplit[0].equals("dir")) { //Directory
                        if(!directorySizes.containsKey(filePath + lineSplit[1] + "/")) { //Create map entry if doesn't already exist
                            directorySizes.put(filePath + lineSplit[1] + "/", 0);
                        }
                    } else {
                        String temp = "";
                        for (String p : filePathSplit) { //Add to all paths up from this one
                            temp += p + "/";
                            directorySizes.put(temp , directorySizes.get(temp) + Integer.parseInt(lineSplit[0]));
                        }
                    }
                }
            }

            //Part 1
            int part1Ans = 0;
            for (String key : directorySizes.keySet()) {
                if (directorySizes.get(key) <= 100000) part1Ans += directorySizes.get(key);
                // System.out.println(key + ": " + directorySizes.get(key));
            }

            System.out.println(part1Ans);

            //Part 2
            int threshold = Math.abs(40000000 - directorySizes.get("home/")); //What we're looking for
            int part2Ans = Integer.MAX_VALUE;
            for (String key : directorySizes.keySet()) {
                if (directorySizes.get(key) >= threshold && part2Ans >= directorySizes.get(key)) part2Ans = directorySizes.get(key);
                // System.out.println(key + ": " + directorySizes.get(key));
            }
            System.out.println(part2Ans);

            fr.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
