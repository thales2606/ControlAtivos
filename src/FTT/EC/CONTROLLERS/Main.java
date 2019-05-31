package FTT.EC.CONTROLLERS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnchorPane anchor = (AnchorPane) FXMLLoader.load(getClass().getResource("/FTT/EC/VIEWS/frHome.fxml"));
			Scene scene = new Scene(anchor);
			primaryStage.getIcons().add(new Image("/img/iconProg.png"));
			primaryStage.setTitle("Controle de Ativos");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
