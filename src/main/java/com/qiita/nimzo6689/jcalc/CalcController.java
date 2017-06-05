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
package com.qiita.nimzo6689.jcalc;

import com.qiita.nimzo6689.jcalc.state.RegisterAState;
import com.qiita.nimzo6689.jcalc.utils.Converts;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author nimzo6689
 */
@Log4j2
public class CalcController implements Initializable {

    @FXML
    private TextArea display;
    private final CalcModel model = new CalcModel();
    private final CalcContext context = CalcContext.INSTANCE;

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

        // Bind property for display.
        display.textProperty().bind(model.displayProperty());
        // Set default state.
        context.changeCalcStateTo(RegisterAState.INSTANCE);
    }

    /**
     * On input Number, "." or "%", delegate ICalcState instance.
     *
     * @param event Corresponding to FXML element.
     */
    @FXML
    public void onInputNumber(ActionEvent event) {
        context.getState().onInputNumber(
                context, Converts.toCalcNumberFrom(event), model);
    }

    /**
     * On input Operator, delegate ICalcState instance.
     *
     * @param event Corresponding to FXML element.
     */
    @FXML
    public void onInputOperation(ActionEvent event) {
        context.getState().onInputOperator(
                context, Converts.toOperationFrom(event), model);
    }

    /**
     * On input "=", delegate ICalcState instance.
     *
     * @param event Corresponding to FXML element.
     */
    @FXML
    public void onInputEqual(ActionEvent event) {
        context.getState().onInputEqual(context, model);
    }

    /**
     * On input "AC", delegate ICalcState instance.
     *
     * @param event Corresponding to FXML element.
     */
    @FXML
    public void onInputClear(ActionEvent event) {
        context.getState().onInputClear(context, model);
    }

    /**
     * On input "+/-", delegate ICalcState instance.
     */
    @FXML
    public void onInputSign() {
        context.getState().onInputSign(model);
    }

}
