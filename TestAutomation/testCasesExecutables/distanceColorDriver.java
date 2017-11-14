/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.io.*;
import java.lang.NullPointerException;
import org.opens.utils.distancecalculator.DistanceCalculator;
/**
 *
 * @author omer
 */
public class distanceColorDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    	int methodToTest=-1;
        String color1Values="";
        String color2Values="";
        double oracle = 0;
        String errOracle = "";
        if(args.length == 4)
    	{
    		color1Values = args[1];
    		color2Values = args[2];
    		oracle = Double.parseDouble(args[3]);
    	}
    	else if(args.length == 3)
    	{
    		color1Values = args[1];
    		errOracle = args[2];
    	}
    	else if(args.length == 2)
    	{
    		errOracle = args[1];
    	}
        Color color1;
        Color color2;
        if(color1Values != ""){
           	String[] color1Val = color1Values.split(",");
            color1 = new Color(Integer.parseInt(color1Val[0]), Integer.parseInt(color1Val[1]), Integer.parseInt(color1Val[2]));
        }
        else{
            color1 = null;
        }
        if(color2Values != ""){
            String[] color2Val = color2Values.split(",");
            color2 = new Color(Integer.parseInt(color2Val[0]), Integer.parseInt(color2Val[1]), Integer.parseInt(color2Val[2]));
        }
        else{
            color2 = null;
        }
        String passfail ="";
        double result = -1;
        try{
            result = DistanceCalculator.calculate(color1, color2);
            if(Double.compare(result, oracle) == 0){
                passfail = "true";
            }
            else{
                passfail = "false";
            }
        }
        catch(NullPointerException error){
            if(errOracle.compareToIgnoreCase("Error") == 0){
                passfail = "true";
            }
            else{
                passfail = "false";
            }
        }
		PrintWriter writer = new PrintWriter("./../temp/result.txt", "UTF-8");
		writer.println(passfail);
		writer.close();         
    }
    
}
