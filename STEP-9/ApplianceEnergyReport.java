import java.util.Scanner;

public class ApplianceEnergyReport {

    // Enum representing the appliances with their power ratings and saver mode support
    enum ApplianceType {
        FRIDGE(150, false),
        AC(1500, true),
        TV(100, false),
        WASHER(500, true);

        private final int powerRating;
        private final boolean supportsSaverMode;

        ApplianceType(int powerRating, boolean supportsSaverMode) {
            this.powerRating = powerRating;
            this.supportsSaverMode = supportsSaverMode;
        }

        public int getPowerRating() {
            return powerRating;
        }

        public boolean supportsSaverMode() {
            return supportsSaverMode;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");

            if (tokens.length < 2) continue;

            String applianceName = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean isSaverRequested = (tokens.length == 3 && tokens[2].equalsIgnoreCase("SAVER"));

            try {
                ApplianceType type = ApplianceType.valueOf(applianceName.toUpperCase());

                // Check business rule for saver mode support
                if (isSaverRequested && !type.supportsSaverMode()) {
                    System.out.printf("%s: saver mode not supported.\n", applianceName);
                } else {
                    // Calculate units (kWh)
                    double units = (type.getPowerRating() * hours) / 1000.0;
                    if (isSaverRequested) {
                        units *= 0.75; // 25% reduction
                    }

                    // Calculate cost
                    double cost = units * 8.0;
                    totalCost += cost;

                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", applianceName, units, cost);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown appliance: " + applianceName);
            }
        }

        // Print final total cost
        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}