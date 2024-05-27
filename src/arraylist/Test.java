package arraylist;

public class Test {
    public static void main(String[] args) {
        MyArrayList<Double> list = new MyArrayList<>();
        list.add(0.3);
        list.add(3.3);
        list.add(-12.23);

        System.out.println("list = " + list);
        System.out.println("(list.size()) = " + (list.size()));

        // list.remove(невалідний індекс); програма впаде з помилкою - "невірний індекс, в списку доступні індекси від 0 до 2"

        list.remove(1);
        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());

        //list.get(невалідний індекс); програма впаде з помилкою - "невірний індекс, в списку доступні індекси від 0 до 1"

        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));

        list.clear();
        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());

        // list.get(будь-який індекс)||list.remove(будь-який індекс); програма впаде з помилкою - "список порожній";

        for (double i = 0.1; i < 100; i += 1.4) {
            list.add(i);
        }
        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());

    }
}