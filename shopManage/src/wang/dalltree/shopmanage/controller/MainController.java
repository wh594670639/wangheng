package wang.dalltree.shopmanage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import wang.dalltree.shopmanage.common.Const;
import wang.dalltree.shopmanage.util.AppUtil;
import javafx.scene.layout.Pane;

public class MainController {
	@FXML
	private Button main_CloseBtn;
	@FXML
	private Button module_buy;
	@FXML
	private Pane changePane;
	@FXML
	private Label welcome;
	
	/**
	 * 关闭按钮
	 * @param event
	 */
	@FXML
	protected void closeButtonAction(ActionEvent event) {
		AppUtil.getStage().close();
	}
	
	@FXML
	protected void openBuyModuleAction(ActionEvent event) {
		AppUtil.changePane(changePane, Const.CAIGOU_FXML);
	}
}
