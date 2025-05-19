package GFG;

public class Minimum_Jumps {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0; // No jumps needed if array has one element
        if (arr[0] == 0) return -1; // Cannot move forward if the first element is 0

        int jumps = 1; // At least one jump needed
        int maxReach = arr[0]; // Farthest index that can be reached
        int steps = arr[0]; // Steps we can still take

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps; // Reached the end of the array
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1; // Cannot move forward
                steps = maxReach - i;
            }
        }
        return -1; // If end isn't reached
    }
}