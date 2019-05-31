package FTT.EC.DAO;

import java.sql.ResultSet;

import FTT.EC.VO.PadraoVO;

public class UsuarioDAO extends PadraoDAO {

	public UsuarioDAO() {
		setKey("Id");
		setTable("Usuarios");
	}
	@Override
	protected String MontaSQLInsert() {		
		return "insert into usuarios() values()";
	}
	@Override
	protected String MontaSQLUpdate() {
		return "update set usuarios set where " + getKey() + " = @id";
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
