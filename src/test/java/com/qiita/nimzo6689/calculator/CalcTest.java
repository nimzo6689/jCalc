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
package com.qiita.nimzo6689.calculator;

import java.lang.reflect.Method;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.hasText;

/**
 * RegisterA -> Operation -> RegisterB -> Result.
 *
 * @author nimzo6689
 */
public class CalcTest extends ApplicationTest {

    /**
     *
     * @param stage stage
     */
    @Override
    @SneakyThrows
    public void start(Stage stage) {
        CalcMain calcMain = new CalcMain();
        Method method = calcMain.getClass().getDeclaredMethod("getParent");
        method.setAccessible(true);
        stage.setScene(new Scene((Parent) method.invoke(calcMain)));
        stage.show();
    }

    /**
     * RegisterA -> Operation -> RegisterB -> Result.
     */
    @Test
    public void should_12_plus_4_equal_16() {
        clickOn("1");
        clickOn("2");
        clickOn("#plus");
        clickOn("4");
        clickOn("#equal");
//        verifyThat("#display", hasText("16"));

        clickOn("1");
        verifyThat("#display", hasText("1"));

        clickOn("#sign");
        verifyThat("#display", hasText("-1"));
    }

    /**
     * RegisterA -> Operation -> RegisterB -> Result.
     */
    @Test
    public void should_12_minus_4_equal_8() {
        // given:
        clickOn("1");
        clickOn("2");
        clickOn("#minus");
        clickOn("4");
        clickOn("#equal");

        // then:
        verifyThat("#display", hasText("8"));
    }

    /**
     * RegisterA -> Operation -> RegisterB -> Result.
     */
    @Test
    public void should_12_times_4_equal_48() {
        // given:
        clickOn("1");
        clickOn("2");
        clickOn("#times");
        clickOn("4");
        clickOn("#equal");

        // then:
        verifyThat("#display", hasText("48"));
    }

    /**
     * RegisterA -> Operation -> RegisterB -> Result.
     */
    @Test
    public void should_12_divide_4_equal_3() {
        // given:
        clickOn("1");
        clickOn("2");
        clickOn("#divide");
        clickOn("4");
        clickOn("#equal");

        // then:
        verifyThat("#display", hasText("3"));
    }

}
