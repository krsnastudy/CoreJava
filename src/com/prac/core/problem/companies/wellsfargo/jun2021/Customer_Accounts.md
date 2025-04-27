# 🛠 Problem Statement:

- You have:
    - `Customer` class: has `customerId`, `name`, etc.
    - `Account` class: has `customerId`, `accountType` (like "Savings", "Current", etc.)
- **Goal:** Find customers who have **more than one type of account**.

---

# ✅ Let's first define basic POJO classes:

```java
class Customer {
    private int customerId;
    private String name;

    // Constructor, Getters, Setters

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }
    
    public String getName() {
        return name;
    }
}

class Account {
    private int customerId;
    private String accountType;

    // Constructor, Getters, Setters

    public Account(int customerId, String accountType) {
        this.customerId = customerId;
        this.accountType = accountType;
    }

    public int getCustomerId() {
        return customerId;
    }
    
    public String getAccountType() {
        return accountType;
    }
}
```

---

# ✅ Now the Java 8 Solution:

```java
import java.util.*;
import java.util.stream.Collectors;

public class CustomerAccountExample {

    public static void main(String[] args) {
        
        List<Customer> customers = Arrays.asList(
            new Customer(1, "Krishna"),
            new Customer(2, "John"),
            new Customer(3, "Sara")
        );

        List<Account> accounts = Arrays.asList(
            new Account(1, "Savings"),
            new Account(1, "Current"),
            new Account(2, "Savings"),
            new Account(3, "Savings"),
            new Account(3, "Current"),
            new Account(3, "Loan")
        );

        // Step 1: Group Accounts by customerId and collect distinct account types
        Map<Integer, Set<String>> customerAccountTypes = accounts.stream()
            .collect(Collectors.groupingBy(
                Account::getCustomerId,
                Collectors.mapping(Account::getAccountType, Collectors.toSet())
            ));

        // Step 2: Find Customers who have more than one account type
        List<Customer> customersWithMultipleAccountTypes = customers.stream()
            .filter(cust -> customerAccountTypes.containsKey(cust.getCustomerId()))
            .filter(cust -> customerAccountTypes.get(cust.getCustomerId()).size() > 1)
            .collect(Collectors.toList());

        // Step 3: Output
        customersWithMultipleAccountTypes.forEach(cust -> 
            System.out.println(cust.getName() + " has multiple account types.")
        );
    }
}
```

---

# ✅ Output:
```
Krishna has multiple account types.
Sara has multiple account types.
```

---
# 🔥 How this Works (Summary):

| Step | Action |
|-----|------|
| 1   | Group `Account` objects by `customerId` and get unique `accountTypes` for each customer. |
| 2   | For each `Customer`, check if they have more than one `accountType`. |
| 3   | Collect and print those customers. |

---

# ✅ TL;DR:

> Group accounts by customer, find those with more than one distinct account type, and map back to customer details — all using **Java 8 streams**.

---

Would you also like me to show a **one-line optimized** version using **Collectors.filtering** (Java 9+ feature)? 🚀 (it's a next-level trick for very senior Java dev interviews!)  
👉 Just say "yes"!