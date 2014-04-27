package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlunoModel;
import dao.AlunoDao;

public class Aluno {
	public void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int matricula = Integer.parseInt(req.getParameter("matricula"));
		String aluno = req.getParameter("nome");
		
		AlunoModel model = new AlunoModel(aluno, matricula);
		AlunoDao dao = new AlunoDao();
		dao.insert(model);
		
		listar(req, resp);
	}

	private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlunoDao dao = new AlunoDao();
		ArrayList<AlunoModel> alunos = dao.fetchAll();
		req.setAttribute("alunos", alunos);

		RequestDispatcher rd = req.getRequestDispatcher("aluno/listarAlunos.jsp");
		rd.forward(req, resp);
	}

	public void deletar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		AlunoModel model = new AlunoModel(id);
		AlunoDao dao = new AlunoDao();
		dao.delete(model);
		
		listar(req, resp);
	}

	public void atualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int matricula = Integer.parseInt(req.getParameter("matricula"));
		String nome = req.getParameter("nome");

		AlunoModel model = new AlunoModel(id, nome, matricula);
		AlunoDao dao = new AlunoDao();
		dao.update(model);

		listar(req, resp);
	}

	public void listarAluno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");

		AlunoDao dao = new AlunoDao();
		ArrayList<AlunoModel> alunos = dao.fetchLikeName(nome);


		req.setAttribute("alunos", alunos);
		RequestDispatcher rd = req.getRequestDispatcher("aluno/listarAlunos.jsp");
		rd.forward(req, resp);
	}
	
	public void listarAlunos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlunoDao dao = new AlunoDao();
		ArrayList<AlunoModel> alunos = dao.fetchAll();
		req.setAttribute("alunos", alunos);
		RequestDispatcher rd = req.getRequestDispatcher("listarAlunos.jsp");
		rd.forward(req, resp);
	}
}