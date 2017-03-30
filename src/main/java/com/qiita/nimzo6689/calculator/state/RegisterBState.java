package com.qiita.nimzo6689.calculator.state;

import com.qiita.nimzo6689.calculator.CalcController;
import javafx.event.Event;

/**
 *
 * @author nimzo6689
 */
public enum RegisterBState implements ICalcState {
    
    INSTANCE {
        @Override
        public void onInputNumber(Event event, CalcController controller) {
        }

        @Override
        public void onInputOperation(Event event, CalcController controller) {
        }

        @Override
        public void onInputEqual(Event event, CalcController controller) {
        }

        @Override
        public void onInputClear(Event event, CalcController controller) {
        }

        @Override
        public void onInputSign(CalcController controller) {
        }
    }
    
}
