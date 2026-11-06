public interface stack<T extends Number> {
    void push(T value);

    T pop();

    T top();

    T min();
}
