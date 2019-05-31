package FTT.EC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import FTT.EC.VO.AtivoVO;
import FTT.EC.VO.PadraoVO;

public class AtivoDAO extends PadraoDAO {
	public AtivoDAO() {
		setKey("Id");
		setTable("tb_Ativos");
	}

	@Override
	protected String MontaSQLInsert() {
		return "insert into tb_Ativos(NOME, SETOR, VlrCompra, dtCOMPRA, numNota, tpGarantia, "
				+ "ValGARANTIA, DESCRICAO, ImgPath, IDCLASSIFI, IDUSUARIO) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	protected String MontaSQLUpdate() {
		return "update tb_Ativos set NOME = ?, SETOR = ?, VlrCompra = ?, dtCOMPRA = ?, numNota = ?, "
				+ "tpGarantia = ?, ValGARANTIA = ?, DESCRICAO = ?, " + "ImgPath = ?, IDCLASSIFI = ?, IDUSUARIO = ? "
				+ " where id = ?";
	}

	@Override
	protected ParametroSQL[] CriaParametros(PadraoVO o, boolean update) {
		ParametroSQL[] r = null;
		if (o instanceof AtivoVO) {
			r = new ParametroSQL[12];
			if (!update) {
				r[0] = new ParametroSQL(1, o.getId());
				r[1] = new ParametroSQL(2, ((AtivoVO) o).getDataCompra());
				r[2] = new ParametroSQL(3, ((AtivoVO) o).getDescricao());
				r[3] = new ParametroSQL(4, ((AtivoVO) o).getIdClassific());
				r[4] = new ParametroSQL(5, ((AtivoVO) o).getIdUsuario());
				r[5] = new ParametroSQL(6, ((AtivoVO) o).getNome());
				r[6] = new ParametroSQL(7, ((AtivoVO) o).getNumNota());
				r[7] = new ParametroSQL(8, ((AtivoVO) o).getPathImg());
				r[8] = new ParametroSQL(9, ((AtivoVO) o).getSetor());
				r[9] = new ParametroSQL(10, ((AtivoVO) o).getTipoGarantia());
				r[10] = new ParametroSQL(11, ((AtivoVO) o).getValidadeGarantia());
				r[11] = new ParametroSQL(12, ((AtivoVO) o).getVlrCompra());
			}
			else {
				r[0] = new ParametroSQL(1, ((AtivoVO) o).getDataCompra());
				r[1] = new ParametroSQL(2, ((AtivoVO) o).getDescricao());
				r[2] = new ParametroSQL(3, ((AtivoVO) o).getIdClassific());
				r[3] = new ParametroSQL(4, ((AtivoVO) o).getIdUsuario());
				r[4] = new ParametroSQL(5, ((AtivoVO) o).getNome());
				r[5] = new ParametroSQL(6, ((AtivoVO) o).getNumNota());
				r[6] = new ParametroSQL(7, ((AtivoVO) o).getPathImg());
				r[7] = new ParametroSQL(8, ((AtivoVO) o).getSetor());
				r[8] = new ParametroSQL(9, ((AtivoVO) o).getTipoGarantia());
				r[9] = new ParametroSQL(10, ((AtivoVO) o).getValidadeGarantia());
				r[10] = new ParametroSQL(11, ((AtivoVO) o).getVlrCompra());
				r[11] = new ParametroSQL(12, o.getId());
			}
		}
		return r;
	}

	@Override
	protected PadraoVO MontaVO(ResultSet rs) {
		/*
		 * ID, NOME, SETOR, VlrCompra, dtCOMPRA, numNota, tpGarantia, ValGARANTIA,
		 * DESCRICAO, ImgPath, IDCLASSIFI, IDUSUARIO
		 */
		AtivoVO ativo = new AtivoVO();
		try {
			ativo.setId(rs.getInt("ID"));
			ativo.setNome(rs.getString("NOME"));
			ativo.setSetor(rs.getString("SETOR"));
			ativo.setVlrCompra(rs.getDouble("VlrCompra"));
			ativo.setDataCompra(rs.getDate("dtCOMPRA"));
			ativo.setNumNota(rs.getInt("numNota"));
			ativo.setTipoGarantia(rs.getInt("tpGarantia"));
			ativo.setValidadeGarantia(rs.getDate("ValGARANTIA"));
			ativo.setDescricao(rs.getString("DESCRICAO"));
			ativo.setPathImg(rs.getString("ImgPath"));
			ativo.setIdClassific(rs.getInt("IDCLASSIFI"));
			ativo.setIdUsuario(rs.getInt("IDUSUARIO"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ativo;
	}

}
