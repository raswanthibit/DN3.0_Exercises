public class LinearSearch {
    public Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
