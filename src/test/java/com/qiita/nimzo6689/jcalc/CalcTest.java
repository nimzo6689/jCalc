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

import javafx.stage.Stage;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.hasText;

/**
 * RegisterA -> Operation -> RegisterB -> Result.
 *
 * @author nimzo6689
 */
@Log4j2
public class CalcTest extends ApplicationTest {

    /**
     *
     * @param stage stage
     */
    @Override
    @SneakyThrows
    public void start(Stage stage) {
        new Bootstrap().start(stage);
    }

    @Test
    public void test_onInputNumber_in_registerA() {
        log.debug("test_onInputNumber_in_registerA");

        clickOn("#zero");
        clickOn("#zero");
        verifyThat("#display", hasText("0"));

        clickOn("#zero");
//        clickOn("#comma");
//        clickOn("#comma");
        clickOn("#zero");
        clickOn("#zero");
        clickOn("#one");
//        verifyThat("#display", hasText("0.001"));
        verifyThat("#display", hasText("1"));

        clickOn("#clear");
        verifyThat("#display", hasText("0"));

        clickOn("#two");
        clickOn("#three");
        clickOn("#four");
        clickOn("#five");
        clickOn("#six");
        clickOn("#seven");
        clickOn("#eight");
        clickOn("#nine");
        verifyThat("#display", hasText("23456789"));

        clickOn("#sign");
        verifyThat("#display", hasText("-23456789"));
    }

    @Test
    public void test_cycle_operation_result() {
        log.debug("test_cycle_operation_result");

        clickOn("#one");
        clickOn("#plus");
        clickOn("#two");
        clickOn("#equal");
        verifyThat("#display", hasText("3"));

        clickOn("#one");
        clickOn("#plus");
        clickOn("#minus");
        clickOn("#two");
        clickOn("#equal");
        verifyThat("#display", hasText("-1"));

        clickOn("#three");
        clickOn("#times");
        clickOn("#two");
        clickOn("#three");
        clickOn("#equal");
        verifyThat("#display", hasText("69"));

//        clickOn("#nine");
//        clickOn("#divide");
//        clickOn("#two");
//        clickOn("#equal");
//        clickOn("#equal");
//        verifyThat("#display", hasText("4.5"));
    }

    @Test
    public void test_cycle_registerA_operation_result() {
        log.debug("test_cycle_registerA_operation_result");

        // RegisterA -> Operation
        clickOn("#one");
        clickOn("#two");
        clickOn("#plus");
        verifyThat("#display", hasText("12"));

        // Operation -> RegisterA
        clickOn("#clear");
        clickOn("#clear");
        verifyThat("#display", hasText("0"));

        // RegisterA -> Result
        clickOn("#equal");
        verifyThat("#display", hasText("0"));

        // Result -> RegisterA
        clickOn("#clear");
        verifyThat("#display", hasText("0"));

        // RegisterA -> Operation -> Result
//        clickOn("#five");
//        clickOn("#times");
//        clickOn("#equal");
//        verifyThat("#display", hasText("25"));
        clickOn("#two");
        clickOn("#five");

        // Result -> Operation -> RegisterB -> Result
//        clickOn("#minus");
//        clickOn("#three");
//        clickOn("#zero");
//        clickOn("#equal");
//        verifyThat("#display", hasText("-5"));

        // Result -> Operation -> RegisterB -> Operation -> Result
//        clickOn("#plus");
//        clickOn("#six");
//        clickOn("#zero");
//        clickOn("#divide");
//        clickOn("#one");
//        clickOn("#one");
//        verifyThat("#display", hasText("5"));
    }

}
