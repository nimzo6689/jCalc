package com.qiita.nimzo6689.calculator;

import com.qiita.nimzo6689.calculator.code.Operation;
import com.qiita.nimzo6689.calculator.state.DefaultState;
import com.qiita.nimzo6689.calculator.state.ICalcState;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author nimzo6689
 */
@Log4j2
@Getter
@Setter
public class CalcController implements Initializable {

    /**
     * ディスプレイに表示される初期値
     */
    public static final String DEFAULT_VALUE = "0";

    @FXML
    private TextArea display;

    /**
     * 状態ごとに「C」「AC」の表示が切り替えられるボタン
     */
    @FXML
    private Button buttonDelete;

    private Operation operation;

    private BigDecimal registerA;
    private BigDecimal registerB;

    private ICalcState calcState;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        display.setEditable(false);
        display.setText(DEFAULT_VALUE);
        calcState = DefaultState.INSTANCE;
    }

    /**
     * 「数字、カンマ、％」がクリックされた時のイベント処理
     *
     * @param event
     */
    @FXML
    public void onInputNumber(Event event) {
        calcState.onInputNumber(event, this);
    }

    /**
     * 「＋ー×÷」ボタンが押された時のイベント処理
     *
     * @param event
     */
    @FXML
    public void onInputOperation(Event event) {
        calcState.onInputOperation(event, this);
    }

    /**
     * 「=」ボタンが押された時のイベント処理
     *
     * @param event
     */
    @FXML
    public void onInputEqual(Event event) {
        calcState.onInputEqual(event, this);
    }

    /**
     * 「C、AC」ボタンが押された時のイベント処理
     *
     * @param event
     */
    @FXML
    public void onInputClear(Event event) {
        calcState.onInputClear(event, this);
    }

    /**
     * 「+/-」ボタンが押された時のイベント処理
     */
    @FXML
    public void onInputSign() {
        calcState.onInputSign(this);
    }

}
