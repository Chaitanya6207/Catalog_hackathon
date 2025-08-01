import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PolynomialSolver {

    public static void main(String[] args) {
        try {
            // Parse the JSON input file
            InputData inputData = InputJsonParser.parseJsonFile("input.json");
            
            System.out.println("Parsed input data: " + inputData);
            
            // Extract keys
            Keys keys = inputData.getKeys();
            int n = keys.getN();
            int k = keys.getK();
            
            System.out.println("n = " + n + ", k = " + k);
            
            // Decode Y values and create points for interpolation
            Map<BigInteger, BigInteger> points = new HashMap<>();
            
            for (Map.Entry<String, Root> entry : inputData.getRoots().entrySet()) {
                String xStr = entry.getKey();
                Root root = entry.getValue();
                
                BigInteger x = new BigInteger(xStr);
                BigInteger y = BaseConverter.decodeYValue(root.getValue(), root.getBase());
                
                points.put(x, y);
                
                System.out.println("Point: x = " + x + ", y = " + y + " (decoded from base " + root.getBase() + " value " + root.getValue() + ")");
            }
            
            // Use a large prime modulus for calculations
            BigInteger modulus = new BigInteger("2").pow(256).subtract(BigInteger.valueOf(189));
            
            // Calculate the secret (constant term) using Lagrange interpolation
            BigInteger secret = LagrangeInterpolator.interpolate(points, modulus);
            
            System.out.println("The secret (constant term) is: " + secret);
            
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

