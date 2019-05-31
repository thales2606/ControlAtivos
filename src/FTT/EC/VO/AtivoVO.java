package FTT.EC.VO;

import java.util.Date;

public class AtivoVO extends PadraoVO {
	String nome,setor, descricao, pathImg;
	double vlrCompra;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPathImg() {
		return pathImg;
	}
	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}
	public double getVlrCompra() {
		return vlrCompra;
	}
	public void setVlrCompra(double vlrCompra) {
		this.vlrCompra = vlrCompra;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Date getValidadeGarantia() {
		return validadeGarantia;
	}
	public void setValidadeGarantia(Date validadeGarantia) {
		this.validadeGarantia = validadeGarantia;
	}
	public int getNumNota() {
		return numNota;
	}
	public void setNumNota(int numNota) {
		this.numNota = numNota;
	}
	public int getTipoGarantia() {
		return tipoGarantia;
	}
	public void setTipoGarantia(int tipoGarantia) {
		this.tipoGarantia = tipoGarantia;
	}
	public int getIdClassific() {
		return idClassific;
	}
	public void setIdClassific(int idClassific) {
		this.idClassific = idClassific;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	Date dataCompra, validadeGarantia;
	int numNota, tipoGarantia, idClassific, idUsuario;
}
