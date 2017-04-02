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

import javafx.scene.control.TextArea;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author nimzo6689
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CalcNumber {

    COMMA("comma", "."),
    ZERO("zero", "0"),
    DOUBLE_ZERO("double_zero", "00"),
    ONE("one", "1"),
    TWO("two", "2"),
    THREE("three", "3"),
    FOUR("four", "4"),
    FIVE("five", "5"),
    SIX("six", "6"),
    SEVEN("seven", "7"),
    EIGHT("eight", "8"),
    NINE("nine", "9"),;

    /**
     *
     * @param value FXML id attribute for Number.
     * @return CalcNumber enum object.
     */
    public static CalcNumber of(String value) {
        for (CalcNumber calcNumber : CalcNumber.values()) {
            if (calcNumber.value.equals(value)) {
                return calcNumber;
            }
        }
        throw new IllegalArgumentException(
                "Type:" + value + " is not a valid " + CalcNumber.class.getName() + " value.");
    }

    private final String value;
    private final String number;

    /**
     *
     * @param textArea display object in FXML.
     */
    public void appendNumberTo(TextArea textArea) {
        textArea.appendText(number);
    }

}
