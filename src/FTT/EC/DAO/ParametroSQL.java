package FTT.EC.DAO;

public class ParametroSQL {
	int posicao;
	Object valor;

	public ParametroSQL(int _posicao, Object _valor) {
		posicao = _posicao;
		valor = _valor;
	}	
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}
}
