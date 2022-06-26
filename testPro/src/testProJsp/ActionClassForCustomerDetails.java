package testProJsp;

import java.sql.Connection;
import java.sql.ResultSet;

public class ActionClassForCustomerDetails {
	public ResultSet onLoadingCustomerName() {
		try {
			Connection con = new CommonConnection().getConnection();
			String insert = "SELECT CUSTOMERNAME FROM CUSTOMERDETAILS ORDER BY CUSTOMERNAME";
			ResultSet res = con.createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}
