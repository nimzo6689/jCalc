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
package com.qiita.nimzo6689.jcalc.code;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author nimzo6689
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Operator {

    PLUS("plus") {
        @Override
        public BigDecimal eval(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    },
    MINUS("minus") {
        @Override
        public BigDecimal eval(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }
    },
    TIMES("times") {
        @Override
        public BigDecimal eval(BigDecimal x, BigDecimal y) {
            return x.multiply(y);
        }
    },
    DIVIDE("divide") {
        @Override
        public BigDecimal eval(BigDecimal x, BigDecimal y) {
            return x.divide(y, 10, RoundingMode.FLOOR);
        }
    };

    /**
     *
     * @param value operator type. plus, minus, times or divide.
     * @return Operator enum object.
     */
    public static Operator of(String value) {
        for (Operator operator : Operator.values()) {
            if (operator.value.equals(value)) {
                return operator;
            }
        }
        throw new IllegalArgumentException(
                "Type:" + value + " is not a valid " + Operator.class.getName() + " value.");
    }

    private final String value;

    /**
     * Evaluate for each operator.
     *
     * @param x left operator.
     * @param y right operator.
     * @return result.
     */
    abstract public BigDecimal eval(BigDecimal x, BigDecimal y);

}
