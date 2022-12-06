import java.io.*;
import java.util.*;

public class advent5 {
    public static void main(String[] args) {
        String path = "a5input.txt";

        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        Stack<Character> stack3 = new Stack<Character>();
        Stack<Character> stack4 = new Stack<Character>();
        Stack<Character> stack5 = new Stack<Character>();
        Stack<Character> stack6 = new Stack<Character>();
        Stack<Character> stack7 = new Stack<Character>();
        Stack<Character> stack8 = new Stack<Character>();
        Stack<Character> stack9 = new Stack<Character>();

        stack1.push('N');
        stack1.push('R');
        stack1.push('G');
        stack1.push('P');

        stack2.push('J');
        stack2.push('T');
        stack2.push('B');
        stack2.push('L');
        stack2.push('F');
        stack2.push('G');
        stack2.push('D');
        stack2.push('C');

        stack3.push('M');
        stack3.push('S');
        stack3.push('V');

        stack4.push('L');
        stack4.push('S');
        stack4.push('R');
        stack4.push('C');
        stack4.push('Z');
        stack4.push('P');

        stack5.push('P');
        stack5.push('S');
        stack5.push('L');
        stack5.push('V');
        stack5.push('C');
        stack5.push('W');
        stack5.push('D');
        stack5.push('Q');

        stack6.push('C');
        stack6.push('T');
        stack6.push('N');
        stack6.push('W');
        stack6.push('D');
        stack6.push('M');
        stack6.push('S');

        stack7.push('H');
        stack7.push('D');
        stack7.push('G');
        stack7.push('W');
        stack7.push('P');

        stack8.push('Z');
        stack8.push('L');
        stack8.push('P');
        stack8.push('H');
        stack8.push('S');
        stack8.push('C');
        stack8.push('M');
        stack8.push('V');

        stack9.push('R');
        stack9.push('P');
        stack9.push('F');
        stack9.push('L');
        stack9.push('W');
        stack9.push('G');
        stack9.push('Z');
        
        ArrayList<Stack<Character>> stackArr = new ArrayList<Stack<Character>>();
        stackArr.add(stack1);
        stackArr.add(stack2);
        stackArr.add(stack3);
        stackArr.add(stack4);
        stackArr.add(stack5);
        stackArr.add(stack6);
        stackArr.add(stack7);
        stackArr.add(stack8);
        stackArr.add(stack9);
/*
        [C]         [Q]         [V]    
        [D]         [D] [S]     [M] [Z]
        [G]     [P] [W] [M]     [C] [G]
        [F]     [Z] [C] [D] [P] [S] [W]
    [P] [L]     [C] [V] [W] [W] [H] [L]
    [G] [B] [V] [R] [L] [N] [G] [P] [F]
    [R] [T] [S] [S] [S] [T] [D] [L] [P]
    [N] [J] [M] [L] [P] [C] [H] [Z] [R]
    1   2   3   4   5   6   7   8   9 
 */

        try {
            File file = new File(path);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  

            String line;  
            Stack<Character> tempStack = new Stack<Character>();

            while((line = br.readLine())!=null) {  
                String[] lineArr = line.split(" ");
                int moveHowMany = Integer.parseInt(lineArr[1]);
                int moveFrom = Integer.parseInt(lineArr[3]);
                int moveTo = Integer.parseInt(lineArr[5]);
                
                //PART 1
                // for (int i = 0; i < moveHowMany; i++) {
                //     stackArr.get(moveTo - 1).push(stackArr.get(moveFrom - 1).pop());
                // }

                // PART 2
                for (int i = 0 ; i < moveHowMany; i++) {
                    tempStack.push(stackArr.get(moveFrom - 1).pop());
                }
                while(!tempStack.isEmpty()) {
                    stackArr.get(moveTo - 1).push(tempStack.pop());
                }
            }
            fr.close();

            for(Stack<Character> s : stackArr) {
                System.out.print(s.peek());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}