import java.io.*;
import java.util.*;
//import org.openmrs.*;

public class CohortUnionDriver{
  public static void main(String args[]) {
        String fileName = args[0];
        String line = null;
        Cohort2 cohortA;
        Cohort2 cohortB;
        Cohort2 result;
        Integer[] expected;
       	String input = args[1];
        String output = args[2];

        String strA = new String("a");
        String strB = new String("b");
        cohortA = new Cohort2(strA, strA, CUD.getFirstArray(input));
        cohortB = new Cohort2(strB, strB, CUD.getSecondArray(input));  
        expected = CUD.getFirstArray(output);
            
        result = Cohort2.union(cohortA, cohortB);
        Integer[] test = result.getMemberIds().toArray(new Integer[result.getMemberIds().size()]);
        if(Arrays.deepEquals(test, expected)){
        	System.out.println("Passed");
        } else{
        	System.out.println("Failed");
        }

  }

public static Integer[] getFirstArray(String input){
 	String temp = input.substring(input.indexOf('[',0),input.indexOf(']',1)+1);
    int n = (temp.length() -2)/2 + ((temp.length() % 2 == 0) ? 0 : 1);
    Integer[] array = new Integer[n];

    for(int ch = 1; !temp.substring(ch,ch+1).equals("]"); ch++){
        if(!temp.substring(ch,ch+1).equals(",")){
            array[ch/2]=Integer.valueOf(temp.substring(ch,ch+1));
        }
    }
    return array;
  }

public static Integer[] getSecondArray(String input){
 	String temp = input.substring(input.indexOf('[',input.indexOf('[',0)+1),input.indexOf(']',input.indexOf(']',1)+1)+1);
    int n = (temp.length() -2)/2 + ((temp.length() % 2 == 0) ? 0 : 1);
    Integer[] array = new Integer[n];

    for(int ch = 1; !temp.substring(ch,ch+1).equals("]"); ch++){
        if(!temp.substring(ch,ch+1).equals(",")){
            array[ch/2]=Integer.valueOf(temp.substring(ch,ch+1));
        }
    }
    return array;
  }

}