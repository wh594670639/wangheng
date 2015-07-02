package wang.dalltree.shopmanage.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import wang.dalltree.shopmanage.common.Const;

public class AppUtil {
	private static Stage stage = null;
	
	private static Properties getAppConfig() {
		Properties pps = new Properties();
		try {
			pps.load(new FileInputStream(
					System.getProperty("user.dir")
					+ File.separatorChar 
					+ "src" 
					+ File.separatorChar
					+ Const.APP_CONFIG_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pps;
	}

	public static String getAppTitle() {
		Properties pps = getAppConfig();
		if (pps.isEmpty()) {
			return null;
		}

		return pps.getProperty(Const.SYSTEM_TITLE);
	}

	public static Parent getFxml(String pageName) {
		Properties pps = getAppConfig();
		if (pps.isEmpty()) {
			return null;
		}

		String path = pps.getProperty(pageName);

		Parent root = null;
		try {
			root = FXMLLoader.load(AppUtil.class.getResource(path));
		} catch (IOException e) {
		}

		return root;
	}
	
	public static Stage getStage() {
		stage.hide();
		stage = new Stage();
		return stage;
	}
	
	public static void setStage(Stage stage) {
		AppUtil.stage = stage;
	}
	
	/**
	 * 取得画布：包括参数部分，并返回该画布，包括按钮事件的添加
	 * @param appTitle：台头
	 * @param fxml：FXML文件名
	 * @param stageStyle：画布显示类型
	 * @return
	 */
	public static Stage getStage(String appTitle, String fxml) {
		Stage stage = AppUtil.getStage();
		// 设置Title
		stage.setTitle(appTitle);
		// 读取资源文件
		Parent root = AppUtil.getFxml(fxml);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.initStyle(StageStyle.DECORATED);
		
		return stage;
	}
}
