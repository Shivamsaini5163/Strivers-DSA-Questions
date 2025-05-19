package Leetcode;
//leetcode 1189
//Time and Space Complexity =>  O(N) O(1)
public class Maximum_Number_of_Balloons {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];

        for (int i = 0; i < text.length(); i++) {
            arr[text.charAt(i) - 'a']++;
        }

        int b = arr[1];
        int a = arr[0];
        int l = arr[11] / 2; // 'l' appears twice
        int o = arr[14] / 2; // 'o' appears twice
        int n = arr[13];

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }
}
