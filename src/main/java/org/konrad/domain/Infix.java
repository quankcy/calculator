package org.konrad.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

import static org.konrad.domain.OperatorHelper.getWeight;

public class Infix {

    private String[] infix;

    public Infix(String[] infix) {
        this.infix = infix;
    }

    public Infix(String infix) {
        this.infix = new MathematicalExpressionSplitter().split(infix);
    }

    public Postfix toPostfix() {
        List<String> input = Arrays.asList(this.infix);
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String element : input) {
            if (NumericHelper.isNumeric(element)) {
                output.add(element);
            } else {
                if (stack.empty()) {
                    stack.add(element);
                } else {

                    while (!stack.empty() && getWeight(stack.peek()) >= getWeight(element)) {
                        output.add(stack.pop());
                    }
                    stack.add(element);
                }
            }
        }

        popAllFromStackAndAddToList(output, stack);

        return new Postfix(output);
    }

    private static void popAllFromStackAndAddToList(List<String> output, Stack<String> stack) {
        Enumeration<String> elements = stack.elements();
        while (elements.hasMoreElements()) {
            output.add(stack.pop());
        }
    }

}
