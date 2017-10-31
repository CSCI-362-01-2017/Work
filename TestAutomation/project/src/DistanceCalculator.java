/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrastfinder;

import java.awt.Color;

/**
 *
 * @author omer
 */
public final class DistanceCalculator {

    private static final int CUBIC = 3;
    private static final int ROUND_VALUE = 100;
    
    private DistanceCalculator() {
    }


    public static double calculate(Color colorToChange, Color colorToKeep) {
        return (double) Math.round(Math.abs((Math.cbrt(Math.pow(Double.valueOf(colorToChange.getRed()) - Double.valueOf(colorToKeep.getRed()), CUBIC)
                + Math.pow(Double.valueOf(colorToChange.getGreen()) - Double.valueOf(colorToKeep.getGreen()), CUBIC)
                + Math.pow(Double.valueOf(colorToChange.getBlue()) - Double.valueOf(colorToKeep.getBlue()), CUBIC)))) * ROUND_VALUE) / ROUND_VALUE;
    }
}
