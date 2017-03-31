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
import java.math.BigDecimal;
import javafx.event.Event;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author nimzo6689
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public enum ResultState implements ICalcState {

    INSTANCE {
        @Override
        public void onInputNumber(Event event, CalcController controller) {
            Button btn = (Button) event.getSource();
            CalcNumber calcNumber = CalcNumber.of(btn.getId());
            if (CalcNumber.ZERO == calcNumber) {
                controller.getClear().setText("C");
                controller.getDisplay().setText("");
            }
            calcNumber.appendNumberTo(controller.getDisplay());

            controller.changeCalcStateTo(RegisterAState.INSTANCE);
        }

        @Override
        public void onInputOperation(Event event, CalcController controller) {
            BigDecimal result = controller.getOperation().eval(controller.getRegisterA(), controller.getRegisterB());
            controller.getDisplay().setText(result.toPlainString());
            controller.setRegisterA(result);
            controller.setRegisterB(BigDecimal.ZERO);

            controller.changeCalcStateTo(OperationState.INSTANCE);
        }

        @Override
        public void onInputEqual(Event event, CalcController controller) {
            // Do nothing.
        }

        @Override
        public void onInputClear(Event event, CalcController controller) {
            controller.setRegisterA(BigDecimal.ZERO);
            controller.setRegisterB(BigDecimal.ZERO);
            controller.getDisplay().setText(CalcController.DEFAULT_VALUE);

            controller.changeCalcStateTo(RegisterAState.INSTANCE);
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
