package testProJsp;

import java.sql.Connection;
import java.sql.ResultSet;

public class ActionClassForDepartmentDetails {

	public ResultSet onLoadingDeptName() {
		try {
			Connection con = new CommonConnection().getConnection();
			String insert = "SELECT DEPTNAME FROM DEPARTMENT ORDER BY DEPTNAME";
			ResultSet res = con.createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}
