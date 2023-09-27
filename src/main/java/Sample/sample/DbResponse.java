package Sample.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbResponse {

	// Register the driver class
	// Create the connection object
	// Create the Statement object
	// Execute the query
	// Close the connection object

	public List<PrimaryData> getPrimaryResponse() {
		List<PrimaryData> primaryList = new ArrayList<PrimaryData>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection coonne = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsdbatch", "root", "admin");
			Statement st = coonne.createStatement();
			ResultSet res = st.executeQuery("Select * from primarydata");

			while (res.next()) {

				PrimaryData primaryData = new PrimaryData();

				String name = res.getString("name");
				String moblile = res.getString("mobileNumber");

				primaryData.setMobileNumber(moblile);
				primaryData.setName(name);

				primaryList.add(primaryData);

			//	System.out.println(name + " " + moblile);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		return primaryList;

	}

	public List<SecondaryData> getSecondaryResponse() {
		List<SecondaryData> secondaryList = new ArrayList<SecondaryData>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection coonne = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsdbatch", "root", "admin");

			Statement st = coonne.createStatement();

			ResultSet res = st.executeQuery("Select * from secondarydata");
			while (res.next()) {
				SecondaryData secondaryData = new SecondaryData();
				String address = res.getString("address");
				String moblile = res.getString("mobileNumber");
				//System.out.println(address + " " + moblile);
				secondaryData.setAddress(address);
				secondaryData.setMobileNumber(moblile);

				secondaryList.add(secondaryData);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return secondaryList;
	}

}
