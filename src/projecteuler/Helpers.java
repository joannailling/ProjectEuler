package projecteuler;

import java.math.BigInteger;
import java.util.*;


public class Helpers {
       
    public boolean isPrime(BigInteger num) {
        ArrayList<BigInteger> factors = getFactors(num);
        if (factors.size() <= 2) {
            return true;
        }
        else { 
            return false;
        }     
    }
    
    public ArrayList getPrimeFactors(BigInteger num) {
        ArrayList<BigInteger> factors = new ArrayList();
        BigInteger i = new BigInteger("1");
        
        while (i.compareTo(num) < 0) {
            if (num.mod(i).compareTo(new BigInteger("0")) == 0) {
                ArrayList<Integer> ff = getFactors(i);
                if (ff.size() <= 2) {
                    factors.add(i);
                    System.out.println(i);
                }
            } 
            i = i.add(new BigInteger("1"));
            
        }
        return factors;
    }
    
    public ArrayList getFactors(BigInteger num){
        ArrayList<BigInteger> factors = new ArrayList();
        BigInteger i = new BigInteger("1");
        
        while (i.compareTo(num) <= 0) {
            if (num.mod(i).compareTo(new BigInteger("0")) == 0) {
               factors.add(i);
            } 
            i = i.add(new BigInteger("1"));
        }
        return factors;
        
    }
    
    public ArrayList getDigitFactors(int num, int d) {
        ArrayList<Integer> factors = new ArrayList();
        int i = (int)Math.pow(10, (d-1));
        int j = (int)Math.pow(10, d)-1;
        
        if (j > num) {
            j = num;
        }
       
        //System.out.print(i + " through " + j + ": ");
        
        while (i <= j) {
            if (num % i == 0) {
                factors.add(i);
            }
            i++;
        }
        //System.out.println(factors.toString());
        if (factors.isEmpty()) {
            System.out.println("Empty");
        }
        else {
            System.out.println(factors.toString());
        }
        return factors;
    }
    
    public static Set<BigInteger> primeFactors(BigInteger number) {
        Set<BigInteger> primefactors = new HashSet<>();
        BigInteger copyOfInput = number;
        BigInteger i;
        
        for (i = new BigInteger("2"); i.compareTo(copyOfInput) <= 0; i.add(new BigInteger("1"))) {
            System.out.println("i: " + i.toString());
            System.out.println("COI: " + copyOfInput.toString());
            System.out.println("***");
            if (copyOfInput.mod(i).equals(new BigInteger("0"))) {
                primefactors.add(i);
                copyOfInput = copyOfInput.divide(i);
                i = i.subtract(new BigInteger("1"));
            }
            
        }
        
        return primefactors;
    }
    
    public ArrayList<Long> primeFactors(long number) {
        ArrayList<Long> primefactors = new ArrayList<>();
        long copyOfInput = number;
        
        for (long i=2; i <= copyOfInput; i++) {
            //System.out.println("***");
            //System.out.println("i: " + i);
            //System.out.println("COI: " + copyOfInput);
         
            if (copyOfInput %i == 0) {
                primefactors.add(i);
                //System.out.println(primefactors.toString());
                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }
    
    public boolean isPalindrome(String input) {
        boolean whether = true;
        int lo = 0;
        int hi = input.length()-1;
        
        while (lo <= hi && whether == true) {
        //    System.out.println("\nlo " + lo + " " + input.charAt(lo) + "\nhi: " + hi+ " " +  input.charAt(hi));  
        //  if (input.charAt(lo) != input.charAt(hi)) { 
            if (!String.valueOf(input.charAt(lo)).equalsIgnoreCase(String.valueOf(input.charAt(hi)))){
                whether = false;
            }
            lo++;
            hi--;
        }
        return whether;
    }
    
    public static void main(String[] args) {
 
    }
    
}
