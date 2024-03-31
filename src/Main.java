import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        boolean isMinHeap = false;
        Heap heap = new Heap(isMinHeap);
        heap.add(5);
        heap.add(1);
        heap.add(2);
        heap.add(9);
//        heap.printHeap();
//        heap.poll();
        while(!heap.isEmpty()) System.out.println(heap.poll());
//        System.out.println(heap.peek());
    }
}
