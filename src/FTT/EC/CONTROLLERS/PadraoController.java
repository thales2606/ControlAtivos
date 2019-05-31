package FTT.EC.CONTROLLERS;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import FTT.EC.DAO.PadraoDAO;
import FTT.EC.VO.PadraoVO;
import FTT.EC.VO.ENUMS.ModoOperacaoEnum;
import FTT.EC.VO.ENUMS.TipoMensagemEnum;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public abstract class PadraoController implements Initializable {

	protected PadraoDAO cadastroDAO;

	protected abstract void PreencheTela(FTT.EC.VO.PadraoVO o);

	@FXML
	protected FontAwesomeIcon btnInclui;
	@FXML
	protected FontAwesomeIcon btnAltera;
	@FXML
	public FontAwesomeIcon btnExclui;
	@FXML
	protected FontAwesomeIcon btnPrimeiro;
	@FXML
	protected FontAwesomeIcon btnAnterior;
	@FXML
	protected FontAwesomeIcon btnProximo;
	@FXML
	protected FontAwesomeIcon btnUltimo;
	@FXML
	protected FontAwesomeIcon btnGravar;
	@FXML
	protected FontAwesomeIcon btnCancelar;
	@FXML
	protected TextField txtId;

	protected void AlteraParaModo(ModoOperacaoEnum modo) {
		boolean desabilitado = modo == ModoOperacaoEnum.Navegacao;
		btnInclui.setDisable(desabilitado);
		btnAltera.setDisable(desabilitado);
		btnExclui.setDisable(desabilitado);

		btnPrimeiro.setDisable(desabilitado);
		btnAnterior.setDisable(desabilitado);
		btnProximo.setDisable(desabilitado);
		btnUltimo.setDisable(desabilitado);

		btnGravar.setDisable(!desabilitado);
		btnCancelar.setDisable(!desabilitado);

		if (modo == ModoOperacaoEnum.Inclusao) {
			txtId.setDisable(true);
			LimpaCampos();
		}
		ControlaCamposTela(modo);
	}

	protected abstract void ControlaCamposTela(ModoOperacaoEnum modo);

	protected abstract void LimpaCampos();

	private void btnAlteraClick() {
		AlteraParaModo(ModoOperacaoEnum.Alteracao);
	}

	@FXML
	protected void btnIncluiClick() {
		AlteraParaModo(ModoOperacaoEnum.Inclusao);
	}

	@FXML
	public void btnExcluiClick() {
		if (Mensagem("Deseja realmente excluir este item??", TipoMensagemEnum.confirm)) {
			try {
				cadastroDAO.Excluir(Integer.parseInt(txtId.getText()));
				PreencheTela(cadastroDAO.Primeiro());
			} catch (Exception erro) {
				TrataErro(erro);
			}
		}
	}

	@FXML
	private void btnGravarClick() {
		try {
			PadraoVO obj = PreencheObj();

			if (txtId.getText().trim() == "")
				cadastroDAO.Inserir(obj);
			else
				cadastroDAO.Alterar(obj);

			AlteraParaModo(ModoOperacaoEnum.Navegacao);
		} catch (Exception erro) {
			TrataErro(erro);
		}
	}

	protected abstract PadraoVO PreencheObj();

	private void btnCancelarClick() {
		try {
			PreencheTela(cadastroDAO.Consulta(Integer.parseInt(txtId.getText())));
			AlteraParaModo(ModoOperacaoEnum.Navegacao);
		} catch (Exception e) {
			TrataErro(e);
		}
	}

	private void btnAnteriorClick() {
		try {
			PadraoVO o = cadastroDAO.Anterior(Integer.parseInt(txtId.getText()));
			if (o != null)
				PreencheTela(o);
		} catch (Exception erro) {
			TrataErro(erro);
		}
	}

	private void btnPrimeiroClick() {
		try {
			PadraoVO o = cadastroDAO.Primeiro();
			PreencheTela(o);
		} catch (Exception erro) {
			TrataErro(erro);
		}
	}

	private void btnProximoClick() {
		try {
			PadraoVO o = cadastroDAO.Proximo(Integer.parseInt(txtId.getText()));
			if (o != null)
				PreencheTela(o);
		} catch (Exception erro) {
			TrataErro(erro);
		}
	}

	private void btnUltimoClick() {
		try {
			PadraoVO o = cadastroDAO.Ultimo();
			PreencheTela(o);
		} catch (Exception erro) {
			TrataErro(erro);
		}
	}

	protected void TrataErro(Exception erro) {
		if (erro instanceof NumberFormatException)
			Mensagem("Campo numérico inválido!", TipoMensagemEnum.erro);
		else if (erro instanceof SQLException)
			Mensagem("Ocorreu um erro no banco de dados.", TipoMensagemEnum.erro);
		else if (erro instanceof Exception)
			Mensagem(erro.getMessage(), TipoMensagemEnum.erro);
	}

	protected boolean Mensagem(String mensagem, TipoMensagemEnum tipo) {
		Alert alert = null;
		if (tipo == TipoMensagemEnum.confirm) {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Atenção");
		} else if (tipo == TipoMensagemEnum.alerta) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("Atenção");
		} else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Atenção");
		}
		alert.setHeaderText(mensagem);
		alert.showAndWait();
		return alert.getResult() == ButtonType.OK;
	}

	protected void PreencherEventos() {
		btnAltera.setOnMouseClicked((ActionEvent) -> btnAlteraClick());
		btnInclui.setOnMouseClicked((ActionEvent) -> btnIncluiClick());
		btnExclui.setOnMouseClicked((ActionEvent) -> btnExcluiClick());
		btnGravar.setOnMouseClicked((ActionEvent) -> btnGravarClick());
		btnCancelar.setOnMouseClicked((ActionEvent) -> btnCancelarClick());
		btnAnterior.setOnMouseClicked((ActionEvent) -> btnAnteriorClick());
		btnPrimeiro.setOnMouseClicked((ActionEvent) -> btnPrimeiroClick());
		btnProximo.setOnMouseClicked((ActionEvent) -> btnProximoClick());
		btnUltimo.setOnMouseClicked((ActionEvent) -> btnUltimoClick());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			AlteraParaModo(ModoOperacaoEnum.Navegacao);
			PreencherEventos();
			PreencheTela(cadastroDAO.Primeiro());
		} catch (Exception e) {
			TrataErro(e);
		}
	}
}
