package FTT.EC.DAO;

import java.sql.ResultSet;

import FTT.EC.VO.AtivoVO;
import FTT.EC.VO.DepreciacaoVO;

public class DeprecicaoDAL {
	public DepreciacaoVO Depreci(int id) throws Exception {
		DepreciacaoVO dp = null;
		ResultSet rs = WorkSQL.ExecutaSelect("select id, ncm, TAXA_DEPRECIACAO from TB_CLASSIFICACAO a inner join tb_Ativos b where a.id = ?", 
				new ParametroSQL[] {
						new ParametroSQL(1, id)
				});
		if(rs.next()) {
			dp=new DepreciacaoVO();
			dp.setAtivo((AtivoVO)(new AtivoDAO()).Consulta(id));
			dp.setTaxaDepre(rs.getDouble("TAXA_DEPRECIACAO"));
		}
		return null;
	}
}
