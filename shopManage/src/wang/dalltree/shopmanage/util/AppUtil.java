package wang.dalltree.shopmanage.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
			e.printStackTrace();
		}

		return root;
	}
	
	public static Pane getFxmlPane(String pageName) {
		Properties pps = getAppConfig();
		if (pps.isEmpty()) {
			return null;
		}

		String path = pps.getProperty(pageName);

		Pane pane = null;
		try {
			pane = FXMLLoader.load(AppUtil.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pane;
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
	 * ȡ�û����������������֣������ظû�����������ť�¼������
	 * @param appTitle��̨ͷ
	 * @param fxml��FXML�ļ���
	 * @param stageStyle��������ʾ����
	 * @return
	 */
	public static Stage getStage(String appTitle, String fxml) {
		Stage stage = AppUtil.getStage();
		// ����Title
		stage.setTitle(appTitle);
		// ��ȡ��Դ�ļ�
		Parent root = AppUtil.getFxml(fxml);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.initStyle(StageStyle.DECORATED);
		
		return stage;
	}
	
	/**
	 * ��Ҫ�����ҳ���о����䶯������
	 * ��ģ�黯����ͬһ������ʾ���Ҳ�ͬʱ����״̬����ģ�黯
	 * �˷����ɱ任��һPane�����ģ��
	 * @param pane
	 * @param fxmlPaneName
	 * @return
	 */
	public static boolean changePane(Pane pane, String fxmlPaneName) {
		try {
			pane.getChildren().clear();
			Pane newPane = getFxmlPane(fxmlPaneName);
			
			for (int i = 0; i < newPane.getChildren().size(); i++) {
				Node e = newPane.getChildren().get(i);
				pane.getChildren().add(e);
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
