import java.text.DecimalFormat;
import java.util.ArrayList;


public class Compressor {
    public class ChamberCompressorOne {

        double temperatureInit;
        double pressureInit;
        double pressureFinal;

        public ChamberCompressorOne(double temperatureInit, double pressureInit, double pressureFinal){
            this.temperatureInit = temperatureInit;
            this.pressureInit = pressureInit;
            this.pressureFinal = pressureFinal;
        }

        public double currentMoment(double temperatureInit, double pressureInit, double pressureFinal){
            try {
//                return temperatureInit * pressureFinal / pressureInit;
                double delta = deltaPressure(pressureInit, pressureFinal);
                if (delta > 0){
                    upPressure(temperatureInit, pressureInit, pressureFinal, delta);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
            
        }

        public double deltaPressure(double pressureInit, double pressureFinal){
            return (pressureFinal - pressureInit) / 10.0;
        }
        
        public void upPressure(double temperatureInit, double pressureInit, double pressureFinal, double delta){
//            double[] parts = new double[10];
//            Double<double> parts = new ArrayList<>();
            for(double tempPressure = pressureInit; tempPressure <= pressureFinal; tempPressure += delta){
                double t = temperatureInit * tempPressure / pressureInit;
                System.out.println("Tk = " + new DecimalFormat("#.00").format(t) + " K");
            }

        }

        public void downPressure(){

        }
        
    }
}
