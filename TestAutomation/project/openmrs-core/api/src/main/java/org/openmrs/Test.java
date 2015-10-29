/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs;

/**
 *
 * @author daniel
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Integer[] arrA = new Integer[] {1,2,3,4};
        String strA = new String("a");
        Cohort cohortA = new Cohort(strA, strA, arrA);
        System.out.println("success");
    }
    
}
