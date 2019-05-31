package FTT.EC.CONTROLLERS;

import java.sql.Date;
import java.time.ZoneId;

import FTT.EC.DAO.AtivoDAO;
import FTT.EC.VO.AtivoVO;
import FTT.EC.VO.PadraoVO;
import FTT.EC.VO.ENUMS.ModoOperacaoEnum;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AtivosController extends PadraoController {
	public AtivosController() {
		super();
		cadastroDAO = new AtivoDAO();
	}

	@FXML
	public TextField txtNome;
	@FXML
	public TextField txtSetor;
	@FXML
	public TextField txtVlrCompra;
	@FXML
	public TextField txtImgPath;
	@FXML
	public TextField txtNumNota;
	@FXML
	public DatePicker dtCompra;
	@FXML
	public TextField txtTipoGarantia;
	@FXML
	public DatePicker dtValidade;
	@FXML
	public ComboBox<String> cbClassific;
	@FXML
	public ComboBox<String> cbUsuario;
	@FXML
	public TextArea txtDescri;

	@Override
	protected void PreencheTela(PadraoVO o) {
		AtivoVO ativo = (AtivoVO) o;
		txtId.setText(String.valueOf(ativo.getId()));
		txtNome.setText(ativo.getNome());
		txtSetor.setText(ativo.getSetor());
		txtVlrCompra.setText(String.valueOf(ativo.getVlrCompra()));
		txtImgPath.setText(ativo.getPathImg());
		txtNumNota.setText(String.valueOf(ativo.getNumNota()));
		dtCompra.setValue(ativo.getDataCompra().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		txtTipoGarantia.setText(String.valueOf(ativo.getTipoGarantia()));
		txtDescri.setText(ativo.getDescricao());
	}

	@Override
	protected void ControlaCamposTela(ModoOperacaoEnum modo) {
		boolean editavel = modo == ModoOperacaoEnum.Navegacao;
		try {
			txtNome.setDisable(editavel);
			txtSetor.setDisable(editavel);
			txtVlrCompra.setDisable(editavel);
			txtImgPath.setDisable(editavel);
			txtNumNota.setDisable(editavel);
			dtCompra.setDisable(editavel);
			txtTipoGarantia.setDisable(editavel);
			txtDescri.setDisable(editavel);
			cbClassific.setDisable(editavel);
			cbUsuario.setDisable(editavel);
		} catch (Exception e) {
			TrataErro(e);
		}
	}

	@Override
	protected void LimpaCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtSetor.setText("");
		txtVlrCompra.setText("");
		txtImgPath.setText("");
		txtNumNota.setText("");
		dtCompra.setValue(null);
		txtTipoGarantia.setText("");
		txtDescri.setText("");
	}

	@Override
	protected PadraoVO PreencheObj() {
		AtivoVO ativo = new AtivoVO();
		ativo.setNome(txtNome.getText());
		ativo.setSetor(txtSetor.getText());
		ativo.setVlrCompra(Double.parseDouble(txtVlrCompra.getText()));
		ativo.setPathImg(txtImgPath.getText());
		ativo.setNumNota(Integer.parseInt(txtNumNota.getText()));
		ativo.setDataCompra(Date.valueOf(dtCompra.getValue()));
		ativo.setTipoGarantia(Integer.parseInt(txtTipoGarantia.getText()));
		ativo.setDescricao(txtDescri.getText());
		return ativo;
	}
}
