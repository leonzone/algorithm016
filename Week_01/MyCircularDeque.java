package com.reiser.homework.queue;

/**
 * @author: reiserx
 * Date:2020/9/13
 * Des:
 */
public class MyCircularDeque {
    int max;
    int count;
    Node firstNode = null;
    Node lastNode = null;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        max = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {

        if (count >= max) {
            return false;
        }
        Node tmp = firstNode;
        Node newNode = new Node(null, value, firstNode);
        firstNode = newNode;
        if (tmp == null) {
            lastNode = newNode;
        } else {
            tmp.prev = newNode;
        }

        count++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (count >= max) {
            return false;
        }
        Node tmp = lastNode;
        Node newNode = new Node(lastNode, value, null);
        lastNode = newNode;
        if (tmp == null) {
            firstNode = newNode;
        } else {
            tmp.next = newNode;
        }
        count++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (count == 0 && firstNode == null) {
            return false;
        }
        Node l = firstNode;
        Node next = firstNode.next;
        l.next = null;
        firstNode = next;
        if (next == null) {
            lastNode = null;
        } else {
            next.prev = null;
        }
        count--;
        return true;

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (count == 0 && lastNode == null) {
            return false;
        }
        Node l = lastNode;
        Node prev = lastNode.prev;
        l.prev = null;
        lastNode = prev;
        if (prev == null) {
            firstNode = null;
        } else {
            prev.next = null;
        }
        count--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (count == 0) {
            return -1;
        }
        return firstNode == null ? lastNode.item : firstNode.item;


    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (count == 0) {
            return -1;
        }
        return lastNode == null ? firstNode.item : lastNode.item;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return count == max;
    }


    private static class Node {
        int item;
        Node next;
        Node prev;

        Node(Node prev, int element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


//    ["MyCircularDeque","insertFront","deleteLast","deleteLast","insertLast","getRear","insertLast","isFull","getRear","isFull","deleteLast","isEmpty","getFront","isEmpty","insertFront","isEmpty","insertLast","getRear","getFront","deleteLast","deleteLast","insertLast","insertLast","deleteLast","getFront","insertLast","isEmpty","getFront","insertFront","insertLast","insertFront","deleteLast","getRear","getRear","insertFront","insertLast","deleteFront","getFront","getFront","insertLast","getFront","getFront","insertFront","getFront","deleteFront","deleteFront","deleteFront","insertLast","getRear","insertFront","isFull","insertLast","deleteLast","getRear","deleteLast","getRear","insertFront","deleteLast","insertLast","insertLast","getFront","getRear","insertFront","insertLast","insertLast","insertFront","getRear","getRear","deleteLast","insertFront","getFront","insertFront","insertLast","getRear","insertFront","insertLast","deleteFront","isEmpty","getRear","insertLast","insertFront","getFront","getRear","insertFront","insertLast","deleteLast","deleteLast","isFull","insertLast","deleteLast","deleteFront","insertFront","getRear","isFull","deleteFront","getFront","getRear","isEmpty","getFront","deleteLast","getRear","insertLast"]
//            [[71],[47],[],[],[66],[],[72],[],[],[],[],[],[],[],[53],[],[15],[],[],[],[],[9],[87],[],[],[98],[],[],[33],[40],[21],[],[],[],[69],[14],[],[],[],[60],[],[],[15],[],[],[],[],[97],[],[66],[],[23],[],[],[],[],[30],[],[54],[18],[],[],[50],[24],[24],[25],[],[],[],[0],[],[86],[31],[],[55],[55],[],[],[],[18],[49],[],[],[53],[44],[],[],[],[46],[],[],[58],[],[],[],[],[],[],[],[],[],[61]]
//    [null,true,true,false,true,66,true,false,72,false,true,false,66,false,true,false,true,15,53,true,true,true,true,true,53,true,false,53,true,true,true,true,98,98,true,true,true,21,21,true,21,21,true,15,true,true,true,true,97,true,false,true,true,97,true,60,true,true,true,true,30,18,true,true,true,true,24,24,true,true,0,true,true,31,true,true,true,false,55,true,true,49,18,true,true,true,true,false,true,true,true,true,55,false,true,49,55,false,49,true,31,true]

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(71); // 设置容量大小为3
        System.out.println(circularDeque.insertFront(47));                    // 返回 true
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertLast(66));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertLast(72));
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.isEmpty());
        System.out.println(circularDeque.getFront());

    }

}
