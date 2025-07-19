---

# 🛡️ Open-Closed Principle (OCP) in Java

> One of the 5 SOLID Principles of Object-Oriented Design

---

## ✅ What is OCP?

**Open-Closed Principle** says:

> ❝ *Software entities (classes, modules, functions) should be open for extension, but closed for modification.* ❞

**Meaning:**

* You should be able to **add new behavior** to your class **without changing** existing code.
* Code should be **extensible**, not breakable.

---

## 🔍 Why is OCP Important?

Without OCP:

* You keep modifying old code every time you add a new feature.
* That introduces **bugs** and breaks existing logic.
* Your code becomes **fragile and unscalable**.

With OCP:

* You add new features by adding **new classes**, not modifying old ones.
* Old code stays untouched and **tested**.
* Your code is **safe, scalable, and clean**.

---

## 🚫 Bad Design (Violating OCP)

Let’s say you’re calculating discount for different account types.

```java
class DiscountCalculator {
    public int calculateDiscount(String accountType) {
        if (accountType.equals("REGULAR")) {
            return 10;
        } else if (accountType.equals("PREMIUM")) {
            return 20;
        } else if (accountType.equals("GOLD")) {
            return 30;
        }
        return 0;
    }
}
```

### ❌ Problem:

* Every time a new account type comes in (e.g., “PLATINUM”), you have to modify this method.
* You’ll have to re-test the whole class again.
* Logic becomes messy over time.

---

## ✅ Good Design (Following OCP)

Use **abstraction** and **polymorphism** to make the system extendable.

### Step 1: Create an interface

```java
interface DiscountStrategy {
    int getDiscount();
}
```

### Step 2: Implement for each account type

```java
class RegularAccount implements DiscountStrategy {
    public int getDiscount() {
        return 10;
    }
}

class PremiumAccount implements DiscountStrategy {
    public int getDiscount() {
        return 20;
    }
}

class GoldAccount implements DiscountStrategy {
    public int getDiscount() {
        return 30;
    }
}
```

### Step 3: Discount Calculator remains untouched

```java
class DiscountCalculator {
    public int calculateDiscount(DiscountStrategy strategy) {
        return strategy.getDiscount();
    }
}
```

### ✅ Add new account types without touching old code!

```java
class PlatinumAccount implements DiscountStrategy {
    public int getDiscount() {
        return 40;
    }
}
```

No need to modify `DiscountCalculator` at all! 🎉
Just **pass a new object**, and OCP is respected.

---

## 🧠 Real-World Example Analogy

Imagine a **payment gateway** that supports cards and wallets.

If you hardcode logic for each one in one class, you’ll break something when adding UPI later.

Instead, create `PaymentMethod` interface and add new payment types via new classes. That’s OCP.

---

## 🧩 Summary

| Concept     | Bad Design                                  | Good Design (OCP)             |
| ----------- | ------------------------------------------- | ----------------------------- |
| Code change | Frequent edits to old code                  | Only new classes added        |
| Bug Risk    | High, easy to break                         | Low, existing logic untouched |
| Scalability | Poor                                        | Excellent                     |
| Principle   | Closed for modification, open for extension |                               |

---

## ✅ When to Apply OCP?

* When features are growing
* When behavior changes based on type/category
* When you’re constantly updating the same class with `if-else` or `switch` for types

---

## 💬 Conclusion

Design your system so that **new features = new classes**, not changes to old ones.
This leads to:

* Safe code
* Easy testing
* Happy developers 😊

---

