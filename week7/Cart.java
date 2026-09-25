public class Cart {
    // Encapsulated private fields
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    // Constructor to initialize final ID and fixed array size
    public Cart(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.prices = new double[maxCapacity];
        this.itemCount = 0; // Starts with 0 items
    }

    // Method to add an item's price to the next available position
    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++; // Increments position and item count
        } else {
            System.out.println("Cart is full! Cannot add more items.");
        }
    }

    // Read-only total: loops and computes the sum on request
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    // Read-only item count
    public int getItemCount() {
        return this.itemCount;
    }

    // Optional getter for the fixed Cart ID
    public String getCartId() {
        return this.cartId;
    }
}