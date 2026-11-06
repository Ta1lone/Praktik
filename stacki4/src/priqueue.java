import java.util.ArrayList;
import java.util.List;

public class priqueue implements queue<Integer> {

    private static class HeapItem {
        int priority;
        long id;

        HeapItem(int priority, long id) {
            this.priority = priority;
            this.id = id;
        }
    }

    private List<HeapItem> heap = new ArrayList<>();
    private long globalTicker = 0;

    @Override
    public void enqueue(Integer value) {
        long currentTicket = ++globalTicker;
        heap.add(new HeapItem(value, currentTicket));
        bubbleUp(heap.size() - 1);
    }

    @Override
    public Integer dequeueMax() {
        if (heap.isEmpty()) {
            System.out.println("*");
            return null;
        }

        HeapItem top = heap.get(0);
        HeapItem tail = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, tail);
            bubbleDown(0);
        }

        System.out.println(top.id + " " + top.priority);
        return top.priority;
    }

    @Override
    public void increment(long operation, Integer addition) {
        for (int i = 0; i < heap.size(); i++) {
            HeapItem target = heap.get(i);
            if (target.id == operation) {
                target.priority += addition;
                rebalance(i);
                return;
            }
        }
    }

    private void rebalance(int idx) {
        bubbleUp(idx);
        bubbleDown(idx);
    }

    private void bubbleUp(int idx) {
        while (idx > 0) {
            int parentIdx = (idx - 1) >> 1;
            if (heap.get(idx).priority <= heap.get(parentIdx).priority) {
                break;
            }
            swap(idx, parentIdx);
            idx = parentIdx;
        }
    }

    private void bubbleDown(int idx) {
        int heapSize = heap.size();
        while (true) {
            int left = (idx << 1) + 1;
            int right = left + 1;
            int dominant = idx;

            if (left < heapSize && heap.get(left).priority > heap.get(dominant).priority) {
                dominant = left;
            }
            if (right < heapSize && heap.get(right).priority > heap.get(dominant).priority) {
                dominant = right;
            }

            if (dominant == idx) {
                break;
            }

            swap(idx, dominant);
            idx = dominant;
        }
    }

    private void swap(int i, int j) {
        HeapItem temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}