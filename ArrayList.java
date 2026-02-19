public class ArrayList<E> implements List<E>{

    //internal fields
    private E[] data; // The array that stores the elements
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (E[]) new Object[10];    // Start with a default capacity
        size = 0;                       // Empty list at the start 
    }

    @Override
    public Boolean add(E e) {
        if (size == data.length) {
            resize(data.length * 2);   // double the capacity if full
        }
        data[size] = e;
        size++;
        return true;
    }

    private void resize(int newCapacity) {
        @SuppressWarnings("unchecked")
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i]; // copy elements over
        }
        data = newData; // Update reference
    }

    @Override
    public int size(){
        return size;
    }
    
    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size:" + size);
        

        //resize if necessary
        if (size == data.length)
            resize(data.length * 2);

        for(int i = size; i > index; i--){
            data[i] = data[i--];
        }
        data[index] = element;
        size++;
            
    }
    @Override
    public Boolean remove(Object o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String toString() {
        return null;
        
    }
    @Override
    public void clear(){

    }
}
    


