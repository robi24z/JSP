package testProJsp;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletForVehicleCustomer")
public class ServletForVehicleCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletForVehicleCustomer() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cusname = request.getParameter("cusname");
		// System.out.println("Customer Name : " + cusname);
		ResultSet table = onSelectingCustomerName(cusname);
		// System.out.println(table);
		request.setAttribute("CusDetails", table);
		RequestDispatcher rd = request.getRequestDispatcher("customerDetailsVehicle.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	ResultSet onSelectingCustomerName(String cusname) {
		try {
			CommonConnection con = new CommonConnection();
			String insert = "SELECT VC1.CUSTOMERNAME,VC1.CUSTOMEREMAIL,VC1.CUSTOMERADDRESS,VC1.CUSTOMERPHONE,VD1.VEHICLENAME,VD1.VEHICLEPRICE,VD1.SHOWROOM FROM VEHICLECUSTOMER VC1 INNER JOIN VEHICLEDEPARTMENT VD1 ON VC1.VEHICLEID=VD1.VEHICLEID WHERE CUSTOMERNAME='"
					+ cusname + "'";
			ResultSet res = con.getConnection().createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}
