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
        Color color1 = new Color(10, 200, 10);
        Color color2 = new Color(10, 200, 100);
        System.out.print(calculate(color1, color2));
        
          
    }
    
}
