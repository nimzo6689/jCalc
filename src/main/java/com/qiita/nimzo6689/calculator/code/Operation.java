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
package com.qiita.nimzo6689.calculator.code;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Operation {
    PLUS("plus") {
        public BigDecimal eval(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    },
    MINUS("minus") {
        public BigDecimal eval(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }
    },
    TIMES("times") {
        public BigDecimal eval(BigDecimal x, BigDecimal y) {
            return x.multiply(y);
        }
    },
    DIVIDE("divide") {
        public BigDecimal eval(BigDecimal x, BigDecimal y) {
            return x.divide(y);
        }
    };

    /**
     *
     * @param value
     * @return
     */
    public static Operation of(String value) {
        for (Operation operation : Operation.values()) {
            if (operation.value.equals(value)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(
                "Type:" + value + " is not a valid " + Operation.class.getName() + " value.");
    }

    private final String value;

    /**
     * 演算子ごとの評価を実施
     *
     * @param x
     * @param y
     * @return
     */
    abstract public BigDecimal eval(BigDecimal x, BigDecimal y);

}
