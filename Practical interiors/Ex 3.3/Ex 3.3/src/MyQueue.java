public class MyQueue<T> {
    private final MyLinkedList<T> myLinkedList = new MyLinkedList<>();

    public MyQueue() {
    }

    public void offer(T e) {
        myLinkedList.add(e);
    }

    public T peek() {
        return myLinkedList.getFirst();
    }
}