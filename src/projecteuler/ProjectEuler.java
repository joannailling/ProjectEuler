/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author jmilling
 */
public class ProjectEuler {

    public void Problem1(int max) {
    /*  If we list all the natural numbers below 10 that are multiples of 
        3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
      
        Find the sum of all the multiples of 3 or 5 below 1000. */
        
        int sum = 0;
        for (int i = 0; i < max; i++){
            if (i%3 == 0) {
                sum += i;
            }
            else if (i%5 == 0){
                sum += i;
            }
        }        
        System.out.println("Problem 1 Sum: " + sum);
    }

    public void Problem2(int max) {
    /*  Each new term in the Fibonacci sequence is generated by adding the previous 
        two terms. By starting with 1 and 2, the first 10 terms will be:
        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
        
        By considering the terms in the Fibonacci sequence whose values do not 
        exceed four million, find the sum of the even-valued terms. */

        int fib1 = 0;
        int fib2 = 1;
        int sum = 0;
        
        while (fib1 < max) {
            //System.out.println(fib1 + " " + fib2);
            
            if (fib1 % 2 == 0) {
                sum += fib1;
            }
                          
            int temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;            
        }
        System.out.println("Problem 2 Sum: " + sum);
    }
    
    public void Problem3(long num) {    
    /*  The prime factors of 13195 are 5, 7, 13 and 29.
        What is the largest prime factor of the number 600851475143 ? */
        
        Helpers h = new Helpers();
        ArrayList<Long> factors = h.primeFactors(num);
        long max = Collections.max(factors);
        
        System.out.println("Problem 3 Max Prime Factor: " + max);
    
    
    }
    
    public void Problem4(int digits) {
        int a = (int)Math.pow(10, digits) - 1;
        int b = (int)Math.pow(10, (digits -1 ));
       // System.out.println("Max: " + a + ", Min: " + b);
        
        int highest = 1;
        int h1 = 1;
        int h2 = 1;
        int product;
        boolean w;
        Helpers h = new Helpers();
        
        for (int i = a; i >= b; i--) {
            for (int j = a; j >= b; j--) {
                product = i * j;
                w = h.isPalindrome(String.valueOf(product));
                if (w == true) {
                    if (product > highest) {
                        highest = product;   
                        h1 = i;
                        h2 = j;
                        //System.out.println(i + " * " + j + " = " + highest);
                    }
                }
            }
        }
        
        System.out.println("Problem 4: " + h1 + " * " + h2 + " = " + highest );
        
       
        
        
    }
    
    public void Problem5(int number) {
        
        ArrayList<Integer> allFactors = new ArrayList();
        
    /*  For each # from 1 to param number, get prime factors (inc duplicates)
        and make sure allFactors contains the list        
        */
        for(int i = 1; i <= number; i ++) {
            
            ArrayList<Integer> factors = new ArrayList();
            int top = i;
            int b = 2;
            
            while (b <= top) {
                if (top % b == 0) {
                    factors.add(b);
                    top /= b;
                    b -= 1;
                }
                b += 1;
            }
            
            // For each factor in the factor list, make sure same number of
            // occurrences exist in allFactors list. If less, add until same 
            for (int j = 0; j < factors.size(); j++) {
                int o1 = Collections.frequency(factors, factors.toArray()[j]);
                int o2 = Collections.frequency(allFactors, factors.toArray()[j]);
                while (o2 < o1) {
                    allFactors.add((Integer) factors.toArray()[j]);
                    o2 = Collections.frequency(allFactors, factors.toArray()[j]);
                }
            }
        }
        
        // Multiply #s in allFactors together to get smallest possible multiple
        int total = 1;
            for (int k = 0; k < allFactors.size(); k++) {
                total = total * ((Integer)allFactors.toArray()[k]);
            } 
        
        Collections.sort(allFactors);
        System.out.println("Problem 5: " + allFactors.toString() + " = " + total);
    }
       
    public void Problem6(int number) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= number; i++) {
            sum1 +=  (int) Math.pow(i, 2);
            sum2 += i;
        }
        sum2 = (int)Math.pow(sum2, 2);
        //System.out.println(sum1);
        //System.out.println(sum2);
        System.out.println("Problem 6: " + sum2 + " - " + sum1 + " = " + (sum2 - sum1));
    }
    
    public void Problem7(int number) {
        /* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can 
           see that the 6th prime is 13. What is the 10001st prime number?
        */
        

        
    }
    
    public static void main(String[] args) {
 
        ProjectEuler p = new ProjectEuler();
        
      //  p.Problem1(1000);
      //  p.Problem2(4000000);
      //  p.Problem3(600851475143L);
      //  p.Problem4(3);
      //  p.Problem5(20);
      //  p.Problem6(100);
        p.Problem7(60);
      
       
  
        
    }
    
}
