import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Pazuk on 30.01.2018.
 */
public class Main {


    public static void main(String[] args) throws FileNotFoundException {


        File file=new File("input.txt");
        boolean fileSizeCheck=false;

        long fileSize=file.length()/1000;
        if (fileSize<=256){
            fileSizeCheck=true;
        }

        if(fileSizeCheck){
            Scanner scanner=new Scanner(file);
            int i=0;
            String s1=scanner.next();
            String s2=scanner.next();
            scanner.close();

            char[] s=s1.toCharArray();
            char[] t=s2.toCharArray();
            char a1;
            char a2;

            int count=0;
            for(i=0; i<s.length; i++){
                a1=s[i];
                for(int j=i; j<t.length; j++){
                    a2=t[j];
                    if(a2==a1){
                        count++;
                        break;
                    }
                }
            }

            PrintWriter writer=new PrintWriter("output.txt");
            if(count==s.length){
                writer.println("YES");
            } else {
                writer.println("NO");
            }
            writer.close();

        }
    }
}
