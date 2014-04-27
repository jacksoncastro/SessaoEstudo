package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlunoModel;
import model.ReservasModel;
import dao.AlunoDao;
import dao.ReservasDao;


@SuppressWarnings("serial")
@WebServlet("/reservas")
public class Reservas extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		nome = (nome == null ? "" : nome);

		ReservasDao dao = new ReservasDao();
		req.setAttribute("reservas", dao.fetchLikeName(nome));

		RequestDispatcher rd = req.getRequestDispatcher("/reservas/index.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		nome = (nome == null ? "" : nome);

		ReservasDao dao = new ReservasDao();
		req.setAttribute("reservas", dao.fetchLikeName(nome));
		
		RequestDispatcher rd = req.getRequestDispatcher("/reservas/index.jsp");
		rd.forward(req, resp);
	}
	
	public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");

		ReservasDao dao = new ReservasDao();

		req.setAttribute("reservas", dao.fetchLikeName(nome));

		RequestDispatcher rd = req.getRequestDispatcher("/reservas/index.jsp");
		rd.forward(req, resp);
	}

	public void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String camarote = req.getParameter("camarote");
		int telefone = Integer.parseInt(req.getParameter("telefone"));
		String nome = req.getParameter("nome");
		
		ReservasModel model = new ReservasModel(camarote, nome, telefone);
		
		ReservasDao dao = new ReservasDao();
		dao.insert(model);
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
		
		ReservasModel model = new ReservasModel(id);
		ReservasDao dao = new ReservasDao();
		dao.delete(model);

		RequestDispatcher rd = req.getRequestDispatcher("/reservas");
		rd.forward(req, resp);
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