import java.io.*;
import org.openmrs.*;
public class CohortUnionDriver{
  public static void main(String args[]) {
        //String fileName = args[1];
        String fileName = "testCase1.txt";
        System.out.println("test");
        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(line.substring(0,6).equals("Inputs")){

                    String tempA = line.substring(line.indexOf('[',0),line.indexOf(']',1)+1);
                    String tempB = line.substring(line.indexOf('[',line.indexOf('[',0)+1),line.indexOf(']',line.indexOf(']',1)+1)+1);
                    int nA = (tempA.length() -2)/2 + ((tempA.length() % 2 == 0) ? 0 : 1);
                    int nB = (tempB.length() -2)/2 + ((tempB.length() % 2 == 0) ? 0 : 1);
                    Integer[] a = new Integer[nA];
                    int[] b = new int[nB];

                    for(int ch = 1; !tempA.substring(ch,ch+1).equals("]"); ch++){
                        if(!tempA.substring(ch,ch+1).equals(",")){
                            a[ch/2]=Integer.valueOf(tempA.substring(ch,ch+1));
                        }
                    }

                    for(int ch = 1; !tempB.substring(ch,ch+1).equals("]"); ch++){
                        if(!tempB.substring(ch,ch+1).equals(",")){
                            b[ch/2]=Integer.valueOf(tempB.substring(ch,ch+1));
                        }
                    }

                    String stringA = new String("a");
                    Cohort cohortA = new Cohort(stringA, stringA, a);
                    //Cohort cohortB = new Cohort("b", "b", b);
                    System.out.println("here");
                    try {
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("../reports/results.txt", true)));
                        out.println(args[1]);
                        out.println("<br>");
                        Set<Integer> c = new HashSet<Integer>();
                        c = cohortC.memberIDs;
                        Integer[] arrC = new Integer[c.size()];
                        count = 0;
                        for(i : c){
                            arrC[count++]=i; //http://stackoverflow.com/questions/7123580/problems-converting-set-of-integers-to-int-array
                        }
                        if(Array.deepEquals(arrC,arrO)){
                            out.println("Pass<br>");
                        }
                        else {
                            out.println("Fail<br>");
                        }
                        out.println();
                        
                        out.println("testing<br>");
                        out.close();
                        //print the oracle, etc.
                    } catch (IOException e) {
                        System.out.println("IOWriteException");                  

                    }
                    
                }
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException");                
        }
        catch(IOException ex) {
            System.out.println("IOReadException");                  
        }
  }
}