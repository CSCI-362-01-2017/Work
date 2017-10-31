/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrastfinder;
import static contrastfinder.DistanceCalculator.calculate;
import java.awt.Color;
/**
 *
 * @author omer
 */
public class distanceColorDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	if(args.length == 3)
    	{
    		String color1Values = args[0];
    		String color2Values = args[1];
    		double oracle = args[2];
    	}
    	else if(args.length == 2)
    	{
    		String color1Values = args[0];
    		double oracle = args[1];
    	}
    	else if(args.length == 1)
    	{
    		double oracle = args[0];
    	}
    	String[] color1Val = split(color1Values,',');
    	String[] color2Vals = split(color2Values,',');
        Color color1 = new Color(color1Val[0], color1Val[1], color1Val[2]);
        Color color2 = new Color(color2Val[0], color2Val[1], color2Val[2]);
        double result = calculate(color1, color2));
		if(result == oracle)
		{
			String passfail = "true"
		}
		else
		{
			String passfail = "false"
		}
		PrintWriter writer = new PrintWriter("./../temp/result.txt", "UTF-8");
		writer.println(passfail);
		writer.close();
         
    }
    
}
