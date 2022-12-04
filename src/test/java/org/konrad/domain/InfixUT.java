package org.konrad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InfixUT {
    /*
    2-3 --> 2 3 -
    2-3+4 --> 2 3 - 4 + --> (2 3 -) 4 + - --> -1 + 4 - --> 3
    2-3*5 --> 2 3 5 * -
    2*3-5 --> 2 3 * 5 -
    2*3-5*4 --> 2 3 * 5 4 * -
    2-3*5-4 --> 2 3 5 * - 4 -
    2-3*5*4*3 --> 2 3 5 * 4 * 3 * -
     */

    @Test
    public void checkRPNForOneSign() {
        // GIVEN
        Infix infix = new Infix("2-3");

        // WHEN
        Postfix postfix = infix.toPostfix();

        // THEN
        Assertions.assertEquals("[2, 3, -]", postfix.getPostfix().toString());
    }

    @Test
    public void checkRPNForTwoSign() {
        Infix infix = new Infix("2-3+4");

        Postfix postfix = infix.toPostfix();

        Assertions.assertEquals("[2, 3, -, 4, +]", postfix.getPostfix().toString());
    }

    @Test
    public void checkRPNForTwoSign2() {
        Infix infix = new Infix("2+6*2");

        Postfix postfix = infix.toPostfix();

        Assertions.assertEquals("[2, 6, 2, *, +]", postfix.getPostfix().toString());
    }

    @Test
    public void checkRPNForTwoSign3() {
        Infix infix = new Infix("2*6+2");

        Postfix postfix = infix.toPostfix();

        Assertions.assertEquals("[2, 6, *, 2, +]", postfix.getPostfix().toString());
    }

    @Test
    public void checkRPNForTwoSign4() {
        Infix infix = new Infix("2*3-5*4");

        Postfix postfix = infix.toPostfix();

        Assertions.assertEquals("[2, 3, *, 5, 4, *, -]", postfix.getPostfix().toString());
    }

    @Test
    public void checkRPNForTwoSign5() {
        Infix infix = new Infix("2-3*5-4");

        Postfix postfix = infix.toPostfix();

        Assertions.assertEquals("[2, 3, 5, *, -, 4, -]", postfix.getPostfix().toString());
    }

    @Test
    public void checkRPNForTwoSign6() {
        Infix infix = new Infix("2-3*5*4*3");

        Postfix postfix = infix.toPostfix();

        Assertions.assertEquals("[2, 3, 5, *, 4, *, 3, *, -]", postfix.getPostfix().toString());
    }

    @Test
    public void checkRPNForTwoSign7() {
        Infix infix = new Infix("2-3*5/4*3");

        Postfix postfix = infix.toPostfix();

        Assertions.assertEquals("[2, 3, 5, *, 4, /, 3, *, -]", postfix.getPostfix().toString());
    }

}
