package BuilderPattern.v4;


import java.util.List;

public class Product {
    private final String name;
    private final String desc;
    private final int price;
    private final String brand;
    private final String category;
    private final int discount;
    private final String createdAt;
    private final String updatedAt;
    private final List<String> images;

    private Product(Builder builder) {
        this.name = builder.name;
        this.desc = builder.desc;
        this.price = builder.price;
        this.brand = builder.brand;
        this.category = builder.category;
        this.discount = builder.discount;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.images = builder.images;
    }

    public static class Builder {
        private String name;
        private String desc;
        private int price;
        private String brand;
        private String category;
        private int discount;
        private String createdAt;
        private String updatedAt;
        private List<String> images;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder setPrice(int price) {
            if (price < 0) throw new IllegalArgumentException("Price must be positive");
            this.price = price;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setDiscount(int discount) {
            this.discount = discount;
            return this;
        }

        public Builder setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder setImages(List<String> images) {
            this.images = images;
            return this;
        }

        public Product build() {
            // Example validation
            if (name == null || price <= 0) {
                throw new IllegalStateException("Name and valid price are required");
            }
            return new Product(this);
        }
    }

    // You can add getters here if needed
}
