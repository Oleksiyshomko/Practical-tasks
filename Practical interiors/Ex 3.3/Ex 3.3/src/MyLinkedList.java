import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> {
    private Node<T> last;
    private Node<T> first;
    private int size;

    public MyLinkedList() {
    }

    public void add(T element) {
        Node<T> newNode = new Node(element);
        if (this.size == 0) {
            this.first = this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }

        ++this.size;
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node(element);
        if (this.size == 0) {
            this.first = this.last = newNode;
        } else {
            newNode.next = this.first;
            this.first = newNode;
        }

        ++this.size;
    }

    public void add(T element, int index) {
        Objects.checkIndex(index, this.size + 1);
        Node<T> newNode = new Node(element);
        if (this.size == 0) {
            this.first = this.last = newNode;
        } else if (index == 0) {
            newNode.next = this.first;
            this.first = newNode;
        } else if (index == this.size) {
            this.last.next = newNode;
            this.last = newNode;
        } else {
            Node<T> previous = this.getNodeByIndex(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }

        ++this.size;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = this.first;

        for (int i = 0; i < index; ++i) {
            current = current.next;
        }

        return current;
    }

    public void set(int index, T element) {
        Objects.checkIndex(index, this.size);
        Node<T> node = this.getNodeByIndex(index);
        node.element = element;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.size);
        return this.getNodeByIndex(index).element;
    }

    public void displayList() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node<T> current = this.first;
            while (current != null) {
                System.out.println(current.element);
                current = current.next;
            }
        }
    }

    public T getFirst() {
        return this.get(0);
    }

    private boolean isEmpty() {
        return this.first == null;
    }

    public T getLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return this.last.element;
        }
    }

    public T remove(int index) {
        Objects.checkIndex(index, this.size);
        T removedElement;
        if (index == 0) {
            removedElement = this.first.element;
            this.first = this.first.next;
            if (this.first == null) {
                this.last = null;
            }
        } else {
            Node<T> previous = this.getNodeByIndex(index - 1);
            removedElement = previous.next.element;
            previous.next = previous.next.next;
            if (index == this.size - 1) {
                this.last = previous;
            }
        }

        --this.size;
        return removedElement;
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T removedElement = this.first.element;
            this.first = this.first.next;
            if (this.first == null) {
                this.last = null;
            }

            --this.size;
            return removedElement;
        }
    }

    public T removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else if (this.size == 1) {
            T removedElement = this.first.element;
            this.first = this.last = null;
            --this.size;
            return removedElement;
        } else {
            Node<T> previous = this.getNodeByIndex(this.size - 2);
            T removedElement = this.last.element;
            previous.next = null;
            this.last = previous;
            --this.size;
            return removedElement;
        }
    }

    public boolean contains(T element) {
        Node<T> current = this.first;

        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public void clear() {
        this.first = this.last = null;
        this.size = 0;
    }

    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}

