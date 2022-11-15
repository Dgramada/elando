import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Problem 1 example
        int[] nums = new int[]{3,0,3,4,5,9,1};
        System.out.println(indexOfSumBalance(nums));

        System.out.println();

        //Problem 2 example
        String dummyString = "\"Lorem ipsum dolor sit amet\"";
        int tp = 10;
        printAllCommonSymbols(dummyString, tp);

        System.out.println();

        //Problem 3 example
        String mainString = "cbabadebbabbcebabaabbcebabbc";
        String substring = "abbc";
        List<Integer> permutationLocationList = getPermutationsIndex(mainString, substring);
        System.out.println("Permutation locations: " + permutationLocationList);
        System.out.println("Number of permutations: " + permutationLocationList.size());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

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

    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param input
     * @param tp
     */
    public static void printAllCommonSymbols(String input, int tp) {
        Map<Character, Integer> charCountsMap = charCounterMap(input);
        Map<Character, Integer> trimmedMap = trimMap(charCountsMap, (float) tp, input.length());

        System.out.println("Input Size: " + input.length());
        System.out.println("Threshold percentage: " + tp + "%");
        System.out.println(toString(trimmedMap));
    }

    public static Map<Character, Integer> charCounterMap(String input) {
        Map<Character, Integer> charCountsMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if (charCountsMap.containsKey(ch)) {
                charCountsMap.put(ch, charCountsMap.get(ch) + 1);
            } else {
                charCountsMap.put(ch, 1);
            }
        }

        return charCountsMap;
    }

    public static Map<Character, Integer> trimMap(Map<Character, Integer> charCountMap, float tp, float size) {
        Map<Character, Integer> trimmedMap = new HashMap<>();
        float threshold = size / tp;
        for (char ch : charCountMap.keySet()) {
            if (threshold < charCountMap.get(ch)) {
                trimmedMap.put(ch, charCountMap.get(ch));
            }
        }
        return trimmedMap;
    }

    public static StringBuilder toString(Map<Character, Integer> map) {
        String output = "[";
        StringBuilder strB = new StringBuilder(output);
        for (char ch : map.keySet()) {
            strB.append("'").append(ch).append("':").append(map.get(ch)).append(",");
        }
        strB.deleteCharAt(strB.length() - 1);
        strB.append("]");
        return strB;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static List<Integer> getPermutationsIndex(String mainString, String substring) {
        List<Integer> permutationsIndex = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < mainString.length() - substring.length() + 1; i++) {
            for (int j = 0; j < substring.length(); j++) {
                if (mainString.charAt(i + j) == substring.charAt(j)) {
                    counter++;
                } else {
                    counter = 0;
                    break;
                }
                if (counter == substring.length()) {
                    counter = 0;
                    permutationsIndex.add(i);
                }
            }
        }
        return permutationsIndex;
    }
}