package GFG;

public class Wave_Array {
    public void sortInWave(int arr[]) {
        int n = arr.length;
        // Swap adjacent pairs
        for (int i = 0; i + 1 < n; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
