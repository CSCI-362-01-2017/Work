import java.io.*;
import java.awt.Color;
import java.lang.NullPointerException;
import org.opens.utils.contrastchecker.ContrastChecker;

public class contrastCheckerDriver {

	public static void main(String[] args) throws IOException {
		boolean result = false;
		switch(args[0]){
			case "distanceColor": 
				result = testDistanceColor(args);
				break;
			case "isContrastValid": 
				result =testIContrastValid(args);
				break;
			case "getContrastRatio": 
				result = testgetContrastRatio(args);
				break;
			case "getConstrastRatio5DigitRound": 
				result = testGetContrastRatio5DigitRound(args);
				break;
			case "getLuminosity": 
				result = testGetLuminosity(args);
				break;
			case "getComposantValue": 
				result = testGetComposantValue(args);
				break;
			default: 
				badMethod();
				result = false;
				break;
		}
		PrintWriter writer = new PrintWriter("./../temp/result.txt", "UTF-8");
		writer.println(result);
		writer.close();   

	}

	private static boolean testDistanceColor(String[] args){
		boolean rtn;
		Color fgColor;
		Color bgColor;
		double oracle = 0;
		String errOracle = "";
		if(args.length == 4){
			String[] fgArgs = args[1].split(",");
			String[] bgArgs = args[2].split(",");
			fgColor = new Color(Integer.parseInt(fgArgs[0]),Integer.parseInt(fgArgs[1]),Integer.parseInt(fgArgs[2]));
			bgColor = new Color(Integer.parseInt(bgArgs[0]),Integer.parseInt(bgArgs[1]),Integer.parseInt(bgArgs[2]));
			oracle = Double.parseDouble(args[3]);
		}
		else if(args.length == 3){
			String[] fgArgs = args[1].split(",");
			fgColor = new Color(Integer.parseInt(fgArgs[0]),Integer.parseInt(fgArgs[1]),Integer.parseInt(fgArgs[2]));
			bgColor = null;
			errOracle = args[2];
		}
		else{
			fgColor = null;
			bgColor = null;
			errOracle = args[1];
		}
		try{
            Double result = ContrastChecker.distanceColor(fgColor,bgColor);
            if(Double.compare(result, oracle) == 0){
                rtn = true;
            }
            else{
                rtn = false;
            }
        }
        catch(NullPointerException error){
            if(errOracle.compareToIgnoreCase("Error") == 0){
                rtn = true;
            }
            else{
                rtn = false;
            }
        }
		return rtn;
	}

	private static boolean testIContrastValid(String[] args){
		boolean rtn;
		rtn = false;
		return rtn;		
	}

	private static boolean testgetContrastRatio(String[] args){
		boolean rtn;
		rtn = false;
		return rtn;		
	}

	private static boolean testGetContrastRatio5DigitRound(String[] args){
		boolean rtn;
		rtn = false;
		return rtn;		
	}

	private static boolean testGetLuminosity(String[] args){
		boolean rtn;
		Color color;
		double oracle = -1;
		String errOracle = "";
		if(args.length == 3){
			String[] colorArgs = args[1].split(",");
			color = new Color(Integer.parseInt(colorArgs[0]),Integer.parseInt(colorArgs[1]),Integer.parseInt(colorArgs[2]));
			oracle = Double.parseDouble(args[2]);
		}
		else{
			color = null;
			errOracle = args[1];
		}
		try{
            Double result = ContrastChecker.getLuminosity(color);
            if(Double.compare(result, oracle) == 0){
                rtn = true;
            }
            else{
                rtn = false;
            }
        }
        catch(NullPointerException error){
            if(errOracle.compareToIgnoreCase("Error") == 0){
                rtn = true;
            }
            else{
                rtn = false;
            }
        }
		return rtn;
	}

	private static boolean testGetComposantValue(String[] args){
		boolean rtn;
		rtn = false;
		return rtn;		
	}

	private static void badMethod(){

	}
}