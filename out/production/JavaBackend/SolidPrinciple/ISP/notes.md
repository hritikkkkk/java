---

# 🧩 Interface Segregation Principle (ISP) in Java

> One of the SOLID Principles for OOP Design

---

## ✅ What is ISP?

**Interface Segregation Principle** says:

> ❝ *No client should be forced to depend on methods it does not use.* ❞

In simpler terms:

> Don’t make classes implement unnecessary methods just because they’re in an interface. Break large interfaces into smaller, more specific ones.

---

## 🔍 Why ISP is Important?

If an interface has **too many responsibilities**, then classes **depending** on that interface may be forced to implement methods that don’t apply to them.

This leads to:

* Violating the **Single Responsibility Principle**
* Code that is hard to maintain
* Ugly `throw new UnsupportedOperationException()` hacks

---

## 🚫 Bad Design (Violation of ISP)

```java
interface Account {
    void withdraw();
    void deposit();
    void payEmi();
    void getMaturityPeriod();
}
```

### ❌ Problem:

* `FDAccount` (Fixed Deposit Account) can’t `payEmi()` – it’s not a loan!
* `EducationLoanAccount` shouldn’t `deposit()` more money – it’s a loan!
* But both will be **forced** to implement all methods. That’s bad.

```java
class FDAccount implements Account {
    public void withdraw() { /* valid */ }
    public void deposit() { /* valid */ }
    public void payEmi() { 
        throw new UnsupportedOperationException("Not supported in FD");
    }
    public void getMaturityPeriod() { /* valid */ }
}
```

See that ugly `UnsupportedOperationException`? This violates ISP.

---

## ✅ Good Design (Following ISP)

### 👉 Break down into smaller interfaces:

```java
interface Withdrawable {
    void withdraw();
}

interface Depositable {
    void deposit();
}

interface EMIPayable {
    void payEmi();
}

interface MaturityInformable {
    void getMaturityPeriod();
}
```

---

### ✅ FD Account (Only relevant behavior)

```java
class FDAccount implements Withdrawable, Depositable, MaturityInformable {
    public void withdraw() { /* logic */ }
    public void deposit() { /* logic */ }
    public void getMaturityPeriod() { /* logic */ }
}
```

### ✅ Education Loan Account

```java
class EducationLoanAccount implements Withdrawable, EMIPayable {
    public void withdraw() { /* logic */ }
    public void payEmi() { /* logic */ }
}
```

Now each class only implements what it **needs**. No forced methods. Clean design.

---

## 💡 Think of ISP as “SRP for Interfaces”

* **SRP** (Single Responsibility Principle) says: *A class should have one reason to change.*
* **ISP** says: *An interface should have one reason to change.*

If your interface does too many things, it will change too often — affecting many unrelated classes.

---

## 🔁 Summary

| Concept              | Bad Design                                  | Good Design                      |
| -------------------- | ------------------------------------------- | -------------------------------- |
| Interface            | Fat (bulky) `Account` interface             | Multiple small interfaces        |
| Class Implementation | Forced to implement unused methods          | Only implements what it needs    |
| Code Maintenance     | Hard, brittle, ugly                         | Clean, flexible, maintainable    |
| Real-world Use       | FD or Loan classes doing unnecessary things | Only exact behavior is inherited |

---

## ✅ When to Apply ISP?

* When interfaces are getting too big
* When different implementations need different methods
* When you see `throw new UnsupportedOperationException()`
* When code smells like it’s “doing too much”

---

## 💬 Conclusion

Always design **focused interfaces**. This makes your code:

* Easier to read
* Easier to maintain
* Easier to test
* More flexible for future features

---






