### ✅ **"Port and Adapter Pattern" (aka Hexagonal Architecture)**
Also known as the **Hexagonal Pattern**, this design pattern is used to create **loosely coupled** application structures, making code **independent of frameworks, UI, or databases**.

---

## 🔄 **Port and Adapter Pattern (Hexagonal Architecture)**

### 📦 Components:

1. **Core (Application/Domain Logic)** — The heart of your app.
2. **Ports** — Interfaces that define how the core interacts with the outside world.
3. **Adapters** — Implement those ports (e.g., REST API, DB, CLI).

---

### 🔁 Analogy: Think of an Electrical Socket (Port)
- The **port** is the wall socket.
- You can plug in different **adapters**: laptop charger, phone, etc.
- The socket (port) defines the **interface**, and devices (adapters) implement it.

---

### 🧰 Example in Java

Let’s say you're building a **payment system**. You want your core logic to work with **any payment provider**.

#### 🧠 Core Port (Interface)
```java
public interface PaymentPort {
    void processPayment(double amount);
}
```

#### 💡 Adapter (Stripe Payment)
```java
public class StripeAdapter implements PaymentPort {
    public void processPayment(double amount) {
        System.out.println("Processed $" + amount + " with Stripe.");
    }
}
```

#### 💼 Core Application Logic
```java
public class PaymentService {
    private final PaymentPort paymentPort;

    public PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void pay(double amount) {
        paymentPort.processPayment(amount);
    }
}
```

#### 🚀 Running the App
```java
public class Main {
    public static void main(String[] args) {
        PaymentPort stripe = new StripeAdapter();
        PaymentService service = new PaymentService(stripe);
        service.pay(250.0);
    }
}
```

---

### ✅ Benefits:
| Benefit               | Description |
|----------------------|-------------|
| 🔌 **Plug & Play**   | Easily switch DBs, APIs, services by changing adapters. |
| 🔄 **Testability**   | You can mock `PaymentPort` for testing. |
| 📦 **Separation**    | Clear separation of domain logic and external concerns. |
| 🔧 **Flexibility**   | Great for microservices or complex enterprise systems. |

---

## 🧠 TL DR
- **“Porter” design pattern** is likely a **misheard/mistyped** reference to the **Port and Adapter** pattern.
- This pattern is about creating **loose coupling** and **easy-to-test** architectures.
- It’s also called **Hexagonal Architecture**.

---
