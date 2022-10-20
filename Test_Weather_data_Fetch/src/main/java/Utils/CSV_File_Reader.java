package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CSV_File_Reader {

	String[] cities;
	String city;

	public static String[] city() throws IOException {
		File file = new File(
				"C:\\Users\\spati\\eclipse-workspace\\PractiseTest\\src\\main\\resources\\TestData\\test.csv");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String[] cities = br.readLine().split(",");

		br.close();
		return cities;

	}

}
