package org.konrad.domain;

import java.util.HashMap;
import java.util.Map;

class OperatorHelper {

    private static final Map<String, Integer> SIGNS;

    static {
        SIGNS = new HashMap<>();
        SIGNS.put("-", 2);
        SIGNS.put("+", 2);
        SIGNS.put("*", 3);
        SIGNS.put("/", 3);
    }

    public static Integer getWeight(String sign) {
        return SIGNS.get(sign);
    }

    public static Double calculateIf(String sign, Double a, Double b) {
        if (sign == "+") {
            return a + b;
        } else if (sign == "-") {
            return a - b;
        } else if (sign == "*") {
            return a * b;
        } else if (sign == "/") {
            return a / b;
        }
        return null;
    }

}
