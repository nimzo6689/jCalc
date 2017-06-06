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

import com.qiita.nimzo6689.jcalc.code.Operator;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Matcher;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.val;

/**
 *
 * @author nimzo6689
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CalcModel {

    private static final CalcModel INSTANCE = new CalcModel();

    public static CalcModel getInstance() {
        return INSTANCE;
    }

    private StringProperty displayProperty = null;

    @Getter
    @Setter
    private Operator operator;
    @Getter
    @Setter
    private BigDecimal registerA;
    @Getter
    @Setter
    private BigDecimal registerB;

    public StringProperty displayProperty() {
        if (Objects.isNull(displayProperty)) {
            displayProperty = new SimpleStringProperty(CalcConstants.DISPLAY_INITIAL_VALUE);
        }
        return displayProperty;
    }

    public String getDisplay() {
        return displayProperty.get().replaceAll(",", "");
    }

    public BigDecimal getDisplayToBicDecimal() {
        return new BigDecimal(getDisplay());
    }

    /**
     *
     * @param display origin number for displaying.
     */
    public void setDisplay(String display) {
        val displayBigDecimal = new BigDecimal(display);
        
        // DecimalFormat can't have LOSS_OF_TRAILING_DIGITS.
        Matcher lossMatcher = CalcConstants.LOSS_OF_TRAILING_DIGITS.matcher(display);
        if (lossMatcher.find()) {
            displayProperty.set(CalcConstants.DECIMAL_FORMAT.format(displayBigDecimal)
                    + lossMatcher.group());
            return;
        }
        displayProperty.set(CalcConstants.DECIMAL_FORMAT.format(displayBigDecimal));
    }

}
