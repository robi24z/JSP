package testProJsp;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletForOrnament")
public class ServletForOrnament extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletForOrnament() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String oname = request.getParameter("name");
			// System.out.println("Name : " + oname);
			CommonConnection con = new CommonConnection();
			PreparedStatement state = con.getConnection()
					.prepareStatement("select PRICE from ORNAMENTS where ORNAMENTNAME='" + oname + "'");
			int oprice = 0;
			ResultSet orprice = state.executeQuery();
			if (orprice.next()) {
				oprice = orprice.getInt("PRICE");
			}
			response.getWriter().append(oprice + "");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sub = request.getParameter("button");
		// System.out.println(sub);
		if ("View Details".equals(sub)) {
			String oname = request.getParameter("oname");
			// System.out.println("Customer Name : " + oname);
			ResultSet table = onView(oname);
			// System.out.println(table);
			request.setAttribute("Ornament", table);
			RequestDispatcher rd = request.getRequestDispatcher("ornamentDetails.jsp");
			rd.forward(request, response);
		}

	}

	ResultSet onView(String oname) {
		try {
			int oid = 0, i = 0;
			CommonConnection con = new CommonConnection();
			String query1 = "SELECT ORNAMENTID FROM ORNAMENTS WHERE ORNAMENTNAME='" + oname + "'";
			ResultSet res = con.getConnection().createStatement().executeQuery(query1);
			if (res.next())
				oid = res.getInt("ORNAMENTID");
			String insert = "SELECT ORNAMENTNAME,PRICE,GST,DISCOUNT FROM ORNAMENTS WHERE ORNAMENTID='" + oid + "'";
			ResultSet result = con.getConnection().createStatement().executeQuery(insert);
			return result;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}
