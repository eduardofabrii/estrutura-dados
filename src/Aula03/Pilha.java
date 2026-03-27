package Aula03;

public class Pilha<T> {
    private int size;
    private Node<T> top;

    public Pilha() {
        this.size = 0;
        this.top = null;
    }

    public void push(T e) {
        Node<T> novoNode = new Node<T>();
        novoNode.data = e;
        novoNode.next = this.top;
        this.top = novoNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) return null;
        T valorRemovido = top.data;
        this.top = top.next;
        size--;
        return valorRemovido;
    }

    public T top() {
        if (isEmpty()) return null;
        T valorEspiado = top.data;
        return valorEspiado;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.top = null;
        this.size = 0;
    }

    public T[] toArray() {
        T[] novoArray = (T[]) new Object[size];
        Node<T> noAtual = top;
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
        Node<T> noAtual = top;
        while (noAtual != null) {
            string += noAtual.data;
            if (noAtual.next != null) {
                string += " - ";
            }
            noAtual = noAtual.next;
        }
        return string;
    }
}