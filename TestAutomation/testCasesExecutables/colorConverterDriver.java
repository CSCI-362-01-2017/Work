
import java.awt.Color;
import java.io.*;
import org.opens.utils.colorconvertor.ColorConverter;

public class colorConverterDriver{
	
	public static void main(String[] args) throws IOException{
		boolean result = false;
		switch(args[0]){
			case "offsetHsbColor": 
				result = testOffsetHsbColor(args);
				break;
			case "getSaturation":
				result = testGetSaturation(args);
				break;
			case "getBrightness": 
				result =testGetBrightness(args);
				break;
			case "getHue": 
				result = testGetHue(args);
				break;
			case "offsetRgbColor": 
				result = testOffsetRgbColor(args);
				break;
			case "rgb2Hsl": 
				result = testRgb2Hsl(args);
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

	public static boolean testOffsetHsbColor(String[] args){
		boolean rtn;
		rtn = false;
		return rtn;
	}

	public static boolean testGetSaturation(String[] args){
		boolean rtn;
		Color color;
		float oracle = -1;
		String errOracle = "";
		if(args.length == 3){
			String[] colorArgs = args[1].split(",");
			color = new Color(Integer.parseInt(colorArgs[0]),Integer.parseInt(colorArgs[1]),Integer.parseInt(colorArgs[2]));
			oracle = Float.parseFloat(args[2]);
		}
		else{
			color = null;
			errOracle = args[1];
		}
		try{
            Float result = ColorConverter.getSaturation(color);
            System.out.println(result);
            if(Float.compare(result, oracle) == 0){
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

	public static boolean testGetBrightness(String[] args){
		boolean rtn;
		Color color;
		float oracle = -1;
		String errOracle = "";
		if(args.length == 3){
			String[] colorArgs = args[1].split(",");
			color = new Color(Integer.parseInt(colorArgs[0]),Integer.parseInt(colorArgs[1]),Integer.parseInt(colorArgs[2]));
			oracle = Float.parseFloat(args[2]);
		}
		else{
			color = null;
			errOracle = args[1];
		}
		try{
            Float result = ColorConverter.getBrightness(color);
            if(Float.compare(result, oracle) == 0){
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
	
	public static boolean testGetHue(String[] args){
		boolean rtn;
		Color color;
		float oracle = -1;
		String errOracle = "";
		if(args.length == 3){
			String[] colorArgs = args[1].split(",");
			color = new Color(Integer.parseInt(colorArgs[0]),Integer.parseInt(colorArgs[1]),Integer.parseInt(colorArgs[2]));
			oracle = Float.parseFloat(args[2]);
		}
		else{
			color = null;
			errOracle = args[1];
		}
		try{
            Float result = ColorConverter.getHue(color);
            System.out.println(result);
            if(Float.compare(result, oracle) == 0){
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

	public static boolean testOffsetRgbColor(String[] args){
		boolean rtn;
		rtn = false;
		return rtn;
	}

	public static boolean testRgb2Hsl(String[] args){
		boolean rtn;
		rtn = false;
		return rtn;
	}

	public static void badMethod(){

	}
}