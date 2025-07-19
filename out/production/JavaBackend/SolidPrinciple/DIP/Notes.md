---

# 📘 Dependency Inversion Principle (DIP)

### 🔁 DIP Definition:

**High-level modules should not depend on low-level modules. Both should depend on abstractions.**

**Abstractions should not depend on details. Details should depend on abstractions.**

---

## 🧠 Why DIP?

Without DIP:

* High-level class (e.g., `OrderService`) directly creates or tightly couples with low-level class (`EmailService`).
* This makes code **hard to test, extend, and reuse**.

With DIP:

* Both classes depend on a **common abstraction** (e.g., interface `NotificationService`).
* **Flexibility** increases. We can inject any implementation.

---

## ✅ Without DIP (Bad Design)

```java
class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class OrderService {
    private EmailService emailService = new EmailService();

    public void placeOrder() {
        // tightly coupled to EmailService
        emailService.sendEmail("Order placed successfully");
    }
}
```

---

## ✅ With DIP (Good Design)

```java
interface NotificationService {
    void sendNotification(String message);
}

class EmailService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("SMS: " + message);
    }
}

class OrderService {
    private NotificationService notificationService;

    // Constructor Injection
    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        System.out.println("Placing order...");
        notificationService.sendNotification("Order placed!");
    }
}
```

---

# 💉 Dependency Injection (DI)

> **Dependency Injection** is a technique to achieve **Dependency Inversion Principle**.

## 🔹 Three Main Types of Dependency Injection:

---

### 1️⃣ Constructor Injection (Most Common)

```java
class Client {
    private Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void process() {
        service.serve();
    }
}
```

✔ Promotes immutability
✔ Best for mandatory dependencies
❌ Requires constructor call with all dependencies

---

### 2️⃣ Setter / Property Injection

```java
class Client {
    private Service service;

    public void setService(Service service) {
        this.service = service;
    }

    public void process() {
        service.serve();
    }
}
```

✔ Good for optional dependencies
❌ Risk of using uninitialized dependencies

---

### 3️⃣ Method Injection

```java
class Client {
    public void process(Service service) {
        service.serve();
    }
}
```

✔ Simple
❌ Less control over lifecycle
❌ Not useful for persistent dependencies

---

# 🔧 Spring DI Example (Autowired / Property Injection)

```java
@Component
class EmailService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("Email: " + message);
    }
}

@Component
class OrderService {

    @Autowired // Property Injection
    private NotificationService notificationService;

    public void placeOrder() {
        notificationService.sendNotification("Spring Order Placed!");
    }
}
```

---

# 📌 Summary Table

| Type        | When to Use                         | Pros                | Cons                                 |
| ----------- | ----------------------------------- | ------------------- | ------------------------------------ |
| Constructor | Mandatory dependencies              | Immutable, testable | Must inject all on creation          |
| Setter      | Optional dependencies               | Flexible            | Risk of null if not set              |
| Method      | Short-lived / per-call dependencies | Simple              | Can’t persist, harder lifecycle mgmt |

---

# 🧪 Bonus: Manual Injection (without Spring)

```java
public class Main {
    public static void main(String[] args) {
        NotificationService service = new EmailService(); // abstraction
        OrderService orderService = new OrderService(service); // inject via constructor

        orderService.placeOrder();
    }
}
```

---


