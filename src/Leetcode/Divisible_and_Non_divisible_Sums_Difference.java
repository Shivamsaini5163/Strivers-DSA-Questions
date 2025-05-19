package Leetcode;
//leetcode 2894
//Time and Space Complexity =>  O(1) O(1)
public class Divisible_and_Non_divisible_Sums_Difference {
    public int differenceOfSums(int n, int m) {
        int noOfDivisibles=n/m;
        int totalSum=n*(n+1)/2;
        int divisibleSum=m*(noOfDivisibles*(noOfDivisibles+1)/2);
        int notDivisibleSum=totalSum-divisibleSum;
        return notDivisibleSum-divisibleSum;
    }
}
