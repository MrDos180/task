package task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class task3 {

	public static void main(String[] args) {
				
			for (int i = 0; i < 5; i++) { 
				List<String> lines = new ArrayList();
				ArrayList<Float> listHalfHour = new ArrayList<Float>(16);
				StringBuilder path = new StringBuilder();
				String filesName = "Cash" + String.valueOf(i + 1) + ".txt";
				path.append(args[0] +"\\" + filesName);

				
				try {
					lines = Files.readAllLines(Paths.get(path.toString()));
				} catch (IOException e) {
					e.printStackTrace();
				}

				for (int j = 0; j < lines.size(); j++) {	
					listHalfHour.add(Float.parseFloat(lines.get(j)));
				}
				
				float max = listHalfHour.get(0);
				int maxN = 0;
				
				for (int j = 0; j < listHalfHour.size(); j++) {
					if (listHalfHour.get(j) > max) {
						max = listHalfHour.get(j);
						maxN = j + 1;
					}	
				}
				
				System.out.println(maxN);
			}	
	}		
}
