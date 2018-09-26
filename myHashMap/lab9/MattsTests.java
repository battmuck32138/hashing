package lab9;

import java.util.Iterator;

public class MattsTests {
    public static void main(String[] args) {
        BSTMap<Character, Integer> bm = new BSTMap<>();
        MyHashMap<Character, Integer> hm = new MyHashMap<>();
        System.out.println("size: " + bm.size());
        bm.put('d', 3);
        System.out.println("size: " + bm.size());
        bm.put('a', 0);
        System.out.println("size: " + bm.size());
        bm.put('b', 1);
        System.out.println("size: " + bm.size());
        bm.put('c', 5);
        System.out.println("size: " + bm.size());
        bm.put('c', 2);
        System.out.println("size: " + bm.size());
        System.out.println("get('c') = 2 =  " + bm.get('c'));
        System.out.println("size: " + bm.size());
        bm.put('f', 5);
        System.out.println("size: " + bm.size());
        bm.displayBSTMap();
        bm.put('l', 5);
        bm.put('A', 5);
        bm.put('q', 5);
        bm.put('z', 5);
        System.out.println("size: " + bm.size());
        Iterator iter = bm.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }


    }

}
