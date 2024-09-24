import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Currencyconverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    static {

        // Define exchange rates (1 unit of the base currency)
        exchangeRates.put("USD", 1.0); // Base currency: USD
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available currencies: USD, EUR, JPY, GBP");

        // Get the amount to convert
        System.out.print("Enter amount in USD: ");
        double amount = scanner.nextDouble();
         // Get target currency
         System.out.print("Enter target currency (EUR, JPY, GBP): ");
         String targetCurrency = scanner.next().toUpperCase();
 
         // Perform conversion
         if (exchangeRates.containsKey(targetCurrency)) {
             double convertedAmount = convertCurrency(amount, targetCurrency);
             System.out.printf("%.2f USD is equal to %.2f %s%n", amount, convertedAmount, targetCurrency);
            } else {
                System.out.println("Invalid currency entered.");
            }
    
            scanner.close();
        }
    
        private static double convertCurrency(double amount, String targetCurrency) {
            double usdToTargetRate = exchangeRates.get(targetCurrency);
            return amount * usdToTargetRate;
        }
    }
