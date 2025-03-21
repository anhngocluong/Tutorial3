package Tutorial3;

import java.util.Date;

public class ComputerStore {
    private Product[] products;
    private Customer[] customers;
    private Order[] orders;
    private int productCount = 0;
    private int customerCount = 0;
    private int orderCount = 0;

    public void addProduct(Product product) {
        products[productCount++] = product;
    }

    public void addCustomer(Customer customer) {
        customers[customerCount++] = customer;
    }

    public Order createOrder(Customer customer, Product[] product, int[] quantities) {
        Order order = new Order();
        order.setId(orderCount++);
        order.setCustomer(customer);
        order.setProducts(product);
        order.setQuantities(quantities);
        order.setOrderDate(new Date().toString());
        order.setStatus("new");
        orders[orderCount++] = order;
        return order;
    }

    public void updateStockAfterOrder(Order order) {
        Product[] orderProducts = order.getProducts();
        int[] orderQuantities = order.getQuantities();
        for (int i = 0; i < orderProducts.length; i++) {
            orderProducts[i].setStockQuantity(orderProducts[i].getStockQuantity() - orderQuantities[i]);
        }
    }

    public void changeOrderStatus(int orderId, String newStatus) {
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getId() == orderId) {
                orders[i].setStatus(newStatus);
                break;
            }
        }
    }

    public void displayProductsInCategory(String category) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)){
                products[i].displayInfo();
            }
        }
    }
    public void displayCustomersOrders(int customerId){
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getCustomer().getId() == customerId) {
                orders[i].displayDetails();
                System.out.println();
            }
        }
    }
}
