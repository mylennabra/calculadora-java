import java.text.DecimalFormat;

public class Calculadora {
    
    public double potencia (int num, int pow){
        return Math.pow(num,pow);
    }

    public int multPot (int num, int pow, int pow2){
        return pow+pow2;
    }

    public int divPot (int num, int pow, int pow2){
        return pow-pow2;
    }



}