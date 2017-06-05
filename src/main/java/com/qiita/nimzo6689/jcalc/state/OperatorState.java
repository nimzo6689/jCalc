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
package com.qiita.nimzo6689.jcalc.state;

import com.qiita.nimzo6689.jcalc.CalcContext;
import com.qiita.nimzo6689.jcalc.CalcModel;
import com.qiita.nimzo6689.jcalc.code.CalcNumber;
import com.qiita.nimzo6689.jcalc.code.Operator;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author nimzo6689
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public enum OperatorState implements ICalcState {

    INSTANCE {
        @Override
        public void onInputNumber(CalcContext context, CalcNumber number, CalcModel model) {
            model.setDisplayFromBicDecimal(number.toBicDecimal());

            context.changeCalcStateTo(RegisterBState.INSTANCE);
        }

        @Override
        public void onInputOperator(CalcContext context, Operator operator, CalcModel model) {
            model.setOperator(operator);
        }

        @Override
        public void onInputEqual(CalcContext context, CalcModel model) {
            Operator operation = model.getOperator();

            if (Operator.PLUS == operation || Operator.MINUS == operation) {
                model.setDisplayFromBicDecimal(model.getRegisterA());
            } else {
                BigDecimal result = operation.eval(model.getRegisterA(), model.getRegisterB());
                model.setDisplayFromBicDecimal(result);
                model.setRegisterA(result);
                model.setRegisterB(BigDecimal.ZERO);
            }

            context.changeCalcStateTo(ResultState.INSTANCE);
        }

        @Override
        public void onInputClear(CalcContext context, CalcModel model) {
            model.setRegisterA(BigDecimal.ZERO);
            model.setDisplayFromBicDecimal(CalcNumber.ZERO.toBicDecimal());

            context.changeCalcStateTo(RegisterAState.INSTANCE);
        }

        @Override
        public void onInputSign(CalcModel model) {
            BigDecimal number = model.getDisplayToBicDecimal();
            if (number != BigDecimal.ZERO) {
                model.setDisplayFromBicDecimal(number.negate());
            }
        }
    };
    
    @Override
    public void onInputNumber(CalcContext context, CalcNumber number, CalcModel model) {
        throw new UnsupportedOperationException("Use RegisterAState.INSTANCE.onInputNumber(context, number, model)");
    }

    @Override
    public void onInputOperator(CalcContext context, Operator operator, CalcModel model) {
        throw new UnsupportedOperationException("Use RegisterAState.INSTANCE.onInputOperator(context, operator, model)");
    }

    @Override
    public void onInputEqual(CalcContext context, CalcModel model) {
        throw new UnsupportedOperationException("Use RegisterAState.INSTANCE.onInputEqual(context, model)");
    }

    @Override
    public void onInputClear(CalcContext context, CalcModel model) {
        throw new UnsupportedOperationException("Use RegisterAState.INSTANCE.onInputClear(context, model)");
    }

    @Override
    public void onInputSign(CalcModel model) {
        throw new UnsupportedOperationException("Use RegisterAState.INSTANCE.onInputClear(model)");
    }

}
