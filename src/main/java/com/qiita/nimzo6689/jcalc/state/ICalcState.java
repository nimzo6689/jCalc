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
import com.qiita.nimzo6689.jcalc.code.Operation;

/**
 *
 * @author nimzo6689
 */
public interface ICalcState {

    /**
     * Event handling for number, "," and "%".
     *
     * @param context CalcContext object.
     * @param number CalcNumber type.
     * @param model CalcModel object.
     */
    public void onInputNumber(CalcContext context, CalcNumber number, CalcModel model);

    /**
     * Event handling for operation.
     *
     * @param context CalcContext object.
     * @param operation Operation type.
     * @param model CalcModel object.
     */
    public void onInputOperation(CalcContext context, Operation operation, CalcModel model);

    /**
     * Event handling for "=".
     *
     * @param context CalcContext object.
     * @param model CalcModel object.
     */
    public void onInputEqual(CalcContext context, CalcModel model);

    /**
     * Event handling for "C" and "AC".
     *
     * @param context CalcContext object.
     * @param model CalcModel object.
     */
    public void onInputClear(CalcContext context, CalcModel model);

    /**
     * Event handling for "+/-".
     *
     * @param model CalcModel object.
     */
    public void onInputSign(CalcModel model);

}
