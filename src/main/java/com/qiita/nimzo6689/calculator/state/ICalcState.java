package com.qiita.nimzo6689.calculator.state;

import com.qiita.nimzo6689.calculator.CalcController;
import javafx.event.Event;

/**
 *
 * @author nimzo6689
 */
public interface ICalcState {
    
     /**
     * 「数字、カンマ、％」がクリックされた時のイベント処理
     *
     * @param event
     */
    public void onInputNumber(Event event, CalcController controller);

    /**
     * 「＋ー×÷」ボタンが押された時のイベント処理
     *
     * @param event
     */
    public void onInputOperation(Event event, CalcController controller);

    /**
     * 「=」ボタンが押された時のイベント処理
     *
     * @param event
     */
    public void onInputEqual(Event event, CalcController controller);

    /**
     * 「C、AC」ボタンが押された時のイベント処理
     *
     * @param event
     */
    public void onInputClear(Event event, CalcController controller);

    /**
     * 「+/-」ボタンが押された時のイベント処理
     */
    public void onInputSign(CalcController controller);
    
}
