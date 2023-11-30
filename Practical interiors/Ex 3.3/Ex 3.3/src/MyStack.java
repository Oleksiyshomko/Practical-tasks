
public class MyStack<T> {
    private final MyLinkedList<T> myLinkedList = new MyLinkedList<>();

    public MyStack() {
    }

    public void push(T element) {
        myLinkedList.addFirst(element);
    }

    public T pop() {
        return myLinkedList.removeFirst();
    }
}