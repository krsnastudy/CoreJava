Here’s how you can write a Java program to perform the sum of two linked lists where each linked list represents a number. The linked lists contain the digits of the number in reverse order.

### Approach:
1. Traverse both linked lists and compute the integer value from their digits.
2. Add the values of the two linked lists.
3. Output the sum.

### Solution:

```java
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}

public class SumOfLinkedLists {

    // Function to calculate the number represented by the linked list
    public static int getNumberFromList(ListNode head) {
        int number = 0;
        int place = 1;  // To manage the place value (1, 10, 100, etc.)
        
        ListNode current = head;
        while (current != null) {
            number += current.val * place;
            place *= 10;  // Move to the next place value (units, tens, hundreds...)
            current = current.next;
        }
        
        return number;
    }

    // Function to sum two numbers represented by linked lists
    public static int sumOfTwoLists(ListNode list1, ListNode list2) {
        // Get the number from both the lists
        int number1 = getNumberFromList(list1);
        int number2 = getNumberFromList(list2);
        
        // Return the sum of the two numbers
        return number1 + number2;
    }
    
    public static void main(String[] args) {
        // Create the first linked list 6 -> 2 -> 1
        ListNode list1 = new ListNode(6);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(1);
        
        // Create the second linked list 4 -> 5 -> 6
        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(6);
        
        // Calculate the sum
        int result = sumOfTwoLists(list1, list2);
        
        // Output the result
        System.out.println("The sum of the two linked lists is: " + result);
    }
}
```

### Explanation:
1. **ListNode class**: A simple class to represent each node of the linked list. Each node contains an integer value and a reference to the next node.
2. **getNumberFromList()**: A method that takes the head of a linked list and converts it into an integer by traversing the list. It handles the reverse order of digits and calculates the correct value for each place (units, tens, hundreds, etc.).
3. **sumOfTwoLists()**: A method that calls `getNumberFromList()` on both linked lists, adds the resulting numbers, and returns the sum.
4. **main()**: Creates two linked lists, `list1` and `list2`, with sample values, calculates their sum, and prints the result.

### Output:
For the input linked lists:
- List1: `6 -> 2 -> 1` (Representing the number 621)
- List2: `4 -> 5 -> 6` (Representing the number 456)

The output will be:
```
The sum of the two linked lists is: 1077
```

### TL;DR:
- Traverse the linked lists, construct the corresponding numbers, and add them together.
- Return the sum of the two linked list values.