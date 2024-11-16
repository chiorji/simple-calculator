package com.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Label accumulator;
    @FXML
    private Label result;
    private long lg1 = 0;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();

    @FXML
    protected void processNumbers(ActionEvent event) {
        if (start) {
            result.setText("");
            accumulator.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        result.setText(result.getText() + value);
        accumulator.setText(accumulator.getText() + value);
    }

    @FXML
    protected void processOperators(ActionEvent event) {
        String op = ((Button) event.getSource()).getText();
        if (!op.equals("=")) {
            if (!operator.isEmpty()) return;
            operator = op;

            lg1 = Long.parseLong(result.getText());
            result.setText("");
            accumulator.setText(accumulator.getText() + op);
        } else {
            if (operator.isEmpty()) return;
            long lg2 = Long.parseLong(result.getText());
            float output = model.calculate(lg1, lg2, operator);
            result.setText(String.valueOf(output));
            this.reset();
        }
    }

    protected void reset() {
        operator = "";
        start = true;
    }
}