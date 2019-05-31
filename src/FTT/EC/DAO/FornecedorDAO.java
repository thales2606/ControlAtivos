package FTT.EC.DAO;

import java.sql.ResultSet;

import FTT.EC.VO.PadraoVO;

public class FornecedorDAO extends PadraoDAO {
	public FornecedorDAO() {
		setKey("Id");
		setTable("tb_Fornecedores");
	}

	@Override
	protected String MontaSQLInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String MontaSQLUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ParametroSQL[] CriaParametros(PadraoVO o, boolean update) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PadraoVO MontaVO(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
