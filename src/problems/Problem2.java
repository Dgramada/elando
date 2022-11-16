package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {

    public static void main(String[] args) {
        String dummyString = "\"Lorem ipsum dolor sit amet\"";
        int tp = 10;

        printAllCommonSymbols(dummyString, tp);
    }

    /**
     * Print the size of the input string, the threshold percentage and the chars that pass the threshold
     * @param input String
     * @param tp the threshold percentage
     */
    public static void printAllCommonSymbols(String input, int tp) {
        float threshold = input.length() * (float) tp / 100;
        Map<Character, Integer> trimmedMap = getCharsMapAboveThreshold(getCharCounterMap(input), threshold);
        System.out.println("Input Size: " + input.length());
        System.out.println("Threshold percentage: " + tp + "%");
        System.out.println(toString(trimmedMap));
    }

    /**
     * Return a map that contains every char of a string as a key and the number
     *  of times it occurs in the string as a value assigned to that key
     * @param input String which is used for the map
     * @return the map containing all the chars as keys and the number of times they occur
     * as values
     */
    public static Map<Character, Integer> getCharCounterMap(String input) {
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

    /**
     * Return a new map containing only the chars above the threshold from charCountMap
     * @param charCountMap map containing chars as keys and int as values
     * @param threshold float that gives a threshold for the map values
     * @return a new map with chars as keys that have values larger than the threshold
     */
    public static Map<Character, Integer> getCharsMapAboveThreshold(Map<Character, Integer> charCountMap, float threshold) {
        Map<Character, Integer> charsMapAboveThreshold = new HashMap<>();
        for (char ch : charCountMap.keySet()) {
            if (threshold < charCountMap.get(ch)) {
                charsMapAboveThreshold.put(ch, charCountMap.get(ch));
            }
        }
        return charsMapAboveThreshold;
    }

    /**
     *
     * @param map map containing chars as keys and ints as values
     * @return A StringBuilder object that formats the solution to Problem 3
     * into the format shown in the example output from the problem
     */
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
}
