package com.example.minseokoha7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinseokOhA7 extends Application {

    private TextField display;

    // Entry point for JavaFX application
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Minseok's Calculator"); // title
        initComponents(primaryStage);
        primaryStage.show();
    }

    private void initComponents(Stage stage) {
        display = new TextField();
        display.setEditable(false);
        display.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Add buttons and display to the grid
        addButtons(grid);
        grid.add(display, 0, 0, 4, 1);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    private void addButtons(GridPane grid) {
        // Define buttons
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "AC", "0", "=", "+"
        };

        // Create and add buttons
        for (int i = 0; i < buttons.length; i++) {
            Button btn = new Button(buttons[i]);
            btn.setPrefWidth(50);
            btn.setPrefHeight(50);
            btn.setOnAction(this::handleButtonClick);
            grid.add(btn, i % 4, (i / 4) + 1);
        }
    }

    private void handleButtonClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String buttonText = btn.getText();

        if (isLastOperationEqual && !"=".equals(buttonText) && !isOperation(buttonText)) {
            display.clear();
            isLastOperationEqual = false;
        }

        switch (buttonText) {
            case "+":
            case "-":
            case "*":
            case "/":
                processOperation(buttonText);
                break;
            case "=":
                calculateResult();
                isLastOperationEqual = true;
                break;
            case "AC":
                display.clear();
                isLastOperationEqual = false;
                break;
            default:
                display.appendText(buttonText);
                break;
        }
    }
    //  Track whether the last button pressed was the equals button.
    private boolean isOperation(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/");
    }

    private void processOperation(String operation) {
        if (!display.getText().isEmpty()) {
            display.appendText(" " + operation + " ");
        }
    }
    // Add a new variable to keep track of whether the last operation
    private boolean isLastOperationEqual = false;

    // Calculation result
    private void calculateResult() {
        try {
            String input = display.getText();
            String[] tokens = input.split(" ");
            if (tokens.length < 3) return;

            double operand1 = Double.parseDouble(tokens[0]);
            double operand2 = Double.parseDouble(tokens[2]);
            double result = 0;

            switch (tokens[1]) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 == 0) {
                        display.setText("Error: Div by 0");
                        return;
                    }
                    result = operand1 / operand2;
                    break;
            }

            display.setText(String.valueOf(result));
        } catch (Exception e) {
            display.setText("Error");
        }
    }
    // Main method
    public static void main(String[] args) {
        launch(args);
    }
}
