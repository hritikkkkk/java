package BuilderPattern.v3;

import java.util.List;

public class Product {
    private String name;
    private String desc;
    private int price;
    private String brand;
    private String category;
    private int discount;
    private String createdAt;
    private String updatedAt;
    private List<String> images;

    public Product(Builder b) {
        if (b.getPrice() > 0) {
            this.price = b.getPrice();
        }
        this.name = b.getName();
        this.desc = b.getDesc();
        this.price = b.getPrice();
        this.brand = b.getBrand();
        this.category = b.getCategory();
        this.discount = b.getDiscount();
        this.createdAt = b.getCreatedAt();
        this.updatedAt = b.getUpdatedAt();
        this.images = b.getImages();
    }
}
