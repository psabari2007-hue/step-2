import java.util.Scanner;

// Interface for parcels that can be insured
interface Insurable {
    double getInsurance();
}

// Abstract base class representing a generic Parcel
abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double getCharge();

    public double getInsuranceCost() {
        if (this instanceof Insurable) {
            return ((Insurable) this).getInsurance();
        }
        return 0.0;
    }

    public double getTotal() {
        return getCharge() + getInsuranceCost();
    }
}

// Standard Parcel Implementation
class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double getCharge() {
        return 40.0 + (10.0 * weight);
    }
}

// Express Parcel Implementation
class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double getCharge() {
        return 80.0 + (15.0 * weight);
    }

    @Override
    public double getInsurance() {
        return 0.02 * declaredValue;
    }
}

// Fragile Parcel Implementation
class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double getCharge() {
        // Standard charge plus a handling fee of 50
        double standardCharge = 40.0 + (10.0 * weight);
        return standardCharge + 50.0;
    }

    @Override
    public double getInsurance() {
        return 0.02 * declaredValue;
    }
}

// Main Driver Class
public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        double grandTotal = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            
            Parcel parcel = null;
            
            switch (type.toUpperCase()) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;
                default:
                    continue;
            }
            
            double charge = parcel.getCharge();
            double insurance = parcel.getInsuranceCost();
            double total = parcel.getTotal();
            grandTotal += total;
            
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", 
                    type, charge, insurance, total);
        }
        
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}