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
        boolean fileContentCheck=false;

        long fileSize=file.length()/1000;
        //System.out.println(fileSize);
        if (fileSize<=256){
            fileSizeCheck=true;
        }
        //System.out.println("fileSizeCheck "+fileSizeCheck);


        if(fileSizeCheck){
            List<String> list=new ArrayList<>();
            Scanner scanner=new Scanner(file);
            int i=0;
            while(scanner.hasNext()){
                list.add(i, scanner.next());
                i++;
            }
            scanner.close();
            //System.out.println(list);
            //System.out.println(list.size());
            if(list.size()==2){
                fileContentCheck=true;
            }
            //System.out.println("fileContentCheck #1 "+fileContentCheck);


            if(fileContentCheck){
                String s1=list.get(0);
                String s2=list.get(1);
                List<String> list1=Arrays.asList(s1.split(""));
                List<String> list2=Arrays.asList(s2.split(""));
                //System.out.println(list1);
                //System.out.println(list2);

                String a1;
                String a2;
                for(i=0; i<list1.size(); i++){
                    a1=list1.get(i);
                    if(a1.equals("G") || a1.equals("T") || a1.equals("A") || a1.equals("C")){

                    } else {
                        fileContentCheck=false;
                        break;
                    }
                }

                if(fileContentCheck){
                    for(i=0; i<list2.size(); i++){
                        a1=list2.get(i);
                        if(a1.equals("G") || a1.equals("T") || a1.equals("A") || a1.equals("C")){

                        } else {
                            fileContentCheck=false;
                            break;
                        }
                    }
                }

                //System.out.println("fileContentCheck #2 "+fileContentCheck);


                if(fileContentCheck){

                    int count=0;
                    for(i=0; i<list1.size(); i++){
                        a1=list1.get(i);
                        for(int j=i; j<list2.size(); j++){
                            a2=list2.get(j);
                            if(a2.equals(a1)){
                                count++;
                                break;
                            }
                        }
                    }
                    //System.out.println(count);

                    PrintWriter writer=new PrintWriter("output.txt");
                    if(count==list1.size()){
                        //System.out.println("YES");
                        writer.println("YES");
                    } else {
                        //System.out.println("NO");
                        writer.println("NO");
                    }
                    writer.close();




                }




            }




        }




    }


}
