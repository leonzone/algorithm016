package com.reiser.homework.queue._641;

import java.util.*;

/**
 * @author: reiserx
 * Date:2020/9/12
 * Des:
 */
public class Test {

    public static void main(String[] args) {
        testStack();
        testQueue();
        testDeque();

    }

    /**
     * https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
     */
    private static void testDeque() {
        Deque<String> deque = new LinkedList<>();


        deque.offerLast("a1");
        deque.offerLast("a2");
        deque.offerLast("a3");
        deque.offerFirst("b1");
        deque.offerFirst("b2");
        deque.offerFirst("b3");

        System.out.println(deque);

        String peekFirst = deque.peekFirst();
        System.out.println(peekFirst);
        System.out.println(deque);

        String peekLast = deque.peekLast();
        System.out.println(peekLast);
        System.out.println(deque);

        String pollFirst = deque.pollFirst();
        System.out.println(pollFirst);
        System.out.println(deque);

        String pollLast = deque.pollLast();
        System.out.println(pollLast);
        System.out.println(deque);


    }

    /**
     * https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
     */
    public static void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(4));

        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.search(4));
    }

    /**
     * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
     */
    public static void testQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println(queue);

        String pollElement = queue.poll();
        System.out.println(pollElement);
        System.out.println(queue);

        String peekElement = queue.peek();
        System.out.println(peekElement);
        System.out.println(queue);

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }
}
