package FTT.EC.CONTROLLERS;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class HomeController implements Initializable {

	@FXML
	private Pane PaneBody;
	@FXML
	private Button btnAtivos;
	@FXML
	private Button btnFornecedores;
	@FXML
	private Button btnManutencao;
	@FXML
	private Button btnUsuarios;
	@FXML
	private Button btnDashBoard;
	@FXML
	private Button btnSair;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			BorderPane p = FXMLLoader.load(getClass().getResource("/FTT/EC/VIEWS/frDashboard.fxml"));
			PaneBody.getChildren().add(p);

			btnDashBoard.setOnMouseClicked((ActionEvent)->DashboardClick());
			btnAtivos.setOnMouseClicked((ActionEvent)->btnAtivosClick());
			btnFornecedores.setOnMouseClicked((ActionEvent)->btnFornecedoresClick());
			btnManutencao.setOnMouseClicked((ActionEvent)->btnManutencaoClick());
			btnUsuarios.setOnMouseClicked((ActionEvent)->btnUsuariosClick());
			btnSair.setOnMouseClicked((ActionEvent)->btnSairClick());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void btnSairClick() {
	
	}
	private void btnUsuariosClick() {
		try {
			PaneBody.getChildren().clear();
			BorderPane p = FXMLLoader.load(getClass().getResource("/FTT/EC/VIEWS/frUsuarios.fxml"));
			PaneBody.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void btnManutencaoClick() {
		try {
			PaneBody.getChildren().clear();
			BorderPane p = FXMLLoader.load(getClass().getResource("/FTT/EC/VIEWS/frManutencao.fxml"));
			PaneBody.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void btnFornecedoresClick() {
		try {
			PaneBody.getChildren().clear();
			BorderPane p = FXMLLoader.load(getClass().getResource("/FTT/EC/VIEWS/frFornecedores.fxml"));
			PaneBody.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void btnAtivosClick() {
		try {
			PaneBody.getChildren().clear();
			BorderPane p = FXMLLoader.load(getClass().getResource("/FTT/EC/VIEWS/frAtivos.fxml"));
			PaneBody.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void DashboardClick() {
		try {
			PaneBody.getChildren().clear();
			BorderPane p = FXMLLoader.load(getClass().getResource("/FTT/EC/VIEWS/frDashboard.fxml"));
			PaneBody.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
