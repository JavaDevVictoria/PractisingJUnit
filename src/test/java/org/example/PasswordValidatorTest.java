package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;
    private String password;

    @BeforeEach
    void setUp() {
        password = "HappyDays_123A!";
        passwordValidator = new PasswordValidator(password);
    }

    @Test
    void testPasswordIsValid() {
        assertTrue(passwordValidator.isPasswordLongEnough(password),"Password does not meet length requirements");
    }

    @Test
    void testPasswordContainsEnoughDigits() {
        assertTrue(passwordValidator.isPasswordHavingEnoughDigits(password), "Password does not have enough digits");
    }

    @Test
    void testPasswordContainsUnderscore() {
        assertTrue(passwordValidator.isPasswordHavingUnderscore(password), "Password does not have underscore");
    }

    @Test
    void testPasswordContainsMixtureOfLowerAndUppercaseLetters() {
        assertTrue(passwordValidator.isPasswordHavingMixtureOfLowerAndUppercaseLetters(password), "Password does not contain mixture of lower and uppercase letters");
    }
}
