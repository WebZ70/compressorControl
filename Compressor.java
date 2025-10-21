import java.text.DecimalFormat;
import java.util.ArrayList;


public class Compressor {
    public class ChamberCompressorOne {

        double temperatureInit;
        double pressureInit;
        double pressureFinal;
        double deltaPressure;

        public ChamberCompressorOne(double temperatureInit, double pressureInit, double pressureFinal){
            this.temperatureInit = temperatureInit;
            this.pressureInit = pressureInit;
            this.pressureFinal = pressureFinal;
            this.deltaPressure = (pressureFinal - pressureInit) / 10.0;
        }

        private void splitValuePressure(){
            ArrayList<Double> pressure = new ArrayList<>();
            double delta = Math.abs(this.pressureFinal - this.pressureInit);
            double step = delta/10.0;

        }

        public void pressure(){
//            double[] parts = new double[10];
//            Double<double> parts = new ArrayList<>();
            for(double currPressure = this.pressureInit; currPressure <= this.pressureFinal; currPressure += this.deltaPressure){
                double t = this.temperatureInit * currPressure / this.pressureInit;
                System.out.println("Tk = " + new DecimalFormat("#.00").format(t) + " K");
            }

        }
        
    }
}
