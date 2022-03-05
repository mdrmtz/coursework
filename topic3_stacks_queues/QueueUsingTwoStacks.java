import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    private static final int ADD_ELEMENT = 1;
    private static final int DEQUEUE_ELEMENT = 2;
    private static final int PRINT_ELEMENT = 3;
    /*
        10      q = 10 (number of queries)
        1 42    1st query, enqueue 42
        2       dequeue front element
        1 14    enqueue 42
        3       print the front element
        1 28    enqueue 28
        3       print the front element
        1 60    enqueue 60
        1 78    enqueue 78
        2       dequeue front element
        2       dequeue front element
     */
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int command = in.nextInt();
            switch (command) {
                case ADD_ELEMENT -> {
                    int element = in.nextInt();
                    queue.addToQueue(element);
                }
                case DEQUEUE_ELEMENT -> queue.dequeue();
                case PRINT_ELEMENT -> queue.printElementAtFront();
            }
        }
    }

    /**
    * Simple things first. Let's see how this would look like using an actual Java Queue, so we
    * have the API ready. After that, we can migrate to using two stacks as a queue.
    */
    static class MeQueue {
        private final Queue<Integer> mQueue;

        public MeQueue() {
            mQueue = new LinkedList<>();
        }

        public void addToQueue(int element) {
            mQueue.add(element);
        }

        public void dequeue() {
            mQueue.remove();
        }

        public void printElementAtFront() {
            System.out.println(mQueue.peek());
        }
    }

    /**
    * Ahora vamos a pensar cuales son todos los comandos que podemos ejecutar con
    * una Stack, https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
    * La siempre que tengamos que remover un elemento, este estará al final de
    * la Stack. Podemos volcar todos los elementos en la segunda stack, para
    * poder acceder al ultimo. Solo tenemos que hacer esto cuando se ejecute
    * dequeue.
    */
    static class MyQueue {
        private final Stack<Integer> stackOne;
        private final Stack<Integer> stackTwo;

        public MyQueue() {
            stackOne = new Stack<>();
            stackTwo = new Stack<>();
        }

        public void addToQueue(int element) {
          stackOne.push(element);
        }

        public void dequeue() {
          if (stackTwo.isEmpty()) {
            changeQueues(stackOne, stackTwo);
          }
          stackTwo.pop();
        }

        public void printElementAtFront() {
          if (stackTwo.isEmpty()) {
            changeQueues(stackOne, stackTwo);
          }
          System.out.println(stackTwo.peek());
        }

        private void changeQueues(Stack<Integer> stackOne, Stack<Integer> stackTwo) {
            while (!stackOne.empty()) {
                stackTwo.push(stackOne.pop());
            }
        }
    }
}
