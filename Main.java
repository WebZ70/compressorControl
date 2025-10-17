import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        PrintStream out = System.out;
        out.print("Enter initial T0(K) = ");
        double temp0 = inputProgramm();
        out.print("Enter initial P0(Pa) = ");
        double press0 = inputProgramm();
        out.print("Enter final Pk(Pa) = ");
        double pressF = inputProgramm();
        Compressor compressor = new Compressor();
        Compressor.ChamberCompressorOne chamberOne = compressor.new ChamberCompressorOne(temp0, press0, pressF);

        double different = (pressF - press0) / 10.0;

        for(double temp = press0; temp <= pressF; temp += different){
            out.println("Tk = " + chamberOne.currentMoment(temp0, press0, temp) + " K");
        }

        for(double temp = press0; temp >= pressF; temp += different){
            out.println("Tk = " + chamberOne.currentMoment(temp0, press0, temp) + " K");
        }
        
         
    }

    public static double inputProgramm(){
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String string = bufferedReader.readLine();
            return Double.parseDouble(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
