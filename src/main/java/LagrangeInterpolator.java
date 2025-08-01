import java.math.BigInteger;
import java.util.Map;

public class LagrangeInterpolator {

    public static BigInteger interpolate(Map<BigInteger, BigInteger> points, BigInteger modulus) {
        BigInteger sum = BigInteger.ZERO;

        for (Map.Entry<BigInteger, BigInteger> jPoint : points.entrySet()) {
            BigInteger xj = jPoint.getKey();
            BigInteger yj = jPoint.getValue();

            BigInteger product = BigInteger.ONE;

            for (Map.Entry<BigInteger, BigInteger> mPoint : points.entrySet()) {
                BigInteger xm = mPoint.getKey();

                if (!xj.equals(xm)) {
                    BigInteger numerator = BigInteger.ZERO.subtract(xm);
                    BigInteger denominator = xj.subtract(xm);
                    
                    // Handle potential negative denominators by adding modulus
                    BigInteger invDenominator = denominator.modInverse(modulus);
                    product = product.multiply(numerator).multiply(invDenominator).mod(modulus);
                }
            }
            sum = sum.add(yj.multiply(product)).mod(modulus);
        }
        return sum;
    }
}

