# Liskov Substitution Principle (LSP) — Notes & Real-world Examples

### What is LSP?

> Liskov Substitution Principle states:

> "**Objects of a superclass should be  replaceable with objects of a subclass without breaking the application.**"

### Key Insight:

- Inheritance should model a strict **is-a** relationship.
- A subclass **should never weaken or break** the behavior expected from its parent.
- If a base class reference (e.g., `Employee`) points to a derived object (e.g., `Volunteer`), the object **must honor the contract** of the base class without unexpected behavior.
- we're force to override some behaviors in the subclass who does not support that method/behavior, because of inheritance.  

---

## Example 1: Employee Salary Management System (LSP Violation)

### 📌 Problem Setup:

We have an `Employee` class and the following subclasses:

- `FullTimeEmployee`
- `Intern`
- `Vendor`
- `Volunteer`

We assume all employees should be paid via a `calculateSalary()` method. So our design is:

```
java
class Employee {
    public double calculateSalary() {
        // base logic
    }
}

class FullTimeEmployee extends Employee {
    public double calculateSalary() {
        return basePay + stockOptions + bonuses;
    }
}

class Intern extends Employee {
    public double calculateSalary() {
        return stipend;
    }
}

class Volunteer extends Employee {
    public double calculateSalary() {
        return 0; // or throw exception
    }
}
```

### ❌ LSP Violation:

- `Volunteer` is not a paid employee, but it's **forced** to override `calculateSalary()` — either returning `0` or throwing an exception.
- This design assumes **all Employee subclasses are Payable**, which is **not true**.

#### Real LSP Problem:

```
java
List<Employee> employees = getEmployees();
for (Employee emp : employees) {
    System.out.println(emp.calculateSalary()); // ❌ This assumes all employees are payable
}
```

> 🔴 This violates LSP: `Volunteer` is substitutable syntactically but **not semantically** — it doesn't behave like a Payable `Employee`.

### ✅ Better Design (Composition + Interface Segregation)

Separate `Payable` behavior into an interface:

```java
interface Payable {
    double calculateSalary();
}

abstract class Employee {
    protected String name;
    protected String id;
}

class FullTimeEmployee extends Employee implements Payable {
    public double calculateSalary() {
        return basePay + stockOptions;
    }
}

class Intern extends Employee implements Payable {
    public double calculateSalary() {
        return stipend;
    }
}

class Volunteer extends Employee {
    // No salary — doesn't implement Payable
}
```

#### Now:

```
java
List<Employee> employees = getEmployees();
for (Employee emp : employees) {
    if (emp instanceof Payable) {
        System.out.println(((Payable) emp).calculateSalary());
    }
}
```

✔️ This preserves LSP — we never expect `Volunteer` to implement `calculateSalary()`, and it's not treated as `Payable`.

> ✅ A key LSP principle: **Your base type variable (here **``**) should not require special checks for subtypes.** If `Volunteer` needs to be checked or skipped explicitly, LSP is violated.

---

## Example 2: Credit Card Payment System (LSP + ISP Violation)

### 📌 Problem Setup:

We have an abstract class `CreditCard` with methods:

- `tapAndPay()`
- `swipeAndPay()`
- `upiPayment()`
- `intlPayment()`

Subclasses:

- `VisaCard`
- `RuPayCard`
- `MasterCard`

### ❌ Problem:

```
java
abstract class CreditCard {
    abstract void upiPayment();
    abstract void intlPayment();
    // ... others
}

class VisaCard extends CreditCard {
    void upiPayment() { }
    void intlPayment() { /* works */ }
}

class RuPayCard extends CreditCard {
    void upiPayment() { /* works */ }
    void intlPayment() { } // doesn't support!
}
```

- `RuPayCard` is forced to override `intlPayment()` even though it doesn't support it.
- If we call:

```
java
CreditCard card = new RuPayCard();
card.intlPayment(); // ❌ Unexpected behavior
```

> 🔴 This breaks LSP: the base type (`CreditCard`) exposes functionality that not all subclasses can support.

### ✅ Better Design (Hybrid: Abstract + Interfaces)

```java
interface UpiPayment {
    void upiPayment();
}

interface IntlPayment {
    void intlPayment();
}

abstract class CreditCard {
    String ccNumber;
    String owner;
    abstract void tapAndPay();
    abstract void swipeAndPay();
    abstract void onlineTransfer();
    abstract void mandatePayments();
}

class VisaCard extends CreditCard implements IntlPayment {
    public void intlPayment() { /* ... */ }
    // other overrides
}

class RuPayCard extends CreditCard implements UpiPayment {
    public void upiPayment() { /* ... */ }
    // other overrides
}
```

### ✔️ Benefits:

- Each subclass only implements what it supports.
- No subclass is forced to provide unsupported behavior.
- ✅ Preserves LSP and avoids runtime surprises.

---

## Summary of LSP Violation Red Flags

| Red Flag                               | Why It’s Bad                                |
| -------------------------------------- | ------------------------------------------- |
| Overridden methods throw exceptions    | Subclass cannot replace base class behavior |
| Subclass silently ignores base method  | Creates runtime surprises                   |
| Forced to implement irrelevant methods | Leads to broken polymorphism                |
| Conditional checks for subclass type   | Breaks substitutability of base class       |

---

## ✅ Design Principles to Follow

- Use **interfaces** to separate optional behavior.
- Use **composition** when you don’t have a strict "is-a" relationship.
- Always ask:

> *"Can I substitute subclass in place of superclass without adding checks or risking incorrect behavior?"*

