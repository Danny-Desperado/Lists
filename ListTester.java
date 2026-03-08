import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class ListTester {

    public static void main(String[] args) throws FileNotFoundException {

        int[] Ns = {10, 100, 1000, 10000, 100000, 1000000};
        Random rand = new Random();

        PrintStream console = System.out;
        PrintStream out = new PrintStream(new FileOutputStream("testrun.txt"));
        System.setOut(new PrintStream(new FileOutputStream("testrun.txt")) {
            @Override public void println(String x) { super.println(x); console.println(x); }
            @Override public void print(String x)   { super.print(x);   console.print(x);   }
        });

        for (int N : Ns) {
            System.out.println("\n==================================");
            System.out.println("  Testing N = " + N);
            System.out.println("======================================");

            testCustomList("MyArrayList",  new ArrayList<Integer>(),       N, rand);
            testCustomList("MyLinkedList", new DoublyLinkedList<Integer>(), N, rand);
            testJavaList("Java ArrayList", new java.util.ArrayList<Integer>(),  N, rand);
            testJavaList("Java LinkedList",new java.util.LinkedList<Integer>(), N, rand);
        }
    }

    private static void testCustomList(String name, List<Integer> list, int N, Random rand) {
        System.out.println("\n  ── [" + name + "] ──");

        // INSERT AT START
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(0, rand.nextInt(2 * N));
        printTime("Insert @ start ", start);

        // INSERT AT END
        list.clear();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(rand.nextInt(2 * N));
        printTime("Insert @ end   ", start);

        // INSERT AT RANDOM
        list.clear();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            int index = list.size() == 0 ? 0 : rand.nextInt(list.size());
            list.add(index, rand.nextInt(2 * N));
        }
        printTime("Insert @ random", start);

        // REMOVE FROM START
        fillCustom(list, N, rand);
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.remove(0);
        printTime("Remove @ start ", start);

        // REMOVE FROM END
        fillCustom(list, N, rand);
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.remove(list.size() - 1);
        printTime("Remove @ end   ", start);

        // REMOVE AT RANDOM
        fillCustom(list, N, rand);
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            if (list.size() == 0) break;
            list.remove(rand.nextInt(list.size()));
        }
        printTime("Remove @ random", start);

        // REMOVE BY VALUE
        fillCustom(list, N, rand);
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.remove((Object) rand.nextInt(2 * N));
        printTime("Remove @ value ", start);
    }

    private static void testJavaList(String name, java.util.List<Integer> list, int N, Random rand) {
        System.out.println("\n  ── [" + name + "] ──");

        // INSERT AT START
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(0, rand.nextInt(2 * N));
        printTime("Insert @ start ", start);

        // INSERT AT END
        list.clear();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(rand.nextInt(2 * N));
        printTime("Insert @ end   ", start);

        // INSERT AT RANDOM
        list.clear();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            int index = list.size() == 0 ? 0 : rand.nextInt(list.size());
            list.add(index, rand.nextInt(2 * N));
        }
        printTime("Insert @ random", start);

        // REMOVE FROM START
        fillJava(list, N, rand);
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.remove(0);
        printTime("Remove @ start ", start);

        // REMOVE FROM END
        fillJava(list, N, rand);
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.remove(list.size() - 1);
        printTime("Remove @ end   ", start);

        // REMOVE AT RANDOM
        fillJava(list, N, rand);
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            if (list.size() == 0) break;
            list.remove(rand.nextInt(list.size()));
        }
        printTime("Remove @ random", start);

        // REMOVE BY VALUE
        fillJava(list, N, rand);
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.remove((Object)(Integer) rand.nextInt(2 * N));
        printTime("Remove @ value ", start);
    }

    private static void fillCustom(List<Integer> list, int N, Random rand) {
        list.clear();
        for (int i = 0; i < N; i++) list.add(rand.nextInt(2 * N));
    }

    private static void fillJava(java.util.List<Integer> list, int N, Random rand) {
        list.clear();
        for (int i = 0; i < N; i++) list.add(rand.nextInt(2 * N));
    }

    private static void printTime(String operation, long startNano) {
        double ms = (System.nanoTime() - startNano) / 1_000_000.0;
        System.out.printf("    %-20s : %.4f ms%n", operation, ms);
    }
}