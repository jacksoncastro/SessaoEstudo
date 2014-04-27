package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings({"serial", "unchecked"})
@WebServlet("/testeSessao")
public class Sessao extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String var = req.getParameter("var");

		ArrayList<String> carrinho = null;
		HttpSession session = req.getSession(false);
		
		if (session == null) {
			session = req.getSession();
		}

		if (session.isNew()) {
			carrinho = new ArrayList<String>();
		}  else {
			carrinho = (ArrayList<String>) session.getAttribute("carrinho");
		}
		
		if (var != null && carrinho != null) {
			carrinho.add(var);
		}

		session.setAttribute("carrinho", carrinho);
		for(String item : carrinho) {
			out.println("Item: "+ item + "<br/>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}