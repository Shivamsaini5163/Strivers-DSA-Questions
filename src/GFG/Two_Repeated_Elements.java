package GFG;

public class Two_Repeated_Elements {
    // Sign Marking / Index Mapping Approach
    public int[] twoRepeated(int[] arr) {
        int[] result = new int[2];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);

            // if the position value is already negative → repeat found
            if (arr[val] < 0) {
                result[idx++] = val;
                if (idx == 2) break;  // found both repeats
            } else {
                arr[val] = -arr[val];
            }
        }
        return result;
    }
}
