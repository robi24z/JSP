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

@WebServlet("/ServletForFlight")
public class ServletForFlight extends HttpServlet {
	String fNameNext = "";
	private static final long serialVersionUID = 1L;

	public ServletForFlight() {

		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		fNameNext = request.getParameter("fvalue");
		String click = request.getParameter("button");
		if ("Book Flight".equals(click)) {
			try {

				String flightname = request.getParameter("flvalue");
				String flname = "";
				request.setAttribute("Flightname", flightname);
				RequestDispatcher req = request.getRequestDispatcher("customerDetailsFlight.jsp");
				req.forward(request, response);

			} catch (Exception e) {
				System.out.println(e);
			}

		} else {

			ResultSet res = onSelectingFlightName(fNameNext);
			request.setAttribute("FlightData", res);
			request.setAttribute("Flightname", fNameNext);
			RequestDispatcher rd = request.getRequestDispatcher("flightDetails.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sub = request.getParameter("buttonConfirm");
		String cname = request.getParameter("cname");
		String cemail = request.getParameter("cemail");
		String flightname = request.getParameter("f");
		if ("Confirm Booking".equals(sub)) {
			CommonConnection con = new CommonConnection();
			try {
				int fid = 0, i = 0;
				String query1 = "SELECT FLIGHTID FROM FLIGHT WHERE FLIGHTNAME='" + flightname + "'";
				ResultSet res = con.getConnection().createStatement().executeQuery(query1);
				if (res.next())
					fid = res.getInt("FLIGHTID");
				String query2 = "INSERT INTO FLIGHTCUSTOMER VALUES('" + cname + "','" + cemail + "','" + fid + "')";
				i = con.getConnection().createStatement().executeUpdate(query2);
				ResultSet details = flightBookingDetails(cname, cemail);
				request.setAttribute("Details", details);
				RequestDispatcher rd = request.getRequestDispatcher("bookingDetailsFlight.jsp");
				rd.forward(request, response);
				System.out.println("==============Booked Successfully===============");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	ResultSet onSelectingFlightName(String fname) {
		try {
			CommonConnection con = new CommonConnection();
			String insert = "SELECT F1.FLIGHTNAME,F1.ORIGIN,F1.DESTINATION,F1.TIME FROM FLIGHT F1 WHERE FLIGHTNAME='"
					+ fname + "'";
			ResultSet res = con.getConnection().createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	ResultSet flightBookingDetails(String cname, String cemail) {
		try {
			CommonConnection con = new CommonConnection();
			String query = "SELECT FC1.CUSTOMERNAME,FC1.CUSTOMEREMAIL,F1.FLIGHTNAME,F1.ORIGIN,F1.DESTINATION,F1.TIME FROM FLIGHTCUSTOMER FC1 INNER JOIN FLIGHT F1 ON FC1.FLIGHTID=F1.FLIGHTID WHERE FC1.CUSTOMERNAME='"
					+ cname + "'" + "AND FC1.CUSTOMEREMAIL='" + cemail + "'";
			ResultSet result = con.getConnection().createStatement().executeQuery(query);
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}
