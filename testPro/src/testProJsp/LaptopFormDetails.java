package testProJsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LaptopFormDetails")
public class LaptopFormDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LaptopFormDetails() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cname = request.getParameter("cvalue");
		ResultSet res = onSelectingCustomerName(cname);
		request.setAttribute("CustomerData", res);
		RequestDispatcher rd = request.getRequestDispatcher("customerDetails.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cname = request.getParameter("cname");
		String email = request.getParameter("email");
		String lapname = request.getParameter("lname");
		CommonConnection con = new CommonConnection();
		String sub = request.getParameter("button");
		if ("Book".equals(sub)) {
			try {
				int lid = 0, i = 0;
				String lname = request.getParameter("cvalue");
				String query1 = "SELECT LAPTOPID FROM LAPTOP WHERE LAPTOPNAME='" + lname + "'";
				ResultSet res = con.getConnection().createStatement().executeQuery(query1);
				if (res.next()) {
					lid = res.getInt("LAPTOPID");
				}
				String query2 = "INSERT INTO CUSTOMERDETAILS VALUES('" + cname + "','" + email + "','" + lid + "')";
				i = con.getConnection().createStatement().executeUpdate(query2);
				response.sendRedirect("customerDetails.jsp");
				System.out.println("==============Booked Successfully===============");
			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			try {

				PreparedStatement state = con.getConnection()
						.prepareStatement("select PRICE from LAPTOP where LAPTOPNAME='" + lapname + "'");
				String lprice = "";
				ResultSet lapprice = state.executeQuery();
				if (lapprice.next()) {
					lprice = lapprice.getString("PRICE");
				}
				response.getWriter().append(lprice + "");

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	ResultSet onSelectingCustomerName(String cname) {
		try {
			String insert = "SELECT CD1.CUSTOMERNAME,CD1.CUSTOMEREMAIL,L1.LAPTOPNAME,L1.PRICE,C1.COMPANYNAME FROM CUSTOMERDETAILS CD1 INNER JOIN LAPTOP L1 ON CD1.LAPTOPID=L1.LAPTOPID INNER JOIN  COMPANY  C1 ON L1.COMPANYID=C1.COMPANYID WHERE CUSTOMERNAME='"
					+ cname + "'";
			ResultSet res = new CommonConnection().getConnection().createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}
