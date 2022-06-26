package testProJsp;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletForDepartment")
public class ServletForDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletForDepartment() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	ResultSet ftable = onDisplaying();
		request.setAttribute("Display", ftable);
		RequestDispatcher reqd = request.getRequestDispatcher("departmentDetails.jsp");
		reqd.forward(request, response);
*/
		CommonConnection con = new CommonConnection();
		String button = request.getParameter("save");
		if ("Save".equals(button)) {

			String dname = request.getParameter("dname");

			String dtype = request.getParameter("dtype");

			String sname = request.getParameter("sname");

			try {
				int i = 0;
				int did = 0;
				String query1 = "SELECT DEPTID FROM DEPARTMENT WHERE DEPTNAME='" + dname + "'";
				ResultSet res = con.getConnection().createStatement().executeQuery(query1);
				if (res.next()) {
					did = res.getInt("DEPTID");

				}
				String query2 = "INSERT INTO CSDEPARTMENT VALUES('" + sname + "','" + dtype + "','" + did + "')";
				// System.out.println(query2);
				i = con.getConnection().createStatement().executeUpdate(query2);
				ResultSet table = onSave(dname, sname, dtype);
				request.setAttribute("Dept", table);
				RequestDispatcher rd = request.getRequestDispatcher("departmentDetails.jsp");
				rd.forward(request, response);
				System.out.println("==============Booked Successfully===============");

			} catch (Exception e) {

			}
		}
	}

	ResultSet onSave(String dname, String sname, String dtype) {

		try {
			CommonConnection con = new CommonConnection();
			String query = "SELECT CS1.SUBDEPARTMENT,CS1.DEPARTMENTTYPE,D1.DEPTNAME FROM CSDEPARTMENT CS1 INNER JOIN DEPARTMENT D1 ON D1.DEPTID=CS1.DEPARTMENTID WHERE D1.DEPTNAME='"
					+ dname + "'" + "AND CS1.SUBDEPARTMENT='" + sname + "'" + "AND CS1.DEPARTMENTTYPE='" + dtype + "'";
			ResultSet result = con.getConnection().createStatement().executeQuery(query);
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

/*	ResultSet onDisplaying() {
		try {
			CommonConnection con = new CommonConnection();
			String query = "SELECT CS.SUBDEPARTMENT,CS.DEPARTMENTTYPE,D.DEPTNAME FROM CSDEPARTMENT CS FULL OUTER JOIN DEPARTMENT D  ON CS.DEPARTMENTID=D.DEPTID";
			ResultSet result = con.getConnection().createStatement().executeQuery(query);
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}*/

}
