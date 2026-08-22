class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int compliment = target - numbers[i];
            int low = 1;
            int high = numbers.length - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (numbers[middle] == compliment) {
                    return new int[]{i + 1, middle + 1};
                }
                if (numbers[middle] > compliment) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
        return null;
    }
}
