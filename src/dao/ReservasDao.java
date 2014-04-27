package dao;

import helper.ConnectionHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ReservasModel;

public class ReservasDao extends ConnectionHelper {
	public boolean insert(ReservasModel model) {
		return execUpdate("INSERT INTO reservas (reservas, nome, telefone) VALUES (?, ?, ?);"
		   , new Object[]{model.getBalada(), model.getNome(), model.getTelefone()});
	}

	public boolean delete(ReservasModel model) {
		return execUpdate("DELETE FROM reservas WHERE id = ?;"
				, new Object[]{model.getId()});
	}
//
//	public boolean update(ReservasModel model) {
//		return execUpdate("UPDATE reservas set camarote = ?, nome = ?, matricula = ? WHERE id = ?;"
//				   , new Object[]{model.getNome(), model.getMatricula(), model.getId()});
//	}
//
//	public reservasModel fetchOne(reservasModel model) {
//		ResultSet result = execSQL("SELECT id, matricula, nome FROM reservas WHERE id = ? LIMIT 1;", new Object[]{model.getId()});
//		try {
//			while(result.next()) {
//				model.setMatricula(result.getInt("matricula"));
//				model.setNome(result.getString("nome"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return model;
//	}
//
	public ArrayList<ReservasModel> fetchLikeName(String nome) {
		ResultSet result = execSQL("SELECT id, balada, nome, telefone FROM reservas WHERE (balada ~* ?) OR (nome::text ~* ?) OR (id::text ~* ?) OR(telefone::text ~* ?)" 
								, new Object[]{nome, nome, nome, nome});
		ArrayList<ReservasModel> reservass = new ArrayList<ReservasModel>();
		try {
			while(result.next()) {
				
				ReservasModel reservas = new ReservasModel();
				reservas.setId(result.getInt("id"));
				reservas.setBalada(result.getString("balada"));
				reservas.setNome(result.getString("nome"));
				reservas.setTelefone(result.getInt("telefone"));
				reservass.add(reservas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservass;
	}
//
//	public ArrayList<reservasModel> fetchAll() {
//		ArrayList<reservasModel> reservass = new ArrayList<reservasModel>();
//		ResultSet result = execSQL("SELECT id, matricula, nome FROM reservas ORDER BY 1;");
//		try {
//			while(result.next()) {
//				reservasModel reservas = new reservasModel(result.getInt("id"), result.getString("nome"), result.getInt("matricula"));
//				reservass.add(reservas);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return reservass;
//	}
}