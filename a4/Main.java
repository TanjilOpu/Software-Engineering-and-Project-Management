import java.util.*;

public class Main {
    public static void main(String[] args) {

        // LinkedList
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.addFirst("Start");
        System.out.println("LinkedList: " + list);

        // PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
//        System.out.println("PriorityQueue (smallest first): " + pq.poll());
        System.out.println("PriorityQueue remaining: " + pq);

        // Deque
        Deque<String> dq = new ArrayDeque<>();
        dq.addFirst("Front");
        dq.addLast("Back");
        dq.addLast("this going to the last");
        System.out.println("Deque: " + dq);

        // HashMap
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(2, "Two");
        hm.put(1, "One");
        hm.put(3, "threes");
        hm.put(50, "Fifty");
        hm.put(7, "Seven");
        hm.put(99, "Ninety-Nine");
//        System.out.println(hm);

        System.out.println("HashMap (no order): " + hm);

        // TreeMap
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(2, "Two");
        tm.put(1, "One");
        System.out.println("TreeMap (sorted): " + tm);

        // HashSet
        HashSet<Integer> hs = new HashSet<>();
        hs.add(10);
        hs.add(20);
        hs.add(10); // duplicate, ignored
        hs.add(30);
        System.out.println("HashSet (unique): " + hs);
    }
}
