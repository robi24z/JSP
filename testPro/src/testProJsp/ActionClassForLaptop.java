package testProJsp;

import java.sql.Connection;
import java.sql.ResultSet;

public class ActionClassForLaptop {

	public ResultSet onLoadingLaptopName() {
		try {
			Connection con = new CommonConnection().getConnection();
			String insert = "SELECT LAPTOPNAME FROM LAPTOP ORDER BY LAPTOPNAME";
			ResultSet res = con.createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}
