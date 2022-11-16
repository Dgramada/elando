package problems;

import java.util.*;

public class Problem3 {

    public static void main(String[] args) {
        String mainString = "cbabadebbabbcebabaabbcebabbc";
        String substring = "abbc";

        char[] charArray = substring.toCharArray();
        permute(charArray, 0);
        Map<Integer, String> permutationsMapping = getPermutationsMappingOfString(substring, mainString);

        System.out.println(permutationsMapping + "\nNumber of permutations: " + permutationsMapping.size() );
    }

    /**
     * A set containing all the permutations of a string
     */
    static Set<String> permutationsSet = new HashSet<>();

    /**
     * Find the start index of all the permutations of substring contained in mainString
     * and put them in a map as keys and the permutation located on that index as its
     * corresponding value
     * @param substring a substring
     * @param mainString a String that is checked if it contains all the permutations of substring
     * @return map that contains the start index of all the permutations of substring contained
     * in mainString and the corresponding permutations as values to those keys
     */
    public static Map<Integer, String> getPermutationsMappingOfString(String substring, String mainString) {
        Map<Integer, String> permutationsMappingOfString = new HashMap<>();
        int substringSize = substring.length();
        int n = mainString.length() - substringSize;
        for (int i = 0; i < n; i++) {
            String temp = mainString.substring(i, i + substringSize);
            if (permutationsSet.contains(temp)) {
                permutationsMappingOfString.put(i, temp);
            }
        }
        if (permutationsSet.contains(mainString.substring(n))) {
            permutationsMappingOfString.put(n, mainString.substring(n));
        }
        return permutationsMappingOfString;
    }

    /**
     * Find and add all the permutations of a char array to a set
     * @param charArray an array of chars
     * @param start the start index of the char array
     */
    public static void permute(char[] charArray, int start) {
        for(int i = start; i < charArray.length; i++){
            swapChars(charArray, start, i);
            permute(charArray, start + 1);
            swapChars(charArray, i, start);
        }
        if (start == charArray.length - 1) {
            permutationsSet.add(toString(charArray));
        }
    }

    /**
     * Swap two elements with indexes i and j from charArray
     * @param charArray array containing chars
     * @param i index of an element
     * @param j index of an element
     */
    public static void swapChars(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    /**
     * Convert the char array values into a string and return it
     * @param charArray a char array
     * @return string representation of the char values
     */
    public static String toString(char[] charArray) {
        return String.valueOf(charArray);
    }
}
