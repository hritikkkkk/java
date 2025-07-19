
# ✅ Liskov Substitution Principle (LSP)

## 📖 Definition:

> ❝ Subtypes must be substitutable for their base types without affecting correctness. ❞
> In simple words: **Child class should be able to replace parent class without breaking behavior.**

---

## 🔍 Why is LSP Important?

* Helps you use polymorphism safely.
* Ensures inheritance is meaningful.
* Prevents surprises in runtime when you use child class instead of parent.

---

## ❌ Bad Design (Violating LSP)

```java
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly!");
    }
}
```

### 🚨 Problem:

* You **can’t substitute** Ostrich for Bird.
* `bird.fly()` breaks for Ostrich → LSP violated.

---

## ✅ Good Design (Following LSP)

### Step 1: Break into proper interfaces

```java
interface Bird {
    void eat();
}

interface Flyable {
    void fly();
}
```

### Step 2: Implement only what applies

```java
class Sparrow implements Bird, Flyable {
    public void eat() { System.out.println("Eating..."); }
    public void fly() { System.out.println("Flying..."); }
}

class Ostrich implements Bird {
    public void eat() { System.out.println("Eating..."); }
}
```

Now, **no one is forced** to implement `fly()` unnecessarily. ✅

---

## 📦 Real-World Example

**Bad**: Electric car inherits `Vehicle` and is forced to implement `refuel()` even though it charges battery.
**Good**: Separate `FuelVehicle` and `ElectricVehicle` interfaces.

---

## 🧠 Summary:

| Feature      | Bad LSP                   | Good LSP                |
| ------------ | ------------------------- | ----------------------- |
| Substitution | Unsafe, breaks at runtime | Safe, works as expected |
| Inheritance  | Abused                    | Proper                  |
| Maintenance  | Risky                     | Stable                  |

---

## 🔁 Relationship Among SRP, OCP, LSP:

| Principle | Goal                               | Related To      |
| --------- | ---------------------------------- | --------------- |
| SRP       | 1 class = 1 responsibility         | Class structure |
| OCP       | Add features without changing code | Extensibility   |
| LSP       | Safe inheritance + polymorphism    | Subclassing     |

---


