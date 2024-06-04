package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public Regex(String inputString) {
    }

    public boolean isInputStringHaving3orMoreConsecutiveDigits(String inputString) {
        Pattern pattern = Pattern.compile("\\d{3,}"); //3 or more consecutive digits
        Matcher matcher = pattern.matcher(inputString);
        return matcher.find();
    }

    public String outputSubStringsWith3orMoreConsecutiveDigits(String inputString) {
        Pattern pattern = Pattern.compile("\\d{3,}"); // 3 or more consecutive digits
        Matcher matcher = pattern.matcher(inputString);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(matcher.group());
        }

        String git  = result.toString();
        System.out.print("In \"" + inputString + "\", found matches: " + (output.isEmpty() ? "No matches" : "\"" + output + "\""));
        return output;
    }
}
