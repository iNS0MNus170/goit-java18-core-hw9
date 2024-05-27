package queue;

public class Test {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(-123);
        myQueue.add(0);
        myQueue.add(2123);
        myQueue.add(Integer.MAX_VALUE);
        myQueue.add(Integer.MIN_VALUE);

        System.out.println("myQueue = " + myQueue);
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue = " + myQueue);

        while (myQueue.size() > 0) {
            System.out.println("myQueue.poll() = " + myQueue.poll());
        }

        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue = " + myQueue);
        System.out.println("myQueue.peek() = " + myQueue.peek()); // якщо size 0 - то вивід буде null;
        System.out.println("myQueue.poll() = " + myQueue.poll()); // якщо size = 0 - то вивід буде null;

        for (int i = 0; i < 100; i++) {
            myQueue.add(i);
        }

        System.out.println("myQueue = " + myQueue);
        myQueue.clear();
        System.out.println("myQueue = " + myQueue);
        System.out.println("myQueue.size() = " + myQueue.size());

    }
}
