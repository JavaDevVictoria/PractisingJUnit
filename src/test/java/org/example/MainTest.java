package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Main.reverse;
import static org.example.Main.sayHelloWorld;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private HashMap<String, String> hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMap<>();
    }

    @Test
    void testSayHello() {
        assertEquals("Hello World!", sayHelloWorld());
    }

    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testReverse() {
        assertEquals("airotciV" , reverse("Victoria"));
        assertEquals("123", reverse("321"));
        assertEquals("" , reverse(""));
        assertEquals("dlroW olleH", reverse("Hello World"));
        assertEquals("a", reverse("a"));
        assertEquals("!£$%", reverse("%$£!"));
        assertEquals("  ", reverse("  ")); // Spaces
        assertEquals("🎉🌍", reverse("🌍🎉"));
        assertEquals("界世はちにんこ", reverse("こんにちは世界")); // Japanese characters

        // Long string
        String longString = "a".repeat(1000);
        String expectedReversedLongString = "a".repeat(1000);
        assertEquals(expectedReversedLongString, reverse(longString));

        assertThrows(IllegalArgumentException.class, () -> reverse(null), "Expected reverse(null) to throw, but it didn't");
    }

    @ParameterizedTest
    @CsvSource({
            "airotciV, Victoria",
            "123, 321",
            "'', '\u0000'", // Empty string
            "dlroW olleH, Hello World",
            "a, a", // Single character
            "!@#$%, %$#@!",
            "'  ', '\u0000\u0000'", // Spaces
            "🎉🌍, 🌍🎉",
            "界世はちにんこ, こんにちは世界" // Japanese characters
    })
    void testReverseWithParameterisedTests(String expected, String input) {
        if ("\u0000".equals(input)) {
            input = "";
        } else if ("\u0000\u0000".equals(input)) {
            input = "  ";
        }
        assertEquals(expected, reverse(input));
    }

    @Test
    void learnAssertJ() {
        double var = 2.5;
        assertThat(var).isEqualTo(2.5);
    }

}