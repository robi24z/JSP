package testProJsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExampleServlet")
public class ExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExampleServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		String value = request.getParameter("name");
		String combo = request.getParameter("val");
		System.out.println("Textfield : " + value);
		System.out.println("Combo : " + combo);
	}

}