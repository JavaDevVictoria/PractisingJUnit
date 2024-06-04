package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexTest {

    private Regex regex;
    private String inputString;

    @BeforeEach
    void setUp() {
        inputString = "cdefg 345 12bb23";
        regex = new Regex(inputString);
    }

    @Test
    void checkFor3orMoreConsecutiveDigits() {
        assertTrue(regex.isInputStringHaving3orMoreConsecutiveDigits(inputString));
    }

    @Test
    void testOutputSubStringsWith3orMoreConsecutiveDigits() {
        assertEquals("345", regex.outputSubStringsWith3orMoreConsecutiveDigits(inputString));
    }

    @Test
    void testMultipleMatches() {
        inputString = "abc123def456ghi789";
        assertEquals("123 456 789", regex.outputSubStringsWith3orMoreConsecutiveDigits(inputString));
    }

    @Test
    void testNoMatches() {
        inputString = "abcdef";
        assertEquals("", regex.outputSubStringsWith3orMoreConsecutiveDigits(inputString));
    }
}
