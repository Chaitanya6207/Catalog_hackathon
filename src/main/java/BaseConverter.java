import java.math.BigInteger;

public class BaseConverter {

    public static BigInteger decodeYValue(String value, String base) {
        return new BigInteger(value, Integer.parseInt(base));
    }
}

