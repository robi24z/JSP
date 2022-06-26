package testProJsp;

import java.sql.Connection;
import java.sql.ResultSet;

public class ActionClassForVehicle {

	public ResultSet onLoadingVehicleName() {
		try {
			Connection con = new CommonConnection().getConnection();
			String insert = "SELECT VEHICLENAME FROM VEHICLEDEPARTMENT ORDER BY VEHICLENAME";
			ResultSet res = con.createStatement().executeQuery(insert);
			return res;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}
