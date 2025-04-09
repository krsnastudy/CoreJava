## 💎 What is the Diamond Problem?

Imagine this class hierarchy:

```
    A
   / \
  B   C
   \ /
    D
```

If **class D** inherits methods from **both B and C**, and both B and C override a method from A — then **which method should D inherit**?

This ambiguity is the **diamond problem**.

---

## 👀 Java’s Position Before Java 8

Java **does not allow multiple class inheritance**:

```java
class A {}
class B extends A {}
class C extends A {}
class D extends B, C {} // ❌ Compilation error
```

👉 This avoids ambiguity — **no multiple inheritance of classes.**

---

## 🔄 What Changed in Java 8?

With **default methods** in interfaces, Java allowed interfaces to have concrete methods:

```java
interface A {
    default void hello() { System.out.println("Hello from A"); }
}

interface B extends A {
    default void hello() { System.out.println("Hello from B"); }
}

interface C extends A {
    default void hello() { System.out.println("Hello from C"); }
}

class D implements B, C {
    // Must resolve conflict
    public void hello() {
        B.super.hello(); // or C.super.hello()
    }
}
```

---

## 🔍 How Java Resolves the Diamond Problem

Java follows clear rules:

### ✅ Rule 1: **Class > Interface**
If a method is found in a class (or superclass), it wins over any interface default method.

### ✅ Rule 2: **Most Specific Interface Wins**
If multiple interfaces define the same default method and one interface extends the other, the **more specific (child) interface** wins.

### ✅ Rule 3: **Conflict? You must override**
If multiple interfaces provide the same default method and are unrelated (i.e., no inheritance between them), **the compiler forces you to override it**.

---

## 🧪 Real Example

```java
interface A {
    default void greet() { System.out.println("Hello from A"); }
}

interface B {
    default void greet() { System.out.println("Hello from B"); }
}

class MyClass implements A, B {
    // Conflict! Must override
    public void greet() {
        // Resolve explicitly
        A.super.greet();
        // B.super.greet(); // also valid
    }
}
```

✅ This compiles fine because `MyClass` **resolves the conflict manually**.

---

## 🧠 TL;DR

- 🧩 The **diamond problem** arises with multiple inheritance and method conflicts.
- 🚫 Java avoids it with **no multiple class inheritance**.
- ✅ In **Java 8**, default methods in interfaces reintroduce this issue.
- 🤝 Java resolves it with clear **rules**, and if ambiguity remains, **you must override**.

---