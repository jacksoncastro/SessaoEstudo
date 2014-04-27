package dao;

import helper.ConnectionHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AlunoModel;

public class AlunoDao extends ConnectionHelper {
	public boolean insert(AlunoModel model) {
		return execUpdate("INSERT INTO aluno(matricula, nome) VALUES (?, ?);"
		   , new Object[]{model.getMatricula(), model.getNome()});
	}

	public boolean delete(AlunoModel model) {
		return execUpdate("DELETE FROM aluno WHERE id = ?;"
				, new Object[]{model.getId()});
	}

	public boolean update(AlunoModel model) {
		return execUpdate("UPDATE aluno set nome = ?, matricula = ? WHERE id = ?;"
				   , new Object[]{model.getNome(), model.getMatricula(), model.getId()});
	}

	public AlunoModel fetchOne(AlunoModel model) {
		ResultSet result = execSQL("SELECT id, matricula, nome FROM aluno WHERE id = ? LIMIT 1;", new Object[]{model.getId()});
		try {
			while(result.next()) {
				model.setMatricula(result.getInt("matricula"));
				model.setNome(result.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public ArrayList<AlunoModel> fetchLikeName(String nome) {
		ResultSet result = execSQL("SELECT id, matricula, nome FROM aluno WHERE (nome ~* ?) OR (matricula::text ~* ?) OR (id::text ~* ?)" , new Object[]{nome, nome, nome});
		ArrayList<AlunoModel> alunos = new ArrayList<AlunoModel>();
		try {
			while(result.next()) {
				AlunoModel aluno = new AlunoModel();
				aluno.setId(result.getInt("id"));
				aluno.setMatricula(result.getInt("matricula"));
				aluno.setNome(result.getString("nome"));
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}

	public ArrayList<AlunoModel> fetchAll() {
		ArrayList<AlunoModel> alunos = new ArrayList<AlunoModel>();
		ResultSet result = execSQL("SELECT id, matricula, nome FROM aluno ORDER BY 1;");
		try {
			while(result.next()) {
				AlunoModel aluno = new AlunoModel(result.getInt("id"), result.getString("nome"), result.getInt("matricula"));
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
}