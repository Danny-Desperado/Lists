public class DoublyLinkedList<E> implements List<E>{

    private class Node {
        E data;
        Node next;
        Node prev;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Boolean add(E e) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Boolean remove(Object o) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
    
}
    