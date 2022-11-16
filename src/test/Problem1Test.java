package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static problems.Problem1.getArraySum;
import static problems.Problem1.indexOfSumBalance;

class Problem1Test {

    private int[] positiveNumbersArray;
    private int[] negativeNumbersArray;
    private int[] noEqualSumsArray;

    @BeforeEach
    void setUp(){
        positiveNumbersArray = new int[]{3,0,3,4,5,9,1};
        negativeNumbersArray = new int[]{-1,-1,-1,-1,-1,-1,-1};
        noEqualSumsArray = new int[]{1,2,3,4,5,2};
    }

    @Test
    @DisplayName("Get at which index the array has equal sums")
    void testIndexOfNums() {
        Assertions.assertEquals(4, indexOfSumBalance(positiveNumbersArray));
        Assertions.assertEquals(3, indexOfSumBalance(negativeNumbersArray));
        Assertions.assertEquals(-1, indexOfSumBalance(noEqualSumsArray));
    }

    @Test
    @DisplayName("Should return sum of array")
    void testGetArraySum() {
        Assertions.assertEquals(25, getArraySum(positiveNumbersArray));
        Assertions.assertEquals(-7, getArraySum(negativeNumbersArray));
        Assertions.assertEquals(17, getArraySum(noEqualSumsArray));
    }
}