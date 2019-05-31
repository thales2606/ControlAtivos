package FTT.EC.VO;

public class DepreciacaoVO {
	private AtivoVO ativo;
	private double taxaDepre, taxaEmpresa;
	public AtivoVO getAtivo() {
		return ativo;
	}
	public void setAtivo(AtivoVO ativo) {
		this.ativo = ativo;
	}
	public double getTaxaDepre() {
		return taxaDepre;
	}
	public void setTaxaDepre(double taxaDepre) {
		this.taxaDepre = taxaDepre;
	}
	public double getTaxaEmpresa() {
		return taxaEmpresa;
	}
	public void setTaxaEmpresa(double taxaEmpresa) {
		this.taxaEmpresa = taxaEmpresa;
	}
}
