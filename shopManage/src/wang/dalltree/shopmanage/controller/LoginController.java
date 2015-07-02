package wang.dalltree.shopmanage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import wang.dalltree.shopmanage.common.Const;
import wang.dalltree.shopmanage.common.ServiceResultObject;
import wang.dalltree.shopmanage.service.UserService;
import wang.dalltree.shopmanage.util.AppUtil;

public class LoginController {
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button loginBtn;
	@FXML private Label statusText;
	@FXML private Button closeBtn;
	
	@FXML protected void loginButtonAction(ActionEvent event) {
		statusText.setCenterShape(true);
		
		UserService checkUser = new UserService();
		ServiceResultObject result = checkUser.checkUser(username.getText().trim(), password.getText().trim());
		
		// 跳转到主页面
		if (ServiceResultObject.SUCCESS.equals(result.getResult())) {
			Stage stage = AppUtil.getStage(AppUtil.getAppTitle(), Const.MAIN_FXML);
			
			stage.show();
		}
		
		statusText.setText(result.getObject().toString());
	}
	
	/**
	 * 关闭按钮
	 * @param event
	 */
	@FXML protected void closeButtonAction(ActionEvent event) {
		AppUtil.getStage().close();
	}
}
