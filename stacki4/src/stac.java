import java.util.EmptyStackException;

public class stac implements stack<Integer> {

    // Неизменяемый узел стека с конструктором
    private record Node(int val, int currentMin, Node next) {}

    private Node head;

    @Override
    public void push(Integer item) {
        int minimum = (head == null) ? item : Math.min(item, head.currentMin());
        head = new Node(item, minimum, head);
    }

    @Override
    public Integer pop() {
        ensureNotEmpty();
        int value = head.val();
        head = head.next();
        return value;
    }

    @Override
    public Integer top() {
        ensureNotEmpty();
        return head.val();
    }

    @Override
    public Integer min() {
        ensureNotEmpty();
        return head.currentMin();
    }

    private void ensureNotEmpty() {
        if (head == null) {
            throw new EmptyStackException();
        }
    }
}