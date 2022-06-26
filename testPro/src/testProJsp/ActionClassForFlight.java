package testProJsp;

import java.sql.Connection;
import java.sql.ResultSet;

public class ActionClassForFlight {
	public ResultSet onLoadingFlightName() {
		try {
			Connection con = new CommonConnection().getConnection();
			String insert = "SELECT FLIGHTNAME FROM FLIGHT ORDER BY FLIGHTNAME";
			ResultSet res = con.createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}
