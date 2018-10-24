import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger a = new BigInteger(String.valueOf(2));
        BigInteger b = new BigInteger(String.valueOf(2));
        for (int i = 0; i <1000; i++) {
            a = a.multiply(b);
        }
        System.out.println(a);
    }
}
