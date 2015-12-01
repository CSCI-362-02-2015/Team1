import java.io.*;
import java.util.*;

public class CohortSubtractDriver{
  public static void main(String args[]) {

        String input = args[0];
        String output = args[1];

        Cohort cohortA = new Cohort("a", "a", CohortSubtractDriver.getFirstArray(input));
        Cohort cohortB = new Cohort("b", "b", CohortSubtractDriver.getSecondArray(input));  
        Integer[] expected = CohortSubtractDriver.getFirstArray(output);
            
        Cohort cohortResult = Cohort.subtract(cohortA, cohortB);
        Integer[] result = cohortResult.getMemberIds().toArray(new Integer[cohortResult.getMemberIds().size()]);
        
        if(CohortSubtractDriver.arrayEquality(result,expected)){
            System.out.println("Passed");
        } else{
            System.out.println("Failed");
        }

  }

public static Integer[] getFirstArray(String input){
    int len=1;
    Integer[] array;
    String temp = input.substring(input.indexOf('[',0),input.indexOf(']',1)+1);

    if(temp.length() == 2){
        len=0;
    } else{
        for(int ch=1; ch < temp.length(); ch++){
            if(temp.substring(ch,ch+1).equals(",")){
                len++;
            }
        }
    }

    array = new Integer[len];
    int count = 0;
    String num = new String("");

    if(len!=0){
        for(int ch = 1; ch < temp.length(); ch++){
            if(!temp.substring(ch,ch+1).equals(",") && !temp.substring(ch,ch+1).equals("]")){
                num += temp.substring(ch,ch+1);
            } else{
                array[count]=Integer.valueOf(num);
                count++;
                num = "";
            }
        }
    }
    return array;
  }

public static Integer[] getSecondArray(String input){
    String temp = input.substring(input.indexOf('[',input.indexOf('[',0)+1),input.indexOf(']',input.indexOf(']',1)+1)+1);
    int len=1;
    Integer[] array;
    
    if(temp.length() == 2){
        len=0;
    } else{
        for(int ch=1; ch < temp.length(); ch++){
            if(temp.substring(ch,ch+1).equals(",")){
                len++;
            }
        }
    }

    array = new Integer[len];
    int count = 0;
    String num = new String("");

    if(len!=0){
        for(int ch = 1; ch < temp.length(); ch++){
            if(!temp.substring(ch,ch+1).equals(",") && !temp.substring(ch,ch+1).equals("]")){
                num += temp.substring(ch,ch+1);
            } else{
                array[count]=Integer.valueOf(num);
                count++;
                num = "";
            }
        }
    }
    return array;
  }

public static boolean arrayEquality(Integer[] array1, Integer[] array2){
    boolean found = false;
    if(array1.length == 0 && array2.length == 0){
        found = true;
    } else if (array1.length == array2.length){
        for(int i=0; i<array1.length; i++){
            found = false;
            for(int j=0; j<array2.length; j++){
                if(array1[i].equals(array2[j])){
                    found=true;
                    break;
                }
            }
            if(!found){
                break;
            }
        }
    } else{
        found=false;
    }
    return found;
}

}