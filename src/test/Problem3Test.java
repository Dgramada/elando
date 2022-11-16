package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problems.Problem3;

import static problems.Problem3.getPermutationsMappingOfString;
import static problems.Problem3.permute;

class Problem3Test {

    private String mainStringExample1;
    private String mainStringExample2;
    private String subStringExample1;
    private String subStringExample2;
    char[] charArray1;
    char[] charArray2;

    @BeforeEach
    void setUp(){
        mainStringExample1 = "cbabadebbabbcebabaabbcebabbc";
        subStringExample1 = "abbc";
        mainStringExample2 = "aba";
        subStringExample2 = "ab";
        charArray1 = subStringExample1.toCharArray();
        charArray2 = subStringExample2.toCharArray();
    }

    @Test
    void testGetPermutationsMappingOfString() {
        permute(charArray1, 0);
        Assertions.assertEquals("{0=cbab, 18=abbc, 24=abbc, 9=abbc}" , getPermutationsMappingOfString(subStringExample1, mainStringExample1).toString());
        permute(charArray2, 0);
        Assertions.assertEquals("{0=ab, 1=ba}" , getPermutationsMappingOfString(subStringExample2, mainStringExample2).toString());
    }
}