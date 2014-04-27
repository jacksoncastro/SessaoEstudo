package controller;

import helper.ConnectionHelper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logar")
public class Login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			ConnectionHelper connection = new ConnectionHelper();
			ResultSet rs = connection.execSQL("select * from alunos where nome like '?%'", new Object[]{"rog"});
			while (rs.next()) {
				System.out.println(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		RequestDispatcher rd = null;

		if (session != null) {
			rd = req.getRequestDispatcher("index.jsp");
		} else {
			session = req.getSession();
			rd = req.getRequestDispatcher("login.jsp");
		}
		rd.forward(req, resp);
		
		String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");

		session.setAttribute("nome", nome);
		session.setAttribute("senha", senha);

	}
}