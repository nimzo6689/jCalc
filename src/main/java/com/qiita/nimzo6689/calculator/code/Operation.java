package com.qiita.nimzo6689.calculator.code;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
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

    private Operation(final String value) {
        this.value = value;
    }

    /**
     * 演算子ごとの評価を実施
     *
     * @param x
     * @param y
     * @return
     */
    abstract public BigDecimal eval(BigDecimal x, BigDecimal y);

}
