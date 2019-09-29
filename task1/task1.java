
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class task1 {
	public static void main(String[] args) {

			StringBuilder path = new StringBuilder();
			path.append(new File("").getAbsolutePath());
			path.append("\\" + args[0]);
			ArrayList<Integer> nums = new ArrayList<Integer>();
			List<String> lines = new ArrayList();
			try {
				lines = Files.readAllLines(Paths.get(path.toString()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			for (String l : lines) nums.add(Integer.parseInt(l));
			Locale.setDefault(Locale.US);
			
			System.out.printf("%.02f%n",Percentile(90, nums));
			
			System.out.printf("%.02f%n",Percentile(50, nums));
			
			System.out.printf("%.02f%n",Percentile(100, nums));
			
			System.out.printf("%.02f%n",Percentile(0, nums));
	
			System.out.printf("%.02f%n",Average(nums));	
	}
	
	private static double Percentile(double percNum, ArrayList<Integer> nums)
	{

		if (percNum < 0 || percNum>100) {
			System.out.println("Percentiles value is out of boundary");
			System.exit(0);
		}

		Collections.sort(nums);
	
		if (nums.size() == 1) return nums.get(0);

		double interval = 1.0 / (nums.size() - 1); 
														
		int leftBoundInd = (int)((percNum / 100.0) / interval); 
		
		int rightBoundInd;
		
		if (leftBoundInd == nums.size() - 1) rightBoundInd = leftBoundInd; 
		else rightBoundInd = leftBoundInd + 1; 
		
		double percentile = ((((percNum / 100.0) - interval * leftBoundInd) / interval)) * (nums.get(rightBoundInd) - nums.get(leftBoundInd)) + nums.get(leftBoundInd);

		return (Math.rint(percentile*100))/100;
	}
	
	private static double Average(ArrayList<Integer> nums) {
		double average = 0;

		for (int i = 0; i < nums.size(); i++) {
			average += nums.get(i);
		}
		
		average /= nums.size();

		return (Math.rint(average*100))/100 ;
	}
}
