package org.omgtu;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class Compressor {
    public static class ChamberCompressorOne {

        double temperatureInit;
        double pressureInit;
        double pressureFinal;
        double deltaPressure;
        double step;

        public ChamberCompressorOne(double temperatureInit, double pressureInit, double pressureFinal, double step){
            this.temperatureInit = temperatureInit;
            this.pressureInit = pressureInit;
            this.pressureFinal = pressureFinal;
            this.step = step;
            this.deltaPressure = (pressureFinal - pressureInit) / 10.0;
        }

        private ArrayList<Double> splitValuePressure(){
            ArrayList<Double> pressure = new ArrayList<>();
            double delta = Math.abs(this.pressureFinal - this.pressureInit);
            double step = delta / this.step;
            double temp = this.pressureInit;

            if (this.pressureFinal > this.pressureInit){
                step *= 1;
            } else {
                step *= -1;
            }

            for (int i = 0; i < this.step + 1; i++){
                pressure.add(temp);
                temp += step;
            }

            return pressure;
        }

        private double changeTemperature(double currPressure){
            return this.temperatureInit * currPressure / this.pressureInit;
        }

        public void pressure(){
            ArrayList<Double> pressureSplit = new ArrayList<>();
            pressureSplit = splitValuePressure();
            for (double currPressure : pressureSplit){
                double t = changeTemperature(currPressure);
                System.out.println("P = " + new DecimalFormat("#.00").format(currPressure) + " Pa; " + "Tk = " + new DecimalFormat("#.00").format(t) + " K");
            }

        }

    }
}
