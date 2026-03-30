package Aula04.estruturas;

public class Fila<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public Fila() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void enqueue(T e) {
        Node<T> novo = new Node<T>();
        novo.data = e;
        novo.next = null;

        if (isEmpty()) {
            first = novo;
            last = novo;
        } else {
            last.next = novo;
            last = novo;
        }
        size++;
    }

    public void dequeue() {
        if (isEmpty()) return;
        this.first = this.first.next;
        this.size--;
        if (isEmpty()) this.last = null;
    }

    public T front() {
        if (isEmpty()) return null;
        return this.first.data;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public T[] toArray() {
        T[] novoArray = (T[]) new Object[size];
        Node<T> noAtual = first;
        int i = 0;
        while (noAtual != null) {
            novoArray[i] = noAtual.data;
            noAtual = noAtual.next;
            i++;
        }
        return novoArray;
    }

    public String toString() {
        String string = "";
        Node<T> noAtual = first;
        while (noAtual != null) {
            string += noAtual.data;
            if (noAtual.next != null) {
                string += " - ";
            }
            noAtual = noAtual.next;
        }
        return string;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
