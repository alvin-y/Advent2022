import java.io.*;
import java.util.*;

public class advent8 {
    public static void main(String[] args) {
        String path = "a8input.txt";

        try {
            File file = new File(path);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  

            String line;            

            // P1 Idea: 
            // Top left to bottom right iteration to check top + left
            // Bottom right to top left iteration to check down + right
            // Mark visible trees by changing value in counted arr

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            while((line = br.readLine())!=null) {
                //Populate array
                ArrayList<Integer> row = new ArrayList<>();
                for (int i = 0 ; i < line.length(); i++) {
                    row.add(Integer.parseInt(String.valueOf(line.charAt(i))));
                }
                list.add(row);
            }
            fr.close();

            int l = list.get(0).size();
            int w = list.size();

            // Part 1
            // //Set max to -1 because all values are bigger
            int[] maxL = new int[l];
            Arrays.fill(maxL, -1);
            int maxW = -1;

            int[][] counted = new int[w][l];

            int count = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < l; j++) {
                    int curr = list.get(i).get(j);
                    if (maxL[j] < curr) {
                        if (counted[i][j] == 0) {
                            count++;
                            counted[i][j] = 1;
                        }
                        maxL[j] = curr;
                    }

                    if (maxW < curr) {
                        if (counted[i][j] == 0) {
                            count++;
                            counted[i][j] = 1;
                        }
                        maxW = curr;
                    }
                }
                maxW = -1;
            }

            Arrays.fill(maxL, -1);
            maxW = -1;
            for (int i = w-1; i > 0; i--) {
                for (int j = l-1; j > 0; j--) {
                    int curr = list.get(i).get(j);

                    if (maxL[j] < curr) {
                        if (counted[i][j] == 0) {
                            count++;
                            counted[i][j] = 1;
                        }
                        maxL[j] = curr;
                    }

                    if (maxW < curr) {
                        if (counted[i][j] == 0) {
                            count++;
                            counted[i][j] = 1;
                        }
                        maxW = curr;
                    }
                }
                maxW = -1;
            }
            System.out.println(count);

            // Part 2
            // Count in each dir by running loop in each edge at max
            int[][] scores = new int[w][l];
            int max = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < l; j++) {
                    int curr = list.get(i).get(j);

                    //Look up
                    int countUp = 0;
                    for (int x = i-1; x >= 0; x--) {
                        if (list.get(x).get(j) < curr) {
                            countUp++;
                        } else {
                            countUp++;
                            break;
                        }
                    }

                    //Look down
                    int countDown = 0;
                    for (int x = i+1; x < w; x++) {
                        if (list.get(x).get(j) < curr) {
                            countDown++;
                        } else {
                            countDown++;
                            break;
                        }
                    }

                    //Look left
                    int countLeft = 0;
                    for (int x = j-1; x >= 0; x--) {
                        if (list.get(i).get(x) < curr) {
                            countLeft++;
                        } else {
                            countLeft++;
                            break;
                        }
                    }

                    //Look right
                    int countRight = 0;
                    for (int x = j+1; x < l; x++) {
                        if (list.get(i).get(x) < curr) {
                            countRight++;
                        } else {
                            countRight++;
                            break;
                        }
                    }

                    scores[i][j] = countUp * countDown * countLeft * countRight;
                    if (max < scores[i][j]) max = scores[i][j];
                }
            }
            System.out.println(max);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
