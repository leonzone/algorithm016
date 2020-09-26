import java.util.*;
/**
 * @author: reiserx
 * Date:2020/9/12
 * Des: 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 */
 ```java
public class TestDeque{
    public static void main(String[] args) {
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

}
```