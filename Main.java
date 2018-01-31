import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Pazuk on 30.01.2018.
 */

// Main idea:
// from two lines from the file create two arrays. From first array take
// letters one by one and scan second array if it have same letters (and at the same order)
// and count em. If counted letters==all letters of first array->
// ->first array is parent of second one->YES. Else->NO. To follow the same letters order,
// every time start next iteration of scanning of the second array from next index
//
// Additionally:
// 1. Second array should be at least the same length as first one. Or be longer then first one.
// Else it's impossible for first array to be parent for second array.
// 2. Take into account if in the file one line is empty and give logically
// right answers for both of these cases

public class Main {
    private static File file;
    private static PrintWriter writer;

    private static int i=0;
    private static int j=0;
    private static int count=0; // create counter

    private  static String s;
    private static String t;

    private  static char[] sArray; // create first array
    private  static char[] tArray; // create second array

    public static void main(String[] args) throws FileNotFoundException {

        file=new File("input.txt");
        writer=new PrintWriter("output.txt");

        scanFile(); // scan input file

        sArray=s.toCharArray(); // first array from first line from file
        tArray=t.toCharArray(); // second array from second line from file

        if(sArray.length==0){ // if first line in file is empty
            writer.println("YES");
            writer.close();
        }
        else if( sArray.length!=0 && tArray.length==0){ // and if second line is empty
            writer.println("NO");
            writer.close();
        } else {
            if (tArray.length>=sArray.length){ // check if second array have > or same length than first one
                mainPaternityTest(); // if yes, implement paternity test based on main idea

            } else {
                writer.println("NO");
                writer.close();
            }
        }

    }

    static void scanFile() throws FileNotFoundException { //scan input file
        Scanner scanner=new Scanner(file);
        List<String> list=new ArrayList<>();
        while(scanner.hasNextLine()){
            list.add(i, scanner.nextLine());
            i++;
        }

        s=list.get(0);
        t=list.get(1);
        scanner.close();
    }

    static void mainPaternityTest(){ // implement main idea

        for(i=0; i<sArray.length; i++){
            while(j<tArray.length){
                if(tArray[j]==sArray[i]){ // check if letter from first array is the same as in second array
                    j++; // start next iteration of scanning from next index
                    count++; // if the same - count it
                    break;
                }
                j++; // start next iteration of scanning from next index
            }
        }
        if(count==sArray.length){
            writer.println("YES"); // print answer in output file
        } else {
            writer.println("NO");
        }
        writer.close();
    }


}