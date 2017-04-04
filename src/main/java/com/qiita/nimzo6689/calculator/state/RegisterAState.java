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
package com.qiita.nimzo6689.calculator.state;

import com.qiita.nimzo6689.calculator.CalcController;
import com.qiita.nimzo6689.calculator.code.CalcNumber;
import com.qiita.nimzo6689.calculator.utils.Converts;
import java.math.BigDecimal;
import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author nimzo6689
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public enum RegisterAState implements ICalcState {

    INSTANCE {
        @Override
        public void onInputNumber(ActionEvent event, CalcController controller) {
            CalcNumber calcNumber = Converts.toCalcNumberFrom(event);
            if (CalcNumber.ZERO == calcNumber) {
                controller.getClear().setText("C");
                controller.getDisplay().setText("");
            }
            calcNumber.appendNumberTo(controller.getDisplay());
        }

        @Override
        public void onInputOperation(ActionEvent event, CalcController controller) {
            controller.setRegisterA(new BigDecimal(controller.getDisplay().getText()));
            controller.setOperation(Converts.toOperationFrom(event));

            controller.changeCalcStateTo(OperationState.INSTANCE);
        }

        @Override
        public void onInputEqual(ActionEvent event, CalcController controller) {
            controller.changeCalcStateTo(ResultState.INSTANCE);
        }

        @Override
        public void onInputClear(ActionEvent event, CalcController controller) {
            controller.setRegisterA(BigDecimal.ZERO);
            controller.getDisplay().setText(CalcController.DEFAULT_VALUE);
        }

        @Override
        public void onInputSign(CalcController controller) {
            BigDecimal number = new BigDecimal(controller.getDisplay().getText());
            if (number != BigDecimal.ZERO) {
                controller.getDisplay().setText(number.negate().toPlainString());
            }
        }
    }

}
