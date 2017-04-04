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
package com.qiita.nimzo6689.calculator.utils;

import com.qiita.nimzo6689.calculator.code.CalcNumber;
import com.qiita.nimzo6689.calculator.code.Operation;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 * @author nimzo6689
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Converts {

    /**
     *
     * @param event
     * @return CalcNumber enum object.
     */
    public static CalcNumber toCalcNumberFrom(ActionEvent event) {
        Button btn = (Button) event.getSource();
        return CalcNumber.of(btn.getId());
    }

    /**
     *
     * @param event
     * @return Operation enum object.
     */
    public static Operation toOperationFrom(ActionEvent event) {
        Button btn = (Button) event.getSource();
        return Operation.of(btn.getId());
    }

}
