package problems;

public class Problem1 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,3,4,5,9,1};
        System.out.println(indexOfSumBalance(nums));
    }

    /**
     * Return the index of an element in an array where the left sum and the right sum of the array
     * are equal or -1 if no such element exists
     * @param nums an integer array
     * @return the leftmost index when the left sum is equal to the right sum or -1 if no such index exists
     */
    public static int indexOfSumBalance(int[] nums) {
        int arraySum = getArraySum(nums);
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == arraySum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * Calculate the total sum of all integers in an array
     * @param array an integer array
     * @return the total sum of the ints in an array
     */
    public static int getArraySum(int[] array) {
        int arraySum = 0;
        for (int n : array) {
            arraySum += n;
        }
        return arraySum;
    }
}
