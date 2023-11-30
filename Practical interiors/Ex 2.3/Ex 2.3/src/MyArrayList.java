import java.util.Objects;

public class MyArrayList {
    private Object[] array = new Object[10];
    private static final int CAPACITY = 10;
    private int size = 0;

    public MyArrayList() {
    }

    public void ensureCapacity() {
        if (this.size > this.array.length) {
            int newCapacity = this.array.length * 2;
            Plane[] newArray = new Plane[newCapacity];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.array = newArray;
        }
    }

    public void add(Plane plane) {
        ensureCapacity();
        this.array[this.size] = plane;
        ++this.size;
    }

    public void add(int index, Plane element) {
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public void addAll(Plane[] elements) {
        ensureCapacity();
        System.arraycopy(elements, 0, array, size, elements.length);
        size += elements.length;
    }

    public void addAll(int index, Plane[] elements) {
        Objects.checkIndex(index, size);
        ensureCapacity();
        System.arraycopy(array, index, array, index + elements.length, size - index);
        System.arraycopy(elements, 0, array, index, elements.length);
        size += elements.length;
    }

    public Plane remove(int index) {
        Plane removeElement = (Plane) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        --size;
        return removeElement;
    }

    public Plane get(int index) {
        return (Plane) array[index];
    }

    public int size() {
        return size;
    }
}
