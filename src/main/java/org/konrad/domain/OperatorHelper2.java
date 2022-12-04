package org.konrad.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class OperatorHelper2 {

    private static final Map<String, Operator> SIGNS;

    static {
        SIGNS = new HashMap<>();
        SIGNS.put("-", new Operator(2, (a, b) -> a - b));
        SIGNS.put("+", new Operator(2, (a, b) -> a + b));
        SIGNS.put("*", new Operator(3, (a, b) -> a * b));
        SIGNS.put("/", new Operator(3, (a, b) -> a / b));
    }

    public static Double calculate(String sign, Double a, Double b) {
        return SIGNS.get(sign).getOperation().apply(a, b);
    }

    public static Integer getWeight(String sign) {
        return SIGNS.get(sign).getWeight();
    }

    static class Operator {
        private final Integer weight;
        private final BiFunction<Double, Double, Double> operation;

        Operator(Integer weight, BiFunction<Double, Double, Double> operation) {
            this.weight = weight;
            this.operation = operation;
        }

        public Integer getWeight() {
            return weight;
        }

        public BiFunction<Double, Double, Double> getOperation() {
            return operation;
        }
    }
}
