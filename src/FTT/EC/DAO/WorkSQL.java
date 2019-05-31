package FTT.EC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkSQL {
	public static void ExecutaSQL(String _sql, ParametroSQL[] parametros) throws Exception {
		Connection conn = ConexaoDB.getConexaoMySQL();
		PreparedStatement preparedStmt = conn.prepareStatement(_sql);

		for (ParametroSQL parametroSQL : parametros) {
			preparedStmt.setObject(parametroSQL.getPosicao(), parametroSQL.getValor());
		}
		preparedStmt.execute();
		conn.close();
	}

	public static ResultSet ExecutaSelect(String _sql, ParametroSQL[] parametros) throws Exception {
		ResultSet rs = null;
		Connection conn = ConexaoDB.getConexaoMySQL();
		PreparedStatement st = conn.prepareStatement(_sql);
		if (parametros != null)
			for (ParametroSQL parametroSQL : parametros) {
				st.setObject(parametroSQL.getPosicao(), parametroSQL.getValor());
			}
		rs = st.executeQuery();
		//conn.close();
		return rs;
	}
}
