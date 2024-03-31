import java.util.ArrayList;
import java.util.List;

class Heap {
    private List<Integer> heap;
    private boolean isMinHeap = true;

    public Heap() {
        heap = new ArrayList<>();
    }

    public Heap(boolean isMinHeap) {
        heap = new ArrayList<>();
        this.isMinHeap = isMinHeap;
    }

    private void heapify(List<Integer> heap, int index, int lastIndex) {
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;
        int minIndex = index;
        if (leftChild <= lastIndex && (isMinHeap ? (heap.get(leftChild) < heap.get(minIndex)) : (heap.get(leftChild) > heap.get(minIndex))))
            minIndex = leftChild;
        if (rightChild <= lastIndex && (isMinHeap ? (heap.get(rightChild) < heap.get(minIndex)) : (heap.get(rightChild) > heap.get(minIndex))))
            minIndex = rightChild;
        if (minIndex != index) {
            int temp = heap.get(index);
            heap.set(index, heap.get(minIndex));
            heap.set(minIndex, temp);
            heapify(heap, minIndex, lastIndex);
        }
    }

    private void heapifyTillTop(int child) {
        int parent = child / 2;
        while (isMinHeap ? (heap.get(parent) > heap.get(child)) : (heap.get(parent) < heap.get(child))) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(child));
            heap.set(child, temp);
            child = parent;
            parent = child / 2;
        }
        heapify(heap, 0, heap.size() - 1);
    }

    public void printHeap() {
        List<Integer> tempList = new ArrayList<>(heap);
        int n = tempList.size() - 1;
        while (n > 0) {
            int temp = tempList.get(n);
            tempList.set(n, tempList.get(0));
            tempList.set(0, temp);
            n--;
            heapify(tempList, 0, n);
        }
        for (int i = tempList.size() - 1; i >= 0; i--) System.out.print(tempList.get(i) + ", ");
        System.out.println();
    }

    public boolean add(int element) {
        heap.add(element);
        heapifyTillTop(heap.size() - 1);
        return true;
    }

    public int peek() {
        if (heap.size() == 0) {
            System.out.println("ERROR : Heap is Empty");
            throw new IllegalStateException();
        }
        return heap.get(0);
    }

    public int poll() {
        if (heap.size() == 0) {
            System.out.println("ERROR : Heap is Empty");
            throw new IllegalStateException();
        }
        int top = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(heap, 0, heap.size() - 1);
        return top;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}
