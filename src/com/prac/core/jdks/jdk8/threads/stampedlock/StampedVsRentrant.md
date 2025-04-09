## 🔐 1. `ReentrantLock` – Basic Overview

### ✅ Key Features:
- Can **lock/unlock explicitly**
- Supports **fairness**, **interruptible** locking
- Supports **tryLock()**
- Can be **re-entered** by the same thread (reentrant)

---

### 📘 Example: `ReentrantLock`

```java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        lock.lock(); // acquire lock
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented to: " + count);
        } finally {
            lock.unlock(); // release lock
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample counter = new ReentrantLockExample();
        Runnable task = counter::increment;

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();
    }
}
```

---

## 🌀 2. `StampedLock` – High-Performance Read/Write Lock

### ✅ Key Features:
- Introduced in Java 8
- Designed for **optimistic reads**
- Supports:
    - `readLock()` / `writeLock()`
    - `tryOptimisticRead()`
    - `validate()` (to check if optimistic read was valid)
- **Non-reentrant** – cannot re-enter lock

---

### 📘 Example: `StampedLock`

```java
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    private final StampedLock lock = new StampedLock();
    private int x = 0;

    public void write(int value) {
        long stamp = lock.writeLock(); // write lock
        try {
            x = value;
            System.out.println(Thread.currentThread().getName() + " wrote: " + x);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public void read() {
        long stamp = lock.tryOptimisticRead(); // optimistic read
        int currentValue = x;
        if (!lock.validate(stamp)) {
            // fallback to read lock
            stamp = lock.readLock();
            try {
                currentValue = x;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " read: " + currentValue);
    }

    public static void main(String[] args) {
        StampedLockExample example = new StampedLockExample();

        Thread writer = new Thread(() -> example.write(42), "Writer");
        Thread reader = new Thread(example::read, "Reader");

        writer.start();
        reader.start();
    }
}
```

---

## 🔍 ReentrantLock vs StampedLock – Comparison

| Feature                  | `ReentrantLock`           | `StampedLock`                    |
|--------------------------|----------------------------|----------------------------------|
| Reentrant                | ✅ Yes                     | ❌ No                            |
| Read/Write separation    | ❌ No                      | ✅ Yes (read vs write locks)     |
| Optimistic Read          | ❌ No                      | ✅ Yes                           |
| Performance (Read-heavy) | 🔸 OK                      | 🚀 Very good                     |
| Interruptible Locking    | ✅ Yes                     | ❌ No                            |
| Use case                 | General purpose locking    | High-perf read-heavy structures  |

---

## 🧠 TL;DR

- `ReentrantLock` is a thread-friendly, reentrant, general-purpose lock.
- `StampedLock` is high-performance and ideal for **read-heavy** applications with **optimistic reading**.
- Choose based on **read/write contention** and whether reentrancy is needed.
