package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/frontHelper")
public class FrontHttpServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirect(req.getParameter("servlet"), req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirect(req.getParameter("servlet"), req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirect(req.getParameter("servlet"), req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirect(req.getParameter("servlet"), req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirect(req.getParameter("servlet"), req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirect(req.getParameter("servlet"), req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirect(req.getParameter("servlet"), req, resp);
	}

	/**
	 * @author Jackson Castro
	 * @since 2014-04-06
	 * 
	 * @param servlet
	 * @param request
	 * @param response
	 * 
	 * Responsavel por redirect para controller
	 */
	private void redirect(String servlet, HttpServletRequest request, HttpServletResponse response) {
		String[] split = servlet.trim().split("\\/");
		if(split[1].isEmpty()) {
			throw new NullPointerException("Redirect inválido");
		}

		String controller = split[0];
		String method = split[1];

		try {
			Class<?> classe = Class.forName("controller." + controller);
			Method instanceMethod = classe.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			instanceMethod.invoke(classe.newInstance(), new Object[]{request, response});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}