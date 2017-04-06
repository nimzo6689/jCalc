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

import com.qiita.nimzo6689.jcalc.code.Operation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nimzo6689
 */
@ToString
public class CalcModel {

    private StringProperty displayProperty = null;
    private String value;

    @Getter
    @Setter
    private Operation operation;
    @Getter
    @Setter
    private BigDecimal registerA;
    @Getter
    @Setter
    private BigDecimal registerB;

    public StringProperty displayProperty() {
        if (Objects.isNull(displayProperty)) {
            displayProperty = new SimpleStringProperty("0");
        }
        return displayProperty;
    }

    public String getValue() {
        if (Objects.nonNull(displayProperty)) {
            return displayProperty.get();
        }
        return value;
    }

    public void setValue(String value) {
        if (Objects.nonNull(displayProperty)) {
            displayProperty.set(value);
        } else {
            this.value = value;
        }

    }

}
