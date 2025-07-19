# Builder Pattern in Java - Full Notes

## 1. Introduction

The **Builder Pattern** is a creational design pattern used to construct complex objects step by step. It allows for more control and flexibility when creating immutable or partially optional objects, especially when constructors have too many parameters (known as **constructor telescoping** or **constructor explosion**).

---

## 2. Problem it Solves

When a class has:

- Many parameters (some optional)
- Multiple constructor overloads
- Confusion due to the order of parameters
- Need for immutability after construction

**Example of constructor explosion:**

```
java
public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public User(String firstName) { ... }
    public User(String firstName, String lastName) { ... }
    public User(String firstName, String lastName, int age) { ... }
    public User(String firstName, String lastName, int age, String email) { ... }
}
```

This leads to code duplication, hard-to-read API, and confusion.

---

## 3. Builder Pattern Structure

### a. Main Class (e.g., `User`)

- Has private final fields
- Private constructor that takes a builder object

### b. Static Nested `Builder` Class

- Has same fields as main class (but usually mutable)
- Has setter-like methods returning `Builder` (for chaining)
- Has a `build()` method that returns the main object

---

## 4. Java Code Example

```java
public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
```

### Usage:

```
java
User user = new User.Builder()
    .setFirstName("John")
    .setLastName("Doe")
    .setAge(30)
    .setEmail("john@example.com")
    .build();
```

---

## 5. Advantages

- Avoids constructor overloading
- Easier to read and write
- Flexible and scalable
- Object becomes immutable if fields are `final`
- Good for complex object creation with optional parameters

---

## 6. Disadvantages

- More boilerplate code
- Slightly more memory usage due to additional class
- Slight learning curve

---

## 7. Best Practices

- Make the target class fields `final`
- Make constructor of target class `private`
- Provide validation logic inside `build()` if necessary

---

## 8. Real-World Use Cases

- Building configuration objects
- Creating DTOs (Data Transfer Objects)
- GUI frameworks where multiple properties must be set
- Frameworks like Lombok (@Builder), Jackson, and more

---

## 9. Summary

The Builder Pattern is a powerful design pattern for clean, scalable, and flexible object creation, particularly when handling many optional parameters.

Use it when:

- Constructor has too many parameters
- You want to ensure immutability
- You want code that's easier to read and maintain

