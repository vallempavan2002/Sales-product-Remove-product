import java.text.DecimalFormat;
import java.util.ArrayList;

public class PriceTable {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##"); // To format decimals to two decimal places

        // Define the table of prices
        ArrayList<String[]> prices = new ArrayList<>();
        prices.add(new String[]{"Product", "Sales_2021", "Sales_2022", "Variance", "Variance_Percentage"});
        prices.add(new String[]{"Tea", "100", "120", "", ""});
        prices.add(new String[]{"Coffee", "250", "230", "", ""});
        prices.add(new String[]{"Green_Tea", "50", "60", "", ""});
        prices.add(new String[]{"Orange_Soda", "180", "210", "", ""});
        prices.add(new String[]{"Lemon_Soda", "220", "205", "", ""});

        // Remove the "Tea" product from the table
        for (String[] row : prices) {
            if (row[0].equals("Tea")) {
                prices.remove(row);
                break;
            }
        }

        // Calculate variance and variance percentage for each remaining product
        for (int i = 1; i < prices.size(); i++) {
            String[] row = prices.get(i);
            double sales2021 = Double.parseDouble(row[1]);
            double sales2022 = Double.parseDouble(row[2]);
            double variance = sales2022 - sales2021;
            double variancePercentage = (variance / sales2021) * 100;

            row[3] = df.format(variance);
            row[4] = df.format(variancePercentage) + "%";
        }

        // Print the table
        for (String[] row : prices) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s%n", row);
        }
    }
}
