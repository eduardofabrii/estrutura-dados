package Aula02;

public class ArrayList<T> {
    private T[] data;
    private int capacity;
    private int size;

    public ArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.data = (T[]) new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.capacity = 0;
    }

    public void add(T t) {
        if (capacity == size) {
            System.out.println("Lista cheia");
            return;
        }

        data[size] = t;
        size++;
    }

    public void add(int index, T t) {
        data[index] = t;
    }

    public void remove(int index) {
        data[index] = null;
    }

    public void remove(T t) {
        for (int i = 0; i < capacity; i++) {
            if (t.equals(data[i])) {
                remove(i);
            }
        }
    }

    public void set(int index, T t) {
        data[index] = t;
    }

    public T get(int index) {
        return data[index];
    }

    public Boolean contains(T t) {
        for (int i = 0; i < capacity;) {
            if (t.equals(data[i]))  {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public int indexOf(T t) {
        for (int i = 0; i < capacity; i++) {
            if (data[i] != null && data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public T[] toArray() {
        T[] novoArray = (T[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            novoArray[i] = data[i];
        }
        return novoArray;
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();

        array1.add("array");
        array1.print();

        System.out.println(" ");
        System.out.println(array1.contains("array"));

        System.out.println(" ");

        System.out.println(array1.indexOf("aaa"));
        System.out.println(" ");

        System.out.println(array1.get(0));
        System.out.println(" ");

        array1.add(0, "paulo");
        array1.print();

        array1.remove("paulo");
        array1.remove(0);

        array1.print();
    }
}