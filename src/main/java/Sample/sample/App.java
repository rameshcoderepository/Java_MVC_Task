package Sample.sample;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		DbResponse dbResponse = new DbResponse();

		List<PrimaryData> primaryResponse = dbResponse.getPrimaryResponse();
		List<SecondaryData> secondaryResponse = dbResponse.getSecondaryResponse();
		
		Map<String, PrimaryData> primaryMap = new HashMap<String, PrimaryData>();

		for (PrimaryData primary : primaryResponse) {
			primaryMap.put(primary.getMobileNumber(), primary);

		}

		for (SecondaryData secondary : secondaryResponse) {
			PrimaryData primarydata = primaryMap.get(secondary.getMobileNumber());
			System.out.println("Mobile" + " " + primarydata.getMobileNumber() + "Name" + " " + primarydata.getName()
					+ " " + "Address:" + secondary.getAddress());

			
		}

	}
}
