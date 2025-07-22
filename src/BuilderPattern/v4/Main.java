package BuilderPattern.v4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product p = new Product.Builder()
                .setName("iPhone 15 Pro")
                .setDesc("The latest iPhone with A17 chip")
                .setPrice(1399)
                .setBrand("Apple")
                .setCategory("Mobile")
                .setDiscount(5)
                .setCreatedAt("2025-07-22")
                .setUpdatedAt("2025-07-22")
                .setImages(List.of("front.jpg", "back.jpg"))
                .build();

        System.out.println("Product created successfully.");
    }
}
