class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int element = matrix[middle / n][middle % n];
            if (element == target) {
                return true;
            }
            if (element < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return false;
    }
}
