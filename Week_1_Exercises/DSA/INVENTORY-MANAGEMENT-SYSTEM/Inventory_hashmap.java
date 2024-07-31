import java.util.HashMap;

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    
    public void updateProduct(String productId, Product product) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, product);
        } else {
            System.out.println("Product not found");
        }
    }
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found");
        }
    }


    public Product getProduct(String productId) {
        return inventory.get(productId);
    }
}
