package stack;

public class Test {
    public static void main(String[] args) {
        MyStack<Long> myStack = new MyStack<>();
        myStack.push(12L);
        myStack.push(Long.MAX_VALUE);
        myStack.push(Long.MIN_VALUE);
        myStack.push(100_000_000_000L);
        myStack.push(-123_456_789L);

        System.out.println("myStack = " + myStack);
        System.out.println("myStack.size() = " + myStack.size());
        System.out.println("myStack.peek() = " + myStack.peek());

        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack = " + myStack);
        System.out.println("myStack.size() = " + myStack.size());

        myStack.remove(2);
        myStack.remove(0);
        System.out.println("myStack = " + myStack);
        System.out.println("myStack.size() = " + myStack.size());

        myStack.clear();
        System.out.println("myStack = " + myStack);
        System.out.println("myStack.size() = " + myStack.size());

        //myStack.pop(); - коли стек порожній, програма викине EmptyStackException.
        // myStack.remove(не валідний індекс); - програма викине IndexOutOfBoundsException.
        //myStack.peek();- коли стек порожній, програма викине EmptyStackException.

        for (int i = 100_000_000; i > 0; i -= 100_000) {
            myStack.push((long) i);
        }
        System.out.println("myStack = " + myStack);
        System.out.println("myStack.size() = " + myStack.size());

    }
}
