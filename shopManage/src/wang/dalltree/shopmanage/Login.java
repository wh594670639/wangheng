package wang.dalltree.shopmanage;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import wang.dalltree.shopmanage.common.Const;
import wang.dalltree.shopmanage.util.AppUtil;

public class Login extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// 保存舞台
		AppUtil.setStage(stage);
		
		// 设置Title
		stage.setTitle(AppUtil.getAppTitle());
		// 读取资源文件
		Parent root = AppUtil.getFxml(Const.LOGIN_FXML);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
//		stage.setAlwaysOnTop(true);// 总是最前端-流氓做法
		stage.initStyle(StageStyle.TRANSPARENT);
		
		stage.show();
	}
}
