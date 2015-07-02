package wang.dalltree.shopmanage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import wang.dalltree.shopmanage.util.AppUtil;

public class MainController {
	@FXML private Button main_CloseBtn;
	@FXML private Button module_buy;
	
	/**
	 * ¹Ø±Õ°´Å¥
	 * @param event
	 */
	@FXML protected void closeButtonAction(ActionEvent event) {
		AppUtil.getStage().close();
	}
	
	@FXML protected void openBuyModuleAction(ActionEvent event) {
		System.out.println("aaaaaaaaaaaaaaa");
	}
}
