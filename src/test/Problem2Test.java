package test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static problems.Problem2.getCharCounterMap;
import static problems.Problem2.getCharsMapAboveThreshold;

class Problem2Test {

    private String exampleString;
    private float threshold1;
    private float threshold2;
    private Map<Character, Integer> charMappingOfString;

    @BeforeEach
    void setUp(){
        exampleString = "\"Lorem ipsum dolor sit amet\"";
        int percentThreshold1 = 10;
        int percentThreshold2 = 20;
        charMappingOfString = getCharCounterMap(exampleString);
        threshold1 = exampleString.length() * (float) percentThreshold1 / 100;
        threshold2 = exampleString.length() * (float) percentThreshold2 / 100;
    }

    @Test
    void testGetCharCounterMap() {
        Assertions.assertEquals("{ =4, a=1, \"=2, d=1, e=2, i=2, L=1, l=1, m=3, o=3, p=1, r=2, s=2, t=2, u=1}", getCharCounterMap(exampleString).toString());
    }

    @Test
    void testGetCharsMapAboveThreshold() {
        Assertions.assertEquals("{ =4, m=3, o=3}", getCharsMapAboveThreshold(charMappingOfString, threshold1).toString());
        Assertions.assertEquals("{}", getCharsMapAboveThreshold(charMappingOfString, threshold2).toString());
    }
}