package com.prac.core.algo;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
} //Node

class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }

        Node node = new Node(key, value);

        if (cache.size() == capacity) {
            cache.remove(tail.key);
            removeNode(tail);
        }

        cache.put(key, node);
        addFirst(node);
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode;
        }
    }

    private void addFirst(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = node;
        }
    }
    
    public void printCache() {
    	System.out.println("Map Size: "+cache.size()+" -- "+cache+"\n");
    	
		/*
		 * for(Map.Entry mapEntry : cache.entrySet()) { Node node =
		 * cache.get(mapEntry.getKey());
		 * System.out.println(mapEntry.getKey()+"--"+node.value); }
		 */
    }
} //LRUCache

class LRUCacheStack {
    public static void main(String[] args) {
    	
    	LRUCache cache = new LRUCache(3);

    	System.out.println("put(5, 7) ");
    	cache.put(5, 7);
    	cache.printCache();
    	
    	System.out.println("put(8, 20) ");
    	cache.put(8, 20);
    	cache.printCache();
    	
    	System.out.println("get(5): "+cache.get(5));       // returns 7
    	cache.printCache();
    	
    	System.out.println("put(3, 6) ");
    	cache.put(3, 6);    // evicts key 8
    	cache.printCache();
    	
    	System.out.println("get(8): "+cache.get(8));       // returns -1 (not found)
    	cache.printCache();
    	
    	System.out.println("put(4, 12) ");
    	cache.put(4, 12);   // evicts key 5
    	cache.printCache();
    	
    	System.out.println("get(5): "+cache.get(5));       // returns -1 (not found)
    	cache.printCache();
    	
    	System.out.println("get(3): "+cache.get(3));       // returns 6
    	cache.printCache();
    	
    	System.out.println("get(4): "+cache.get(4));       // returns 12
    	cache.printCache();
    	
    	/*
        Scanner keyboard = new Scanner(System.in);

        int capacity = keyboard.nextInt();
        LRUCache cache = new LRUCache(capacity);

        while (true) {
            String[] commandLine = keyboard.nextLine().trim().split("\\s");
            String command = commandLine[0];
            if (command.isEmpty()) {
                continue;
            }
            switch (command) {
            case "get": {
                int num = Integer.parseInt(commandLine[1]);
                System.out.println(cache.get(num));
                break;
            }
            case "put": {
                int key = Integer.parseInt(commandLine[1]);
                int value = Integer.parseInt(commandLine[2]);
                cache.put(key, value);
                break;
            }
            case "exit": {
                return;
            }
            default:
                System.out.println("Invalid command");
            }
        } 
    	 */
    }
} //LRUCacheExample

/* LRU Implementaion:  https://www.callicoder.com/design-lru-cache-data-structure/ */