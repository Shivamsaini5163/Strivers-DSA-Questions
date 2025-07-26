package GFG;

import java.util.*;

public class All_divisors_of_a_Number {
    //Brute Force
//    O((K log K)*sqrt(N)) due to sorting   O(sqrt(N))
    public static void print_divisors(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                list.add(i);
                if((n/i)!=i){
                    list.add(n/i);
                }
            }
        }
        Collections.sort(list); //using sorting for proper order
        for(int num:list){
            System.out.print(num+" ");
        }
    }
    //Better Approach
    //    O(sqrt(N)) Avoiding sorting   O(sqrt(N))
    public static void print_divisors2(int n) {
        ArrayList<Integer> small=new ArrayList<>();
        ArrayList<Integer> large=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                small.add(i);
                if((n/i)!=i){
                    large.add(n/i);
                }
            }
        }
        for(int i=0;i<small.size();i++){
            System.out.print(small.get(i)+" ");
        }
        for(int i=large.size()-1;i>=0;i--){
            System.out.print(large.get(i)+" ");
        }
    }
    //Best Approach
    //    O(sqrt(N))    O(1)
    public static void print_divisors3(int n) {
        int sqrt = (int)Math.sqrt(n);

        // First half: smaller divisors
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

        // Second half: larger divisors
        for (int i = sqrt; i >= 1; i--) {
            if (n % i == 0 && i != n / i) {
                System.out.print((n / i) + " ");
            }
        }
    }
}
