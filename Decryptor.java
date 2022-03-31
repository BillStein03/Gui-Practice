import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @author Bill Stein 3714982
 */



public class Decryptor {

    public static void main(String args[]) throws FileNotFoundException {

        File text = new File("C:/Users/bills/OneDrive/Documents/UNB Classes/CS_1073/Assignments/Assignment 12/As12-Files/As12-Files/cypherText.in");
        
        Scanner scnr = new Scanner(text);

        
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            int count = 0;

            if (count % 2 == 0) {
                count++;
                int x = Integer.parseInt(line);
                String fill = scnr.nextLine();
                int c = fill.length();
                int y = c / x;
                char[ ][ ] a = new char[y][x];

                for (int i = 0; i < fill.length(); i++) {
                    int b = 0;
                    int intf=0;
                    int z =0;
                    if (z > x){
                        z=0;
                        b++; 
                        intf=0;
                    
                    }
                    else{
                        z++;
                        a[z][b] = fill.charAt(x-intf);
                        intf++;
                    }


                }
                
                
            System.out.println(Arrays.toString(a));
            }
            else{
                count++;
            }
        
        }





    }
}