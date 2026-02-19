public interface List<E> {

    Boolean add(E e);                 // Appends the specified element to the end of this list
    void add(int index,E element);    // Inserts the specified element at the specified position in this list
    void clear();                     // Removes all of the elements from this list
    E remove(int index);              // Removes the element at the specified position in this list
    Boolean remove(Object o);         // Removes the first occurrence of the specified element from this list
    int size();                       // Returns the number of elements in this list
    String toString();                // Returns a string representation of this list

}
