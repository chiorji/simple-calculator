package com.calculator;

public class Model {
    public float calculate(long lng1, long lng2, String operator) {
        switch (operator) {
            case "+":
                return lng1 + lng2;
            case "-":
                return lng1 - lng2;
            case "*":
                return lng1 * lng2;
            case "/":
                if (lng2 == 0) return 0;
                return (float) lng1 / lng2;
            default:
                return 0;
        }
    }
}
