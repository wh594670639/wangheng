package wang.dalltree.shopmanage.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import wang.dalltree.shopmanage.common.Const;
import wang.dalltree.shopmanage.common.ServiceResultObject;
import wang.dalltree.shopmanage.service.UserService;
import wang.dalltree.shopmanage.util.AppUtil;

public class LoginController implements Initializable{
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button loginBtn;
	@FXML
	private Label statusText;
	@FXML
	private Button closeBtn;
	@FXML
	private Pane loginPane;
	
	// 页面初始化
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 按键事件
		loginPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// 回车键
				if (KeyCode.ENTER.equals(event.getCode())) {
					loginButtonAction(new ActionEvent());
				}
			}
		});
	}
	
	@FXML
	protected void loginButtonAction(ActionEvent event) {
		statusText.setCenterShape(true);
		
		UserService checkUser = new UserService();
		ServiceResultObject result = checkUser.checkUser(username.getText().trim(), password.getText().trim());
		
		// 跳转到主页面
		if (ServiceResultObject.SUCCESS.equals(result.getResult())) {
			Stage stage = AppUtil.getStage(AppUtil.getAppTitle(), Const.MAIN_FXML);
			stage.setMaximized(true);// 全屏
			stage.show();
			
			// 调整页面
			Parent p = stage.getScene().getRoot();
			Pane pane = (Pane) p.lookup("#changePane");
			Label welcome = (Label) p.lookup("#welcome");
			System.out.println(pane.getScaleX());
			System.out.println(pane.getScaleY());
			System.out.println(pane.getScaleZ());
			pane.getScaleX();
			pane.getScaleY();
			pane.getScaleZ();
			double paneHeight = pane.getHeight();
			double paneWidth = pane.getWidth();
			
			System.out.println(paneHeight);
			System.out.println(paneWidth);
			
			paneHeight = paneHeight/2;
			paneWidth = paneWidth/2;
			
			System.out.println(paneHeight);
			System.out.println(paneWidth);
			
			welcome.setScaleX(10);
			welcome.setScaleY(10);
		}
		
		statusText.setText(result.getObject().toString());
	}
	
	/**
	 * 关闭按钮
	 * @param event
	 */
	@FXML
	protected void closeButtonAction(ActionEvent event) {
		AppUtil.getStage().close();
	}
}
