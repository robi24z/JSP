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

@WebServlet("/ServletForVehicle")
public class ServletForVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletForVehicle() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommonConnection con = new CommonConnection();
		try {
			String vname = request.getParameter("vname");
			PreparedStatement state = con.getConnection()
					.prepareStatement("select VEHICLEPRICE from VEHICLEDEPARTMENT where VEHICLENAME='" + vname + "'");
			int vprice = 0;
			ResultSet vehprice = state.executeQuery();
			if (vehprice.next()) {
				vprice = vehprice.getInt("VEHICLEPRICE");
			}
			response.getWriter().append(vprice + "");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommonConnection con = new CommonConnection();
		String cname = request.getParameter("cname");

		String sub = request.getParameter("b1");
		if ("Book".equals(sub)) {
			String cemail = request.getParameter("cemail");
			String caddress = request.getParameter("caddress");
			String cphone = request.getParameter("cphone");
			String vname = request.getParameter("vvalue");
			try {
				int vehid = 0, i = 0;
				String query1 = "SELECT VEHICLEID FROM VEHICLEDEPARTMENT WHERE VEHICLENAME='" + vname + "'";
				ResultSet res = con.getConnection().createStatement().executeQuery(query1);
				if (res.next()) {
					vehid = res.getInt("VEHICLEID");

				}
				String query2 = "INSERT INTO VEHICLECUSTOMER VALUES('" + cname + "','" + cemail + "','" + caddress
						+ "','" + cphone + "','" + vehid + "')";
				i = con.getConnection().createStatement().executeUpdate(query2);
				System.out.println("================Vehicle Booked Successfully===============");
				response.sendRedirect("vehicleDetails.jsp");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			String sub1 = request.getParameter("b2");
			if ("Show Customer".equals(sub1)) {
				response.sendRedirect("customerDetailsVehicle.jsp");
				/*RequestDispatcher rd = request.getRequestDispatcher("customerDetailsVehicle.jsp");
				rd.forward(request, response);*/
			}
		}
	}

}
