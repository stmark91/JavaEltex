import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        TreeSet<Integer> b = new TreeSet<>();
        LinkedList<Integer> c = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i <1e7; i++) {
            a.add(i);
            b.add(i);
            c.add(i);
        }
        long startTime = System.nanoTime();
        a.add(10000);
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        startTime = System.nanoTime();
        b.add(10000);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        startTime = System.nanoTime();
        c.add(10000);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        startTime = System.nanoTime();
        a.remove(2);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        startTime = System.nanoTime();
        b.remove(2);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        startTime = System.nanoTime();
        c.remove(2);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }
}
