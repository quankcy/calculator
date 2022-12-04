package org.konrad.domain;

public class Calculator {

    private final MathematicalExpressionValidator validator = new MathematicalExpressionValidator();
    private final MathematicalExpressionSplitter splitter = new MathematicalExpressionSplitter();
    private final OperatorHelper infixToPostfixMapper = new OperatorHelper();
    private final Inputable inputable;
    public Calculator(Inputable inputable) {
        this.inputable = inputable;
    }

    public void calculate(){
        String possibleMathExpression = inputable.getInput();
        String mathExpression = validator.validate(possibleMathExpression);
        String[] mathExpressionComponents = splitter.split(mathExpression);
        Infix infix = new Infix(mathExpressionComponents);
        System.out.println(calculateByRPN(infix));
    }

    private Double calculateByRPN(Infix infix) {
        //infixToPostfixMapper.infixToPostfix(mathExpressionComponents);
        Postfix postfix = infix.toPostfix();
       return postfix.calculate();
    }

}
