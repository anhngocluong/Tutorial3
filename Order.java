package Tutorial3;

public class Order {
    private int id;
    private Customer customer;
    private Product[] products;
    private int[] quantities;
    private String orderDate;
    private String status;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product[] getProducts() {
        return products;
    }
    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int[] getQuantities() {
        return quantities;
    }
    public void setQuantities(int[] quantities) {
        this.quantities = quantities;
    }

    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public double calculateTotalValue(){
        double total = 0;
        for (int i = 0; i < products.length; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void applyDiscount(){
        if (customer.isLoyalCustomer(false)) {
            double total = calculateTotalValue();
            System.out.println("Original Total: $" + total);
            total *= 0.9;
            System.out.println("Discounted Total: $" + total);
        }
    }

    public void diplayDetails(){
        System.out.println("Order ID: " + id);
        customer.displayInfo();
        for (int i = 0; i < products.length; i++) {
            System.out.println("Product Name: " + products[i].getName());
        }
        System.out.println("Status: " + status);
    }

    public void displayDetails() {

    }
}
