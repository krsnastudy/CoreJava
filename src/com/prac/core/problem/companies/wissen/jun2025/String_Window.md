# **Longest Substring with At Most Two Distinct Characters**

Given a string, we need to find the **longest substring** that contains **at most two distinct characters**. This is a classic sliding window problem.

## **Approach**
1. **Sliding Window Technique**:
    - Use two pointers (`left` and `right`) to represent the current window.
    - Maintain a frequency map (`HashMap<Character, Integer>`) to track characters in the window.
    - If the map size exceeds `2`, move `left` to shrink the window until only two distinct characters remain.
    - Keep track of the maximum window size.

## **Solution Code**
```java
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinctChars {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

            // If more than 2 distinct chars, shrink the window from the left
            while (charCount.size() > 2) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            // Update the maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s)); // Output: 3 ("ece")

        s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s)); // Output: 5 ("aabbb")
    }
}
```

### **Explanation**
1. **Initialization**:
    - `left = 0` (window start), `maxLen = 0` (result).
    - `charCount` keeps track of character frequencies in the current window.

2. **Expanding the Window (`right` pointer)**:
    - For each new character, update its count in `charCount`.

3. **Shrinking the Window (`left` pointer)**:
    - If `charCount.size() > 2`, move `left` to exclude characters until only two distinct ones remain.

4. **Updating Maximum Length**:
    - After adjusting the window, update `maxLen` if the current window is larger.

### **Example Walkthrough**
**Input**: `"eceba"`
- **Window Expansion**:
    - `e` → `{e:1}`, maxLen=1
    - `c` → `{e:1, c:1}`, maxLen=2
    - `e` → `{e:2, c:1}`, maxLen=3
    - `b` → `{e:2, c:1, b:1}` → **Shrink** (`left++` until `{e:1, b:1}`)
    - `a` → `{e:1, b:1, a:1}` → **Shrink** (`left++` until `{b:1, a:1}`)
- **Final Result**: `3` (from `"ece"`).

## **Time & Space Complexity**
- **Time Complexity**: **O(n)** (each character processed at most twice).
- **Space Complexity**: **O(1)** (since `charCount` holds at most 3 entries).

## **Alternative (Optimized for Fixed Character Set)**
If the input string contains only lowercase letters, we can use a **frequency array** instead of a `HashMap`:
```java
public static int lengthOfLongestSubstringTwoDistinct(String s) {
    int[] count = new int[128]; // Assuming ASCII
    int left = 0, distinct = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        if (count[s.charAt(right)]++ == 0) distinct++;
        while (distinct > 2) {
            if (--count[s.charAt(left++)] == 0) distinct--;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

# **Why Do We Shrink the Window When `{e:2, c:1, b:1}` Occurs?**

In the sliding window approach for finding the **longest substring with at most two distinct characters**, we shrink the window when the number of distinct characters exceeds **2**. Here's a detailed breakdown of why and how this happens:

---

## **1. The Rule: Window Can Have ≤ 2 Distinct Characters**
- The goal is to maintain a window (`left` to `right`) that contains **no more than two distinct characters**.
- If a third distinct character enters the window (`b` in this case), we must **shrink the window from the left** until only two distinct characters remain.

---

## **2. Example Walkthrough (String = `"eceba"`)**
Let’s analyze the state when `right` is at `'b'` (3rd index):

### **Current Window: `"eceb"`**
| Index | Character | Frequency Map (`charCount`) |
|-------|-----------|-----------------------------|
| 0     | `'e'`     | `{e:2, c:1, b:1}`           |
| 1     | `'c'`     | (Now 3 distinct characters) |
| 2     | `'e'`     |                             |
| 3     | `'b'`     |                             |

### **Problem:**
- The map `{e:2, c:1, b:1}` has **3 distinct characters** (`e`, `c`, `b`), which violates the rule.

---

## **3. How Shrinking Works**
We **move `left` forward** until the window has only **two distinct characters**:

### **Step-by-Step Shrinking:**
1. **Initial State**:
    - `left = 0`, `charCount = {e:2, c:1, b:1}`
    - **Distinct characters = 3** (`e`, `c`, `b`) → **Need to shrink**.

2. **Move `left` to `1` (char = `'c'`)**:
    - Decrement `'e'`'s count: `{e:1, c:1, b:1}`
    - Remove `'e'` if count reaches `0` (still `e:1`).
    - **Distinct characters = 3** → Still invalid.

3. **Move `left` to `2` (char = `'e'`)**:
    - Decrement `'c'`'s count: `{e:1, c:0, b:1}`
    - Since `'c'`'s count is `0`, **remove `'c'`**: `{e:1, b:1}`
    - **Now distinct characters = 2** (`e`, `b`) → Valid window.

### **Final Window After Shrinking: `"ceb"` → `"eb"`**
- The valid window is now from `left = 2` (`'e'`) to `right = 3` (`'b'`).
- The frequency map is `{e:1, b:1}` (only two distinct characters).

---

## **4. Why Remove `'c'` Instead of `'e'`?**
- We shrink from the **leftmost character** (`'e'` at `left=0` first).
- The algorithm doesn’t "choose" which character to remove—it simply **shrinks until the condition is satisfied**.
- In this case, `'c'` was the **second distinct character**, so it gets removed after `'e'`'s count decreases.

---

## **5. Key Takeaways**
| Situation | Action | Result |
|-----------|--------|--------|
| **≤ 2 distinct chars** | Expand window (`right++`) | Track maximum length |
| **> 2 distinct chars** | Shrink window (`left++`) | Until only 2 distinct chars remain |

### **Why This Works**
- Ensures the window **always** contains ≤ 2 distinct characters.
- The longest valid window is tracked via `maxLen`.

---

## **Final Answer**
We shrink the window when `{e:2, c:1, b:1}` occurs because:
1. **There are 3 distinct characters** (`e`, `c`, `b`), which violates the rule.
2. By moving `left` forward, we exclude `'e'` and later `'c'`, reducing the distinct count to **2** (`{e:1, b:1}`).
3. This maintains a valid window while searching for the longest possible substring.


