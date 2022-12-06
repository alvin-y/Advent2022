import java.io.*;

public class advent4 {
    public static void main(String[] args) {
        String path = "a4input.txt";

        try {
            File file = new File(path);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  

            String line;  
            int covered = 0;

            while((line = br.readLine())!=null) {  
                String[] lineSplit = line.split(",");
                String[] range1s = lineSplit[0].split("-");
                String[] range2s = lineSplit[1].split("-");
                int[] range1 = new int[]{ Integer.parseInt(range1s[0]), Integer.parseInt(range1s[1]) };
                int[] range2 = new int[]{ Integer.parseInt(range2s[0]), Integer.parseInt(range2s[1]) };

                // PART 1
                if (range1[0] < range2[0]) { //Range 1 lower
                    if (range1[1] >= range2[1]) {
                        covered++;
                    }
                } else if (range2[0] < range1[0]){ //Range 2 lower
                    if (range2[1] >= range1[1]) {
                        covered++;
                    }
                } else { //Equal
                    covered++;
                }

                // PART 2
                if (range1[0] < range2[0]) { //Range 1 lower 
                    if (range1[1] >= range2[0] || range1[1] >= range2[1]) {
                        covered++;
                    }
                } else if (range2[0] < range1[0]){ //Range 2 lower
                    if (range2[1] >= range1[0] || range2[1] >= range1[1]) {
                        covered++;
                    }
                } else { //Equal
                    covered++;
                }
            }
            fr.close();

            System.out.println(covered); 
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}