# **Splitting an Array into Chunks in Java**

There are several ways to split an array into smaller chunks (sub-arrays) of a fixed size. Below are the most common approaches:

---

## **1. Using Loops (Manual Approach)**
### **Method**
- Iterate over the original array and create sub-arrays of the desired chunk size.
- Works for both primitive arrays and object arrays.

### **Example**
```java
public class ArraySplitter {
    public static int[][] splitArray(int[] array, int chunkSize) {
        int numOfChunks = (int) Math.ceil((double) array.length / chunkSize);
        int[][] output = new int[numOfChunks][];

        for (int i = 0; i < numOfChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(array.length, start + chunkSize);
            int length = end - start;
            
            output[i] = new int[length];
            System.arraycopy(array, start, output[i], 0, length);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int chunkSize = 3;
        
        int[][] chunks = splitArray(originalArray, chunkSize);
        
        for (int[] chunk : chunks) {
            System.out.println(Arrays.toString(chunk));
        }
    }
}
```
**Output:**
```
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]
```

### **Pros & Cons**
✅ Works for **primitive arrays** (`int[]`, `char[]`, etc.).  
✅ No external libraries needed.  
❌ Requires manual array copying.

---

## **2. Using `Arrays.copyOfRange()` (Java Built-in)**
### **Method**
- Uses `Arrays.copyOfRange()` to extract chunks.
- More concise than manual loops.

### **Example**
```java
import java.util.Arrays;

public class ArraySplitter {
    public static int[][] splitArray(int[] array, int chunkSize) {
        int numOfChunks = (int) Math.ceil((double) array.length / chunkSize);
        int[][] output = new int[numOfChunks][];

        for (int i = 0; i < numOfChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(array.length, start + chunkSize);
            output[i] = Arrays.copyOfRange(array, start, end);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int chunkSize = 4;
        
        int[][] chunks = splitArray(originalArray, chunkSize);
        
        for (int[] chunk : chunks) {
            System.out.println(Arrays.toString(chunk));
        }
    }
}
```
**Output:**
```
[1, 2, 3, 4]
[5, 6, 7, 8]
[9]
```

### **Pros & Cons**
✅ Cleaner than manual array copying.  
✅ Works for **primitive and object arrays**.  
❌ Still requires a loop.

---

## **3. Using Java Streams (Java 8+)**
### **Method**
- Uses `IntStream` and `Collectors.groupingBy()` to split the array.
- More functional-style approach.

### **Example**
```java
import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraySplitter {
    public static int[][] splitArray(int[] array, int chunkSize) {
        return IntStream.range(0, (array.length + chunkSize - 1) / chunkSize)
                .mapToObj(i -> Arrays.copyOfRange(
                        array,
                        i * chunkSize,
                        Math.min(array.length, (i + 1) * chunkSize)
                ))
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int chunkSize = 2;
        
        int[][] chunks = splitArray(originalArray, chunkSize);
        
        for (int[] chunk : chunks) {
            System.out.println(Arrays.toString(chunk));
        }
    }
}
```
**Output:**
```
[1, 2]
[3, 4]
[5, 6]
[7, 8]
[9]
```

### **Pros & Cons**
✅ **Concise** and functional.  
✅ Works well with **Java 8+**.  
❌ Slightly harder to read for beginners.

---

## **4. Using Guava (Google Library)**
### **Method**
- If you're using **Guava**, you can use `Lists.partition()` (for `List<T>`) and convert back to an array.

### **Example**
```java
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

public class ArraySplitter {
    public static <T> List<List<T>> splitArray(T[] array, int chunkSize) {
        return Lists.partition(Arrays.asList(array), chunkSize);
    }

    public static void main(String[] args) {
        Integer[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int chunkSize = 3;
        
        List<List<Integer>> chunks = splitArray(originalArray, chunkSize);
        
        for (List<Integer> chunk : chunks) {
            System.out.println(chunk);
        }
    }
}
```
**Output:**
```
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]
```

### **Pros & Cons**
✅ **Very concise** (best for `List<T>`).  
❌ Requires **Guava dependency**.  
❌ Doesn’t work for **primitive arrays** (must use `Integer[]` instead of `int[]`).

---

## **Comparison of Methods**
| Method | Works for Primitives? | External Library? | Readability | Performance |
|--------|----------------------|------------------|------------|-------------|
| **Manual Loop** | ✅ Yes | ❌ No | Medium | Fast |
| **`Arrays.copyOfRange`** | ✅ Yes | ❌ No | High | Fast |
| **Java Streams** | ✅ Yes | ❌ No | Medium | Moderate |
| **Guava `Lists.partition`** | ❌ No (needs `Integer[]`) | ✅ Yes | High | Fast |

---

## **Final Recommendation**
- **For primitive arrays** → Use `Arrays.copyOfRange()` (Method 2).
- **For object arrays** → Use **Java Streams** (Method 3) or **Guava** (Method 4).
- **For maximum control** → Use manual loops (Method 1).
