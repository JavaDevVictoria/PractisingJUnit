package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public PasswordValidator(String password) {
    }

    public boolean isPasswordLongEnough(String password) {
        return password.length() >= 10;
    }

    public boolean isPasswordHavingEnoughDigits(String password) {
        Pattern pattern = Pattern.compile("[0-9].*[0-9]"); //2 digits
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public boolean isPasswordHavingUnderscore(String password) {
        return password.contains("_");
    }

    public boolean isPasswordHavingMixtureOfLowerAndUppercaseLetters(String password) {
        Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z]).*");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
