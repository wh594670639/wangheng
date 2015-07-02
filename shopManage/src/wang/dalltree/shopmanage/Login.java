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
		// ������̨
		AppUtil.setStage(stage);
		
		// ����Title
		stage.setTitle(AppUtil.getAppTitle());
		// ��ȡ��Դ�ļ�
		Parent root = AppUtil.getFxml(Const.LOGIN_FXML);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
//		stage.setAlwaysOnTop(true);// ������ǰ��-��å����
		stage.initStyle(StageStyle.TRANSPARENT);
		
		stage.show();
	}
}
