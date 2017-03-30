package com.qiita.nimzo6689.calculator.state;

import com.qiita.nimzo6689.calculator.CalcController;
import com.qiita.nimzo6689.calculator.code.CalcNumber;
import com.qiita.nimzo6689.calculator.code.Operation;
import java.math.BigDecimal;
import javafx.event.Event;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 * @author nimzo6689
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum DefaultState implements ICalcState {

    INSTANCE {
        @Override
        public void onInputNumber(Event event, CalcController controller) {
            Button btn = (Button) event.getSource();
            CalcNumber calcNumber = CalcNumber.of(btn.getId());
            if (CalcNumber.ZERO == calcNumber) {
                controller.getButtonDelete().setText("C");
                controller.getDisplay().setText("");
            }
            calcNumber.appendNumberTo(controller.getDisplay());
        }

        @Override
        public void onInputOperation(Event event, CalcController controller) {
            Button btn = (Button) event.getSource();
            controller.setOperation(Operation.of(btn.getId()));
            controller.setRegisterA(new BigDecimal(controller.getDisplay().getText()));
            controller.getDisplay().setText("");
        }

        @Override
        public void onInputEqual(Event event, CalcController controller) {
            controller.setRegisterB(new BigDecimal(controller.getDisplay().getText()));
            BigDecimal result = controller.getOperation().eval(controller.getRegisterA(), controller.getRegisterB());
            controller.getDisplay().setText(result.toPlainString());
            controller.setRegisterA(result);
            controller.setRegisterB(BigDecimal.ZERO);
        }

        @Override
        public void onInputClear(Event event, CalcController controller) {
            controller.getButtonDelete().setText("AC");
            controller.getDisplay().setText(CalcController.DEFAULT_VALUE);
        }

        @Override
        public void onInputSign(CalcController controller) {
            BigDecimal number = new BigDecimal(controller.getDisplay().getText());
            if (number != BigDecimal.ZERO) {
                controller.getDisplay().setText(number.negate().toPlainString());
            }
        }
    };

}
