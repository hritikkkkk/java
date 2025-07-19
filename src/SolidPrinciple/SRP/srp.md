---

# ✅ Single Responsibility Principle (SRP)

## 📖 Definition:

> ❝ A class should have only one reason to change. ❞
> That means it should only **do one thing** and **do it well** .

---

## 🔍 Why is SRP Important?

* If one class does too much, any change in one feature might **break** others.
* Code becomes **hard to maintain and test**.
* SRP encourages **clean separation of concerns**.

---

## ❌ Bad Design (Violating SRP)

```java
class Report {
    public void generateReport() {
        // logic to generate report
    }

    public void printReport() {
        // logic to print report
    }

    public void saveToDB() {
        // logic to save report to database
    }
}
```

### 🚨 Problem:

* This class does **3 things**:

    * Generate
    * Print
    * Save
* If DB logic changes, you risk breaking print/generate logic.
* Hard to reuse and test.

---

## ✅ Good Design (Following SRP)

Break it into multiple classes with **single responsibilities**:

```java
class ReportGenerator {
    public void generateReport() {
        // logic to generate
    }
}

class ReportPrinter {
    public void printReport() {
        // logic to print
    }
}

class ReportSaver {
    public void saveToDB() {
        // logic to save
    }
}
```

* Now each class has **one reason to change**.
* Better testing, readability, and maintainability.

---

## 📦 Real-World Example

**Bad**: A class that takes orders, sends emails, prints invoices
**Good**:

* `OrderProcessor`
* `EmailService`
* `InvoicePrinter`

---

## 🧠 Summary:

| Feature        | Bad SRP | Good SRP |
| -------------- | ------- | -------- |
| Responsibility | Many    | One      |
| Change Risk    | High    | Low      |
| Maintenance    | Hard    | Easy     |
| Reusability    | Low     | High     |

---
