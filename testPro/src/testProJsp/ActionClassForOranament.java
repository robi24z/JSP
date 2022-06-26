package testProJsp;

import java.sql.Connection;
import java.sql.ResultSet;

public class ActionClassForOranament {
	public ResultSet onLoadingOrnamentName() {
		try {
			Connection con = new CommonConnection().getConnection();
			String insert = "SELECT ORNAMENTNAME FROM ORNAMENTS ORDER BY ORNAMENTNAME";
			// System.out.println(insert);
			ResultSet res = con.createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}
