To get the **student with the 2nd highest total marks**, we need to:

1. **Group by name**, and sum the marks.
2. **Order the results by total marks** in descending order.
3. **Pick the 2nd highest**.

---

## ✅ **SQL Query**

```sql
SELECT name, SUM(marks) AS total_marks
FROM student
GROUP BY name
ORDER BY total_marks DESC
LIMIT 1 OFFSET 1;
```

---

## 🔍 **Explanation**
- `GROUP BY name`: Aggregates marks for each student name.
- `SUM(marks)`: Computes total marks per student.
- `ORDER BY total_marks DESC`: Highest first.
- `LIMIT 1 OFFSET 1`: Skips the top one (1st highest) and fetches the **2nd highest**.

---

## 🧾 **Result for your data:**

| name  | total_marks |
|-------|-------------|
| **Raj**   | **70**         |

✅ This gives **Raj** with the second-highest total marks (70).

---
