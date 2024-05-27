package hashmap;

public class Test {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        System.out.println(map);

        map.put(2, "two two");
        map.put(4, "four four");
        System.out.println(map);
        System.out.println("map.size() = " + map.size());

        System.out.println("map.get(1) = " + map.get(1));
        System.out.println("map.get(4) = " + map.get(4));
        System.out.println("map.get(5) = " + map.get(5)); //null

        map.remove(1);
        map.remove(10);
        System.out.println(map);
        System.out.println("map.size() = " + map.size());

        System.out.println("map = " + map);
        System.out.println("map.size() = " + map.size());

        map.clear();
        System.out.println("map.size() = " + map.size());
        System.out.println("map = " + map);

        for (int i = 0; i < 100; i++) {
            map.put(i, "" + i);
        }
        System.out.println(map);
        System.out.println("map.size() = " + map.size());

    }
}
