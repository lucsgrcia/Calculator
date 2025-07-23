/*
 * Copyright (C) 2024 Lucas Garcia and Pedro Lucas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;
import model.bo.BotaoDecimal;
import model.bo.Properties;
import model.dao.CalculatorDAO;
import model.vo.Numbers;

/**
 *
 * @author Lucas Garcia and Pedro Lucas
 * @date 03/11/2024
 * @brief Class FXMLDocumentController
 *
 **/

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField display1, display2;
    private String operador;
    private double num1, num2, num, resultado;
    List<String> list = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("#,###.#####");
    private Button botao, decimal;

    Numbers n = new Numbers();
    Properties p = new Properties(n);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        display1.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        display2.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        display1.setText("0");
    }

    @FXML
    private void Botao(ActionEvent event) {
        botao = (Button) event.getSource();
        if ("0".equals(display1.getText()) || display1.getText().equals(String.valueOf(df.format(resultado)))) {
            display1.setText((botao).getText());
        } else {
            display1.setText(display1.getText() + botao.getText());
        }
    }

    @FXML
    private void Decimal(ActionEvent event) {

        decimal = ((Button) event.getSource());
        if (display1.getText().equals(String.valueOf(df.format(resultado)))
                || "".equals(display1.getText())) {
            display1.setText(0 + decimal.getText());
        } else {
            display1.setText(display1.getText() + decimal.getText());
        }
        BotaoDecimal.DesativarBotao(decimal);
    }

    @FXML
    private void Sinal(ActionEvent event) {
        String strNum = display1.getText().replace(".", "").replace(",", ".");
        num = Double.parseDouble(String.valueOf((strNum)));
        num *= -1;
        display1.setText(String.valueOf(df.format(num)));
    }

    @FXML
    private void AC(ActionEvent event) {
        display1.setText("0");
        display2.setText("");
        if (!((display1.getText()).contains(","))) {
            BotaoDecimal.AtivarBotao(decimal);
        }
    }

    @FXML
    private void Backspace(ActionEvent event) {
        display1.setText((display1.getText()).substring(0, (display1.getText()).length() - 1));
        if (!((display1.getText()).contains(","))) {
            BotaoDecimal.AtivarBotao(decimal);
        }
    }

    @FXML
    private void Operadores(ActionEvent event) {

        operador = ((Button) event.getSource()).getText();
        num1 = Double.parseDouble(String.valueOf((display1.getText()).replace(".", "").replace(",", ".")));
        n.setNum1(num1);
        display2.setText(display1.getText() + " " + operador);
        display1.setText("");

        BotaoDecimal.AtivarBotao(decimal);
    }

    @FXML
    private void Igual(ActionEvent event) {

        String igual = ((Button) event.getSource()).getText();
        num2 = Double.parseDouble(String.valueOf(display1.getText().replace(".", ",").replace(",", ".")));
        n.setNum2(num2);

        if ("√".equals(igual)) {
            resultado = p.sqrt();
            display2.setText("√" + df.format(num2) + " =");
        } else {
            if ("%".equals(igual)) {
                num2 = p.porcentagem(operador);
            }
            switch (operador) {
                case "+":
                    resultado = p.soma();
                    break;
                case "-":
                    resultado = p.subtracao();
                    break;
                case "*":
                    resultado = p.multiplicacao();
                    break;
                case "÷":
                    resultado = p.divisao();
                    break;
                case "^":
                    resultado = p.exponenciacao();
                    break;
            }
            display2.setText(df.format(n.getNum1()) + " " + operador + " " + df.format(n.getNum2()) + " =");
        }
        display1.setText((df.format(resultado)));

        if ("√".equals(igual)) {
            list.add("sqrt(" + num2 + ") =" + display1.getText());

        } else if ("÷".equals(operador)) {
            list.add(num1 + " / " + num2 + " =" + display1.getText());
        } else {
            list.add(display2.getText() + display1.getText());
        }
        
        CalculatorDAO.salvarDados(list);
        BotaoDecimal.AtivarBotao(decimal);
    }

}
