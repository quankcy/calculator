package org.konrad.domain;

import java.util.List;
import java.util.Stack;

public class Postfix {

    private List<String> postfix;

    Postfix(List<String> postfix) {
        this.postfix = postfix;
    }

    public List<String> getPostfix() {
        return postfix;
    }

    public Double calculate() {
        Stack<Double> stack = new Stack<>();

        for (String element : postfix) {
            if (NumericHelper.isNumeric(element)) {
                stack.add(NumericHelper.parseToDouble(element));
            } else {
                Double number2 = stack.pop();
                Double number1 = stack.pop();
                Double result = OperatorHelper2.calculate(element, number1, number2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    /*
        I: 2 3 -
        S: 2 3
        O: 3 2

        I0: 4 2 3 * -
        S: 4 2 3
        I1: 4 6 -
        s: 4 6
        i3: -2
     */
}
