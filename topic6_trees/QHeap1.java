import java.util.*;

public class QHeap1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (q > 0) {
            String[] line = scanner.nextLine().split(" ");
            performOp(line, queue);
            q--;
        }
    }

    private static void performOp(String [] line, PriorityQueue<Integer> pq) {
        switch (Integer.parseInt(line[0])) {
            case 1 -> pq.add(Integer.parseInt(line[1]));
            case 2 -> pq.remove(Integer.parseInt(line[1]));
            case 3 -> System.out.println(pq.peek());
        }
    }
}
