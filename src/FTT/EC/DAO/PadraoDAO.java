package FTT.EC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import FTT.EC.VO.PadraoVO;

public abstract class PadraoDAO {

	private String table, key;

	protected String getTable() {
		return table;
	}

	protected void setTable(String table) {
		this.table = table;
	}

	protected String getKey() {
		return key;
	}

	protected void setKey(String key) {
		this.key = key;
	}

	protected abstract String MontaSQLInsert();

	protected abstract String MontaSQLUpdate();

	protected abstract ParametroSQL[] CriaParametros(PadraoVO o, boolean update);

	protected abstract PadraoVO MontaVO(ResultSet rs);

	protected String MontaSQLDelete() {
		return "delete " + getTable() + " where " + getKey() + " =  ?";
	}

	protected String MontaSQLConsulta() {
		return "select * from " + getTable() + " where " + getKey() + " =  ?";
	}

	public void Inserir(PadraoVO o) throws Exception {
		String sql = MontaSQLInsert();
		WorkSQL.ExecutaSQL(sql, CriaParametros(o, false));
	}

	public void Alterar(PadraoVO o) throws Exception {
		String sql = MontaSQLUpdate();
		WorkSQL.ExecutaSQL(sql, CriaParametros(o, true));
	}

	public void Excluir(int Id) throws Exception {
		String sql = MontaSQLDelete();
		ParametroSQL[] parametros = new ParametroSQL[1];
		parametros[0] = new ParametroSQL(1, Id);
		WorkSQL.ExecutaSQL(sql, parametros);
	}

	public PadraoVO Consulta(int id) throws Exception {
		String sql = MontaSQLConsulta();
		ParametroSQL[] parametros = { new ParametroSQL(1, id) };
		return ExecutaSqlLocal(sql, parametros);
	}

	public PadraoVO Primeiro() throws Exception {
		String sql = "select * from " + getTable() + " order by " + getKey() + " LIMIT 1;";
		return ExecutaSqlLocal(sql, null);
	}

	public PadraoVO Ultimo() throws Exception {
		String sql = "select * from " + getTable() + " order by " + getKey() + " desc LIMIT 1;";
		return ExecutaSqlLocal(sql, null);
	}

	public PadraoVO Proximo(int atual) throws Exception {
		String sql = "select * from " + getTable() + " where " + getKey() + " > ?  order by " + getKey() + " LIMIT 1;";
		ParametroSQL[] p = { new ParametroSQL(1, atual) };
		return ExecutaSqlLocal(sql, p);
	}

	public PadraoVO Anterior(int atual) throws Exception {
		String sql = "select * from " + getTable() + " where " + getKey() + " < ?  order by " + getKey() + " LIMIT 1;"
				+ " desc";
		ParametroSQL[] p = { new ParametroSQL(1, atual) };
		return ExecutaSqlLocal(sql, p);
	}

	protected PadraoVO ExecutaSqlLocal(String sql, ParametroSQL[] parametros) throws Exception {
		ResultSet rs = WorkSQL.ExecutaSelect(sql, parametros);
		if (rs.next())
			return MontaVO(rs);
		return null;
	}
}
