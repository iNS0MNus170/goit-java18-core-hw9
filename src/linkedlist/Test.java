package linkedlist;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("hello");
        list.add("go it");
        list.add("java");

        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get(1) = " + list.get(1));

        //list.get(невалідний індекс) || list.remove(невалідний індекс); - помилка: IndexOutOfBoundsException: Index "current index" out of bounds for length 3

        list.remove(1);

        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());

        list.clear();

        System.out.println("list.size() = " + list.size());

        for (int i = 0; i < 100; i++) {
            list.add("" + i);
        }
        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());


    }
}
