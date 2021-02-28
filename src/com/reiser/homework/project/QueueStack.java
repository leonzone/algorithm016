package com.reiser.homework.project;

import java.util.*;

/**
 * @author: reiserx
 * Date:2021/2/28
 * Des:
 */
public class QueueStack {

    public static void main(String[] args) {
//        stack();
//        queue();
//        dequeue();
        priorityQueue();
    }

    // stack 先进先出
    private static void stack() {
        Stack<Integer> stack = new Stack<>();
        Deque stack2 = new ArrayDeque();
        Deque stack3 = new LinkedList();

        stack.push(1);
        stack.pop();
        stack.peek();

        stack2.push(1);// 等于  stack2.addFirst(1);
        stack2.pop(); // 等于 stack2.removeFirst();
        stack2.peek();// 等于 stack2.peekFirst();


    }

    //queue 先进后出
    private static void queue() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);// offerLast(e)
        queue.peek();// peekFirst()
        queue.poll();//pollFirst()
        // 下面一组方法功能和上一组相同，只是异常时会抛出异常
        queue.add(1);//addLast(e)
        queue.element();//getFirst()
        queue.remove();//removeFirst()
    }

    //双端队列
    private static void dequeue() {
        Deque deque = new ArrayDeque();

        deque.push(1); //addFirst
        deque.pop();  //removeFirst();

        deque.offer(1); //offerLast
        deque.poll(); //pollFirst()

    }

    private static void priorityQueue() {

        // 默认是升序，这也是小顶堆的 Java 工程实现，求 Top K 最大
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        //实现降序就是 ab 反过来，构建大顶堆
        // PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
