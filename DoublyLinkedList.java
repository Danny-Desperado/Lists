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
        Node current = new Node(e);
        if(head == null) {
            head = tail = current;
        } else {
            current.prev = tail;
            tail.next = current;
            tail = current;
        }
        size++;
        return true;
    }

        @Override
    public void add(int index, E element) {
        if(index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
    
        if(index >= size) {
            add(element);
            return;
        }
    
        if(index == 0) {
            Node current = new Node(element);
            current.next = head;
            head.prev = current;
            head = current;
            size++;
            return;
        }
    
        Node current = new Node(element);
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
    
        current.prev = temp.prev;
        current.next = temp;
        temp.prev.next = current;
        temp.prev = current;
        size++;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

        @Override
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    
        if(index == 0) {
            E removed = head.data;
            head = head.next;
            if(head != null)
                head.prev = null;
            else
                tail = null;
            size--;
            return removed;
        }
    
        if(index == size - 1) {
            E removed = tail.data;
            tail = tail.prev;
            if(tail != null)
                tail.next = null;
            else
                head = null;
            size--;
            return removed;
        }
    
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        E removed = temp.data;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return removed;
    }

        @Override
    public Boolean remove(Object o) {
        Node temp = head;
    
        while(temp != null) {
            if(temp.data.equals(o)) {
    
                if(temp == head && temp == tail) {
                    head = null;
                    tail = null;
    
                } else if(temp == head) {
                    head = head.next;
                    head.prev = null;
    
                } else if(temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
    
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
    
                size--;
                return true;
            }
            temp = temp.next;
        }
    
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(size == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node temp = head;
        while(temp != null) {
            sb.append(temp.data);
            if(temp.next != null) sb.append(",");
            temp = temp.next;
        }

        sb.append("]");
        return sb.toString();
    }
    
}
