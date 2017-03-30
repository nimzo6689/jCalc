package com.qiita.nimzo6689.calculator.code;

import javafx.scene.control.TextArea;
import lombok.Getter;

/**
 *
 * @author nimzo6689
 */
@Getter
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
     * @param value
     * @return
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

    private CalcNumber(String value, String number) {
        this.value = value;
        this.number = number;
    }

    /**
     *
     * @param textArea
     */
    public void appendNumberTo(TextArea textArea) {
        textArea.appendText(number);
    }

}
