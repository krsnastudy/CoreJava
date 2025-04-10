## ✅ What’s the Contract?

### 📜 Java Specification Says:

If two objects are **equal according to `equals()`**, then they **must** return the same hash code.

```java
if (a.equals(b)) {
    assert a.hashCode() == b.hashCode(); // must be true
}
```

But the **reverse is not necessarily true**:
```java
if (a.hashCode() == b.hashCode()) {
    // a.equals(b) may or may not be true
}
```

---

## 🔥 What Happens If You Break the Contract?

### ❌ Case 1: `equals()` is overridden, but `hashCode()` is not

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person && ((Person) obj).name.equals(this.name);
    }

    // no hashCode()
}
```

### 🧪 Problem in `HashSet`:

```java
Set<Person> people = new HashSet<>();
people.add(new Person("John"));

System.out.println(people.contains(new Person("John"))); // false ❌
```

Even though `.equals()` returns `true`, the `hashCode()` is different, so **`HashSet` won't find it**.

---

### ❌ Case 2: `hashCode()` is overridden, but `equals()` is not

```java
@Override
public int hashCode() {
    return name.hashCode();
}
// but equals() is inherited from Object (reference equality)
```

### 🧪 Problem:

```java
Set<Person> people = new HashSet<>();
people.add(new Person("John"));

System.out.println(people.contains(new Person("John"))); // false ❌
```

Why? `hashCode()` may match, but `equals()` will return `false` because it's checking object reference.

---

## ✅ Correct Implementation Example

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person && this.name.equals(((Person) obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
```

Now it works correctly with `HashSet`, `HashMap`, etc.

---

## 🚧 Real-World Impact Examples

### 🔍 Scenario 1: Duplicate values in a `Set`
You expect no duplicates, but they sneak in because `equals()` and `hashCode()` are inconsistent.

### 🔍 Scenario 2: Lookup failure in `HashMap`
You put a key, then can’t get the value back using an *equal* key object.

### 🔍 Scenario 3: Memory leaks
Multiple "equal" objects end up in a map or set, using more memory than necessary.

---

## 📚 Resources

1. [Java Language Spec – `equals()` and `hashCode()` contract](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))
2. [Effective Java by Joshua Bloch – Item 10 & 11](https://amzn.to/3lAwq5p) – Must read
3. [Official Oracle Java Tutorial – Object Methods](https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html)

---

## 🧠 TL;DR

| Method | Role |
|--------|------|
| `equals()` | Determines logical equality |
| `hashCode()` | Helps locate the object in hash-based collections |

❌ Breaking their contract leads to incorrect behavior in `HashSet`, `HashMap`, etc.  
✅ Always override **both** together.
