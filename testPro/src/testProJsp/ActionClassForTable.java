package testProJsp;

import java.sql.Connection;
import java.sql.ResultSet;

public class ActionClassForTable {
	public ResultSet onSelectingCustomerName(String cname) {
		try {
			Connection con = new CommonConnection().getConnection();
			String insert = "SELECT CD1.CUSTOMERNAME,CD1.CUSTOMEREMAIL,L1.LAPTOPNAME,L1.PRICE,C1.COMPANYNAME FROM CUSTOMERDETAILS CD1 INNER JOIN LAPTOP L1 ON CD1.LAPTOPID=L1.LAPTOPID INNER JOIN  COMPANY  C1 ON L1.COMPANYID=C1.COMPANYID WHERE CUSTOMERNAME='"
					+ cname + "'";
			ResultSet res = con.createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}
