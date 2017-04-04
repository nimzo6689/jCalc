/*
 * The MIT License
 *
 * Copyright 2017 nimzo6689.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.qiita.nimzo6689.calculator;

import com.qiita.nimzo6689.calculator.code.Operation;
import com.qiita.nimzo6689.calculator.state.ICalcState;
import com.qiita.nimzo6689.calculator.state.RegisterAState;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author nimzo6689
 */
@Log4j2
@Getter
public class CalcController implements Initializable {

    /**
     * for display.
     */
    public static final String DEFAULT_VALUE = "0";

    @FXML
    @Setter
    private TextArea display;

    /**
     * The button has "Clear" and "All Clear" meaning.
     */
    @FXML
    @Setter
    private Button clear;
    @Setter
    private Operation operation;
    @Setter
    private BigDecimal registerA;
    @Setter
    private BigDecimal registerB;

    private ICalcState calcState;

    /**
     *
     * @param location The location used to resolve relative paths for the root
     * object, or
     * <tt>null</tt> if the location is not known.
     *
     * @param resources The resources used to localize the root object, or
     * <tt>null</tt> if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        display.setEditable(false);
        display.setText(DEFAULT_VALUE);
        calcState = RegisterAState.INSTANCE;
    }

    /**
     *
     * @param calcState The state of calculator.
     */
    public void changeCalcStateTo(ICalcState calcState) {
        log.debug("Change CalcState " + this.calcState + " -> " + calcState);
        this.calcState = calcState;
    }

    /**
     * On input Number, "," or "%", delegate ICalcState instance.
     *
     * @param event Corresponding to FXML element.
     */
    @FXML
    public void onInputNumber(ActionEvent event) {
        calcState.onInputNumber(event, this);
    }

    /**
     * On input Operation, delegate ICalcState instance.
     *
     * @param event Corresponding to FXML element.
     */
    @FXML
    public void onInputOperation(ActionEvent event) {
        calcState.onInputOperation(event, this);
    }

    /**
     * On input "=", delegate ICalcState instance.
     *
     * @param event Corresponding to FXML element.
     */
    @FXML
    public void onInputEqual(ActionEvent event) {
        calcState.onInputEqual(event, this);
    }

    /**
     * On input "C" or "AC", delegate ICalcState instance.
     *
     * @param event Corresponding to FXML element.
     */
    @FXML
    public void onInputClear(ActionEvent event) {
        calcState.onInputClear(event, this);
    }

    /**
     * On input "+/-", delegate ICalcState instance.
     */
    @FXML
    public void onInputSign() {
        calcState.onInputSign(this);
    }

}
