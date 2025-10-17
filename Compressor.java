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

        public double currentMoment(double temperatureInit, double pressureInit, double pressureDifferent){
            try {
                return temperatureInit * pressureDifferent / pressureInit;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
            
        }
        
      
        
    }
}
