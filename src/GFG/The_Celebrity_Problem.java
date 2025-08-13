package GFG;

public class The_Celebrity_Problem {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int candidate = 0;

        // Step 1: Find a potential candidate
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i; // candidate knows i, so can't be celeb
            }
        }

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;

            // If candidate knows i, or i doesn't know candidate -> not celebrity
            if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                return -1;
            }
        }
        return candidate;
    }
}
