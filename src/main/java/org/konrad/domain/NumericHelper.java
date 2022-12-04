package org.konrad.domain;

public class NumericHelper {

    public static boolean isNumeric(String element) {
        return parseToDouble(element) != null;
    }

    public static Double parseToDouble(String element) {
        try {
            return Double.parseDouble(element);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
}
